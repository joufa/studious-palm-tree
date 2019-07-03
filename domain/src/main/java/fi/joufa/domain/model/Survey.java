package fi.joufa.domain.model;


import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;

import java.util.Objects;
import java.util.Set;

/**
 * Survey aggregate root
 */
public class Survey {
    private SurveyId surveyId;
    private String name;
    private Set<TeamId> teams;
    private QuestionMap<QuestionSet> questionSets;
    private StatusHistory statusHistory;
    private SurveyStatus status;
    private SurveyHistory surveyHistory;


    Survey(SurveyId surveyId, String name, Set<TeamId> teams, QuestionMap<QuestionSet> questionSets, StatusHistory statusHistory, SurveyStatus status, SurveyHistory history) {
        this.surveyId = surveyId;
        this.name = name;
        this.teams = teams;
        this.questionSets = questionSets;
        this.statusHistory = statusHistory;
        this.status = status;
        this.surveyHistory = history;

        if (this.name == null ||this.statusHistory == null ||this.status == null ||this.surveyHistory == null) {
            throw new IllegalArgumentException("Survey creation failed");
        }
    }


    /**
     * Checks if the survey is open, eg. accepting answers.
     *
     * @return true if open, otherwise false
     */
    public boolean isOpen() {
       return this.status.isOpen();
    }

    public void update(QuestionMap<QuestionSet> qm) {
        if (qm == null) {
            throw new IllegalArgumentException();
        }
        if (this.isOpen()) {
            throw new IllegalStateException("Cannot update and open survey");
        }

            this.questionSets = qm;

    }
    public void update(Set<TeamId> teams) {
        if (teams == null) {
            throw new IllegalArgumentException();
        }
        if (this.isOpen()) {
            throw new IllegalStateException("Cannot update and open survey");
        }
        this.teams = teams;
    }


    /**
     * Closes the survey
     */
    public void close()  {
        this.status = status.close();
    }



    /**
     * Opens the survey for answers
     */
    public void open() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public boolean validate() {
        // cannot open if not persisted
        // must contain a team
        // questionset validation ok
        // must have statuses
        return this.surveyId != null && validateQuestionSets() && validateTeams() && validateStatusHistory();
    }


    public SurveyId getSurveyId() {
        return surveyId;
    }

    public String getName() {
        return name;
    }

    public Set<TeamId> getTeams() {
        return teams;
    }

    public QuestionMap<QuestionSet> getQuestionSets() {
        return questionSets;
    }

    public StatusHistory getStatusHistory() {
        return statusHistory;
    }

    public SurveyStatus getStatus() {
        return status;
    }

    public SurveyHistory getSurveyHistory() {
        return surveyHistory;
    }

    private boolean validateTeams() {
        return this.teams != null && !this.teams.isEmpty();
    }
    private boolean validateQuestionSets() {
        return this.questionSets != null && !this.questionSets.isEmpty();
    }

    private boolean validateStatusHistory() {
        return this.statusHistory != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return surveyId.equals(survey.surveyId) &&
                name.equals(survey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surveyId, name);
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyId=" + surveyId +
                ", name='" + name + '\'' +
                ", teams=" + teams +
                ", questionSets=" + questionSets +
                ", statusHistory=" + statusHistory +
                ", status=" + status +
                ", surveyHistory=" + surveyHistory +
                '}';
    }
}
