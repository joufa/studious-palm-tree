package fi.joufa.domain.model;

import fi.joufa.domain.model.common.QuestionSetId;
import fi.joufa.domain.model.common.TeamId;

import java.math.BigDecimal;

public class Answer {
    private BigDecimal value;
    private QuestionSetId questionSetId;
    private TeamId teamId;
    private Question question;
    private String comment;

    public Answer(BigDecimal value, QuestionSetId questionSetId, TeamId teamId, Question question, String comment) {
        this.value = value;
        this.questionSetId = questionSetId;
        this.teamId = teamId;
        this.question = question;
        this.comment = comment;
    }

    public BigDecimal getValue() {
        return value;
    }

    public QuestionSetId getQuestionSetId() {
        return questionSetId;
    }

    public TeamId getTeamId() {
        return teamId;
    }

    public Question getQuestion() {
        return question;
    }

    public String getComment() {
        return comment;
    }
}
