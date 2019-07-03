package fi.joufa.domain.model;

import fi.joufa.domain.model.common.AnswerSetId;
import fi.joufa.domain.model.common.SurveyId;

import java.util.List;

public class AnswerSet {
    private AnswerSetId id;
    private Team team;
    private List<Answer> answers;
    private SurveyId surveyId;
    private Role role;

    AnswerSet(AnswerSetId id, Team team, List<Answer> answers, SurveyId surveyId, Role role) {
        this.id = id;
        this.team = team;
        this.answers = answers;
        this.surveyId = surveyId;
        this.role = role;
    }

    public AnswerSetId getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public SurveyId getSurveyId() {
        return surveyId;
    }

    public Role getRole() {
        return role;
    }
}
