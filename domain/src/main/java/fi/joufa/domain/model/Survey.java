package fi.joufa.domain.model;


import java.math.BigDecimal;

public class Survey {

    private QuestionSet questionSet;
    private AnswerSet answerSet;
    private StatusHistory statusHistory;
    private SurveyStatus status;


    public void addAnswer(Question question, Answer answer) {
        throw new UnsupportedOperationException();
    }

    public void addQuestionSet(QuestionSet questionSet) {
        throw new UnsupportedOperationException();
    }

    public BigDecimal percentage() {
        throw new UnsupportedOperationException();
    }

    public QuestionSet getQuestionSet() {
        return questionSet;
    }

    public AnswerSet getAnswerSet() {
        return answerSet;
    }

    public StatusHistory getStatusHistory() {
        return statusHistory;
    }

    public SurveyStatus getStatus() {
        return status;
    }
}
