package fi.joufa.domain.model;

import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;

import java.util.HashSet;
import java.util.Set;

public class SurveyBuilder {
    private SurveyId surveyId;
    private String name;
    private Set<TeamId> teams;
    private QuestionMap<QuestionSet> questionSet;
    private StatusHistory statusHistory;
    private SurveyStatus status;
    private SurveyHistory history;

    public SurveyBuilder setSurveyId(Long id) {
        this.surveyId = new SurveyId(id);
        return this;
    }

    public SurveyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SurveyBuilder setTeams(Long teamId) {
        if (this.teams == null) {
            this.teams = new HashSet<>();
        }
        this.teams.add(new TeamId(teamId));
        return this;
    }
    public SurveyBuilder setAllTeams(Set<TeamId> teams) {
        this.teams = teams;
        return this;
    }

    public SurveyBuilder setQuestionSets(QuestionMap<QuestionSet> questionMap) {
        this.questionSet = questionMap;
        return this;
    }

    public SurveyBuilder setStatusHistory(StatusHistory statusHistory) {
        this.statusHistory = statusHistory;
        return this;
    }

    public SurveyBuilder setStatus(SurveyStatus status) {
        if (status == null) {
            this.status = SurveyStatus.createInitial();
            return this;
        }
        this.status = status;
        return this;
    }

    public SurveyBuilder setHistory(SurveyHistory surveyHistory) {
        if (surveyHistory == null) {
            this.history = new SurveyHistory(null);
        }
        this.history = surveyHistory;
        return this;
    }

    public SurveyBuilder initStatus() {
        this.statusHistory = StatusFactory.createHistory();
        this.status = SurveyStatus.createInitial();
        this.history = new SurveyHistory();
        return this;
    }

    public Survey createSurvey() {
        return new Survey(surveyId, name, teams, questionSet, statusHistory, status, history);
    }
}