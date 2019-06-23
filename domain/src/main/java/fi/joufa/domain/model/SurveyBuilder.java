package fi.joufa.domain.model;

import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;

import java.util.Map;
import java.util.Set;

public class SurveyBuilder {
    private SurveyId surveyId;
    private String name;
    private Set<TeamId> teams;
    private Map<Integer, QuestionSet> questionSet;
    private StatusHistory statusHistory;
    private SurveyStatus status;

    public SurveyBuilder setSurveyId(SurveyId surveyId) {
        this.surveyId = surveyId;
        return this;
    }

    public SurveyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SurveyBuilder setTeams(Set<TeamId> teams) {
        this.teams = teams;
        return this;
    }

    public SurveyBuilder setQuestionSet(Map<Integer, QuestionSet> questionSet) {
        this.questionSet = questionSet;
        return this;
    }

    public SurveyBuilder setStatusHistory(StatusHistory statusHistory) {
        this.statusHistory = statusHistory;
        return this;
    }

    public SurveyBuilder setStatus(SurveyStatus status) {
        this.status = status;
        return this;
    }

    public Survey createSurvey() {
        return new Survey(surveyId, name, teams, questionSet, statusHistory, status);
    }
}