package fi.joufa.domain.model;


import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Survey aggregate root
 */
public class Survey {
    private SurveyId surveyId;
    private String name;
    private Set<TeamId> teams;
    private Map<Integer, QuestionSet> questionSet;
    private StatusHistory statusHistory;
    private SurveyStatus status;


    public Survey(SurveyId surveyId, String name, Set<TeamId> teams, Map<Integer, QuestionSet> questionSet, StatusHistory statusHistory, SurveyStatus status) {
        this.surveyId = surveyId;
        this.name = name;
        this.teams = teams;
        this.questionSet = questionSet;
        this.statusHistory = statusHistory;
        this.status = status;
    }

    public void addTeam(TeamId teamId) {
        this.checkOpen();
        if (this.teams.contains(teamId)) {
            throw new IllegalStateException("Survey already contains the team.");
        }
        if (teamId == null) {
            throw new IllegalArgumentException("Invalid team");
        }
        this.teams.add(teamId);
    }

    private void checkOpen() {
        if (!this.status.isDraft()) {
            throw new IllegalStateException("The survey is opened or closed and cannot be edited");
        }
    }

    public void addQuestionSet(final Integer position, final QuestionSet questionSet) {
        this.checkOpen();
        if (this.questionSet == null) {
            this.questionSet = new HashMap<>();
        }
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        if (!validateQuestionSet(questionSet)) {
            throw new IllegalArgumentException("QuestionSet is invalid");
        }
        if (this.questionSet.containsKey(position)) {
            throw new IllegalArgumentException("QuestionSet is already present");
        }

        this.questionSet.put(position, questionSet);

    }

    public Map<Integer, QuestionSet> getQuestionSet() {
        return questionSet;
    }

    public SurveyStatus getStatus() {
        return status;
    }

    private boolean validateQuestionSet(QuestionSet questionSet) {
        if (questionSet == null) {
            return false;
        }

        return questionSet.isValid();

    }

    public void close() {
        this.status = status.close();
    }
    public void open() {
        if (this.validate()) {
            this.status = status.open();
        } else {
            throw new IllegalStateException("Survey cannot be opened with current state");
        }
    }

    private boolean validate() {
        return this.teams != null && !this.teams.isEmpty()
     && this.questionSet != null && !this.questionSet.isEmpty();
    }

    public SurveyId getSurveyId() {
        return surveyId;
    }

    public Set<TeamId> getTeams() {
        return teams;
    }

    public StatusHistory getStatusHistory() {
        return statusHistory;
    }

    public String getName() {
        return name;
    }

    /**
     * Is survey open to be answered?
     *
     * @return true or false
     */
    public boolean isOpen() {
        return this.status != null && this.status.isOpen();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return Objects.equals(surveyId, survey.surveyId) &&
                Objects.equals(status, survey.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(surveyId, status);
    }
}
