package fi.joufa.domain.model;

import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;

import java.util.Set;

public class SurveyUpdate {
    private final SurveyId id;

    private Set<TeamId> teams;

    private boolean open;

    private QuestionMap<QuestionSet> questions;

    public SurveyUpdate(SurveyId id) {
        this.id = id;
    }

    public SurveyId getId() {
        return id;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Set<TeamId> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamId> teams) {
        this.teams = teams;
    }

    public boolean isOpen() {
        return open;
    }

    public QuestionMap<QuestionSet> getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionMap<QuestionSet> questions) {
        this.questions = questions;
    }
}
