package com.jl.project.entity.vo;

import com.jl.project.entity.po.Book;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;

/**
 * 错题集合
 */
@Schema(description = "错题集合")
public class ErrorVO {

    /**
     * 题目信息
     */
    @Schema(description = "题目信息")
    private QuAndAnswerVo quAndAnswerVo;

    /**
     * 错题信息
     */
    private Book book;

    /**
     * 错题选项分布统计（非填空、简答）
     */
    private Map<String,Integer> wrongAnswerCount;

    /**
     * 答题总数（考试+训练）
     * @return
     */
    private Integer answerCount;

    public Integer getAnswerCount() {
        return answerCount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public QuAndAnswerVo getQuAndAnswerVo() {
        return quAndAnswerVo;
    }

    public void setQuAndAnswerVo(QuAndAnswerVo quAndAnswerVo) {
        this.quAndAnswerVo = quAndAnswerVo;
    }

    public Map<String, Integer> getWrongAnswerCount() {
        return wrongAnswerCount;
    }

    public void setWrongAnswerCount(Map<String, Integer> wrongAnswerCount) {
        this.wrongAnswerCount = wrongAnswerCount;
    }
}
