package fi.joufa.domain.model;


import java.math.BigDecimal;

public class Survey {
    private Long id;
    private Team team;
    private QuestionSet questionSet;
    private AnswerSet answerSet;
    private StatusHistory statusHistory;
    private SurveyStatus status;

    public Survey(Team team) {
        if (team == null || team.getName() == null) {
            throw new IllegalArgumentException("Team is empty");
        }
        this.team = team;
    }

    public void addAnswer(Question question, Answer answer) {

    }

    public void addQuestionSet(QuestionSet questionSet) {

    }

    // Returns the percentage of survey questions answered;
    public BigDecimal percentage() {
        return null;
    }

}
