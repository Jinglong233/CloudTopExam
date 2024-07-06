package com.jl.project.observer.correctObserver;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.BookQuery;
import com.jl.project.entity.query.QuQuery;
import com.jl.project.entity.query.RepoQuery;
import com.jl.project.entity.query.WrongAnswerQuery;
import com.jl.project.enums.QuType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.BookMapper;
import com.jl.project.mapper.QuMapper;
import com.jl.project.mapper.RepoMapper;
import com.jl.project.mapper.WrongAnswerMapper;
import com.jl.project.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author jingLong
 * @Date 2024-05-26 22:40
 **/
@Repository
public class CorrectObserverImpl implements CorrectObserver {
    private static final Logger logger = LoggerFactory.getLogger(CorrectObserverImpl.class);

    @Resource
    private BookMapper<Book, BookQuery> bookMapper;

    @Resource
    private QuMapper<Qu, QuQuery> quMapper;


    @Resource
    private RepoMapper<Repo, RepoQuery> repoMapper;


    @Resource
    private WrongAnswerMapper<WrongAnswer, WrongAnswerQuery> wrongAnswerMapper;

    @Override
    @Transactional
    public void insertErrorCollection(List<UserAnswer> userAnswerList) {
        List<Book> bookList = new ArrayList<>();
        List<WrongAnswer> wrongAnswerList = new ArrayList<>();
        // 错题表：题型、题目id、题目的内容、知识点、学科的id、错误的次数
        // 错题关联表：错题表的id、选项的id（单选、多选、判断）、选项的次数
        if (userAnswerList != null && !userAnswerList.isEmpty()) {
            for (UserAnswer userAnswer : userAnswerList) {
                // 1. 查询该用户，该题目有没有做错过
                BookQuery bookQuery = new BookQuery();
                String quId = userAnswer.getQuId();
                String userId = userAnswer.getUserId();
                bookQuery.setQuId(quId);
                bookQuery.setUserId(userId);
                List<Book> books = bookMapper.selectList(bookQuery);
                // 查题型
                Qu qu = quMapper.selectById(quId);
                if (qu == null) {
                    throw new BusinessException("题目不存在");
                }
                // 存在就累加
                if (books != null && !books.isEmpty()) {
                    Book book = books.get(0);
                    book.setWrongCount(book.getWrongCount() + 1);
                    bookList.add(book);
                    // 错题关联表
                    Integer quType = qu.getQuType();
                    if (quType != QuType.FILL.getValue()
                            && quType != QuType.SHORTANSWER.getValue()) {
                        String answerId = userAnswer.getAnswerId();
                        // 解析
                        JSONArray answerArray = JSONUtil.parseArray(answerId);
                        for (Object answer : answerArray) {
                            // 查看错题答案是否存在
                            WrongAnswerQuery wrongAnswerQuery = new WrongAnswerQuery();
                            wrongAnswerQuery.setBookId(book.getId());
                            wrongAnswerQuery.setAnswerId(answer.toString());
                            List<WrongAnswer> wrongAnswers = wrongAnswerMapper.selectList(wrongAnswerQuery);
                            // 存在
                            if (wrongAnswers != null && !wrongAnswers.isEmpty()) {
                                WrongAnswer wrongAnswer = wrongAnswers.get(0);
                                wrongAnswer.setWrongCount(wrongAnswer.getWrongCount() + 1);
                                wrongAnswerList.add(wrongAnswer);
                            } else {
                                // 不存在
                                WrongAnswer wrongAnswer = new WrongAnswer();
                                wrongAnswer.setWrongCount(1);
                                wrongAnswer.setAnswerId(answer.toString());
                                wrongAnswer.setBookId(book.getId());
                                wrongAnswerList.add(wrongAnswer);
                            }
                        }
                    }
                } else {
                    // 不存在就新建
                    Book book = new Book();
                    // 查询关联题库再获取学科id
                    String repoId = qu.getRepoId();
                    if (!StrUtil.isEmpty(repoId)) {
                        Repo repo = repoMapper.selectById(repoId);
                        if (repo != null) {
                            String subjectId = repo.getSubjectId();
                            book.setSubjectId(subjectId);
                        }
                    }
                    // 获取关联的知识点
                    book.setKnContent(qu.getKnowledge());
                    book.setId(CommonUtil.getRandomId());
                    book.setQuId(quId);
                    book.setQuType(qu.getQuType());
                    book.setUserId(userId);
                    book.setQuContent(qu.getContent());
                    book.setWrongCount(1);
                    bookList.add(book);


                    // 错题关联表
                    Integer quType = qu.getQuType();
                    if (quType != QuType.FILL.getValue()
                            && quType != QuType.SHORTANSWER.getValue()) {
                        String answerId = userAnswer.getAnswerId();
                        // 解析
                        JSONArray answerArray = JSONUtil.parseArray(answerId);
                        for (Object answer : answerArray) {
                            // 查看错题答案是否存在
                            WrongAnswerQuery wrongAnswerQuery = new WrongAnswerQuery();
                            wrongAnswerQuery.setBookId(book.getId());
                            wrongAnswerQuery.setAnswerId(answer.toString());
                            List<WrongAnswer> wrongAnswers = wrongAnswerMapper.selectList(wrongAnswerQuery);
                            // 存在
                            if (wrongAnswers != null && !wrongAnswers.isEmpty()) {
                                WrongAnswer wrongAnswer = wrongAnswers.get(0);
                                wrongAnswer.setWrongCount(wrongAnswer.getWrongCount() + 1);
                                wrongAnswerList.add(wrongAnswer);
                            } else {
                                // 不存在
                                WrongAnswer wrongAnswer = new WrongAnswer();
                                wrongAnswer.setWrongCount(1);
                                wrongAnswer.setAnswerId(answer.toString());
                                wrongAnswer.setBookId(book.getId());
                                wrongAnswerList.add(wrongAnswer);
                            }
                        }
                    }
                }
            }
        }
        // 批量处理
        if(!bookList.isEmpty()){
            Integer bookResult = bookMapper.insertOrUpdateBatch(bookList);
            if (bookResult <= 0) {
                logger.error("搜集错题失败：{}", bookResult);
            }
        }

        if(!wrongAnswerList.isEmpty()){
            Integer wrongAnswerResult = wrongAnswerMapper.insertOrUpdateBatch(wrongAnswerList);
            if (wrongAnswerResult <= 0) {
                logger.error("搜集错题选项失败：{}", wrongAnswerResult);
            }
        }



    }


}
