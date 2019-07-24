package fi.joufa.domain.model;

import fi.joufa.domain.model.common.QuestionSetId;
import fi.joufa.domain.model.common.TeamId;

import java.math.BigDecimal;

public class AnswerBuilder {
    private BigDecimal value;
    private QuestionSetId questionSetId;
    private TeamId teamId;
    private Question question;
    private String comment;

    public AnswerBuilder setValue(String value) {
        this.value = new BigDecimal(value);
        return this;
    }

    public AnswerBuilder setQuestionSetId(Long questionSetId) {
        this.questionSetId = new QuestionSetId(questionSetId);
        return this;
    }

    public AnswerBuilder setTeamId(Long teamId) {
        this.teamId = new TeamId(teamId);
        return this;
    }

    public AnswerBuilder setQuestion(String question) {
        this.question = new Question(question);
        return this;
    }

    public AnswerBuilder setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Answer createAnswer() {
        return new Answer(value, questionSetId, teamId, question, comment);
    }
}