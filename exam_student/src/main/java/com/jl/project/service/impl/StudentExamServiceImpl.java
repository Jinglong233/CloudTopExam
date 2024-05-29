package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.jl.project.entity.dto.SubmitExamDTO;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.ExamResultVO;
import com.jl.project.entity.vo.ExamVO;
import com.jl.project.enums.ExamRecordStateType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.observer.correctObserver.ReviewSubject;
import com.jl.project.service.StudentExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Service("studentExamService")
public class StudentExamServiceImpl implements StudentExamService{
    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;

    @Resource
    private PaperMapper<Paper, PaperQuery> paperMapper;

    // 提交试卷被观察者对象
    @Resource
    private ReviewSubject reviewSubject;


    @Resource
    private ExamRecordMapper<ExamRecord, ExamRecordQuery> examRecordMapper;

    @Resource
    private UserAnswerMapper<UserAnswer, UserAnswerQuery> userAnswerMapper;

    @Resource
    private BookMapper<Book, BookQuery> bookMapper;

    /**
     * 查询考试
     *
     * @param userId
     * @return
     */
    @Override
    public List<ExamVO> loadStudentExamList(String userId) throws BusinessException {
        // 1. 查询该考生所有的考试记录
        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setUserId(userId);
        List<ExamRecord> examRecordList = examRecordMapper.selectList(examRecordQuery);

        if (examRecordList.isEmpty()) {
            return Collections.emptyList();
        }

        List<ExamVO> examVOS = new ArrayList<>();

        // 2. 查询相关考试
        for (ExamRecord examRecord : examRecordList) {
            String examId = examRecord.getExamId();
            ExamQuery examQuery = new ExamQuery();
            examQuery.setId(examId);

            List<Exam> list = examMapper.selectList(examQuery);
            if (list == null || list.size() == 0) {
                return Collections.emptyList();
            }
            for (Exam exam : list) {
                ExamVO examVO = new ExamVO();
                BeanUtil.copyProperties(exam, examVO);
                // 3. 查询关联试卷
                String paperId = exam.getPaperId();
                if (paperId == null || "".equals(paperId)) {
                    throw new BusinessException("关联试卷信息为空");
                }
                Paper paper = paperMapper.selectById(paperId);
                if (paper == null) {
                    throw new BusinessException("关联试卷信息为空");
                }
                examVO.setTotalCount(paper.getTotalCount());
                examVOS.add(examVO);
            }
        }


        return examVOS;
    }

    @Override
    public Boolean submitExam(SubmitExamDTO submitExamDTO) {
        String recordId = submitExamDTO.getExamRecordId();
        ExamRecord oldRecord = examRecordMapper.selectById(recordId);
        if (oldRecord == null) {
            throw new BusinessException("考试记录数据不存在");
        }
        // 1. 获取对应的考试信息
        String examId = oldRecord.getExamId();
        if (examId == null) {
            throw new BusinessException("缺少考试信息");
        }
        Exam exam = examMapper.selectById(examId);
        if (exam == null) {
            throw new BusinessException("缺少考试信息");
        }
        Integer totalScore = 0;


        // 判断是否到达允许提交的最小时间
        Integer handMin = exam.getHandMin();
        if (handMin != 0) {
            Date startTime = exam.getStartTime();
            Date date = new Date();
            if (date.before(DateUtil.offsetMinute(startTime, handMin))) {
                throw new BusinessException("未到最小交卷时间");
            }
        }


        // 2. 修改答卷结束时间
        oldRecord.setEndTime(new Date());

        // 3. 修改记录状态
        oldRecord.setState(ExamRecordStateType.SUBMITTED.getValue());


        // 4. 判断是否需要阅卷
        Integer reviewQuire = exam.getReviewQuire();

        String userId = null;
        // 不需要手动判题；同时可以更新错题统计表
        if (reviewQuire == 0) {
            List<Qu> quList = submitExamDTO.getQuList();
            if (quList == null || quList.isEmpty()) {
                throw new BusinessException("无题目列表信息");
            }
            UserAnswerQuery userAnswerQuery = new UserAnswerQuery();

            List<UserAnswer> wrongList = new ArrayList<>();
            // 4.1 遍历题目列表的题目信息
            for (Qu qu : quList) {
                String quId = qu.getId();
                if (quId == null) {
                    throw new BusinessException("缺少题目信息");
                }
                userAnswerQuery.setExamRecordId(recordId);
                userAnswerQuery.setQuId(quId);
                // 4.2 获取用户该题目的答题记录，获取单题得分
                List<UserAnswer> userAnswerList = userAnswerMapper.selectList(userAnswerQuery);
                if (userAnswerList == null || userAnswerList.isEmpty()) {
                    throw new BusinessException("用户答题记录不存在");
                }
                UserAnswer userAnswer = userAnswerList.get(0);
                Integer score = userAnswer.getScore();
                totalScore += score;
                userId = userAnswer.getUserId();
                if(userAnswer.getIsRight() == 0){
                    // 错题列表
                    wrongList.add(userAnswer);
                }
            }

            // 搜集错题
            reviewSubject.notifyBookUpdate(wrongList);

            // 不需要则设置考试记录状态为已处理
            oldRecord.setHandState(1);
        }

        // 5. 同时修改考试总分、通过情况、阅卷时间
        oldRecord.setTotalScore(totalScore);
        oldRecord.setReviewTime(new Date());
        // 判断是否通过
        Integer qualifyScore = exam.getQualifyScore();
        if (totalScore < qualifyScore) {
            oldRecord.setPassed(0);
        } else {
            oldRecord.setPassed(1);
        }


        // 6. 更新考试记录
        Integer result = examRecordMapper.updateById(oldRecord, recordId);

        if (result <= 0) {
            throw new BusinessException("更新失败");
        }


        return true;
    }

    @Override
    public ExamResultVO getExamResult(String examRecordId) {
        ExamRecord examRecord = examRecordMapper.selectById(examRecordId);
        if (examRecord == null) {
            throw new BusinessException("该考试记录不存在");
        }

        String examId = examRecord.getExamId();
        if (examId == null) {
            throw new BusinessException("考试信息不存在");
        }

        Exam exam = examMapper.selectById(examId);
        if (exam == null) {
            throw new BusinessException("考试信息不存在");
        }

        Integer reviewQuire = exam.getReviewQuire();
        Integer handState = examRecord.getHandState();
        Integer totalScore = examRecord.getTotalScore();

        ExamResultVO examResultVO = new ExamResultVO();
        examResultVO.setIsHandle(handState);
        examResultVO.setTotalScore(Double.valueOf(totalScore));
        examResultVO.setReviewQuire(reviewQuire);
        return examResultVO;
    }
}
