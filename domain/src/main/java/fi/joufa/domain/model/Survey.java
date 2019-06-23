package fi.joufa.domain.model;


import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Survey aggregate root
 */
public class Survey {
    private SurveyId surveyId;
    private Set<TeamId> teams;
    private Map<Integer, QuestionSet> questionSet;
    private StatusHistory statusHistory;
    private SurveyStatus status;


    public Survey(SurveyId surveyId, Set<TeamId> teams, Map<Integer, QuestionSet> questionSet, StatusHistory statusHistory, SurveyStatus status) {
        this.surveyId = surveyId;
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
            throw new IllegalArgumentException("Team is null!");
        }
        this.teams.add(teamId);
    }

    private void checkOpen() {
        if (this.status.isClosed()) {
            throw new IllegalStateException("The survey is closed!");
        }
    }

    public void addQuestionSet(final Integer position, final QuestionSet questionSet) {
        if (this.questionSet == null) {
            this.questionSet = new HashMap<>();
        }
        if (position == null) {
            // throw
            return;
        }
        if (!validateQuestionSet(questionSet)) {
            // throw
            return;
        }
        if (this.questionSet.containsKey(position)) {
            // throw
            return;
        }

        this.questionSet.put(position, questionSet);

    }

    private boolean validateQuestionSet(QuestionSet questionSet) {
        if (questionSet == null) {
            return false;
        }

        return questionSet.isValid();

    }

    public void addQuestionToSet(Question question, QuestionSet questionSet) {
    }

    public void open() {
        if (this.validate()) {
            this.status = new SurveyStatus(LocalDateTime.now(), null);
        }
    }

    // A survey must contain:
    // - at least one team
    private boolean validate() {
        // validate survey, is it ready
        // A survey
        return false;
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

    /**
     * Is survey open to be answered?
     *
     * @return true or false
     */
    public boolean isOpen() {
        return this.status != null ? this.status.isOpen() : false;
    }


}
