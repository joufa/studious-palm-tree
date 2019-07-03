package fi.joufa.domain.model;

import fi.joufa.domain.model.common.AnswerSetId;
import fi.joufa.domain.model.common.SurveyId;

import java.util.List;

public class AnswerSetBuilder {
    private AnswerSetId id;
    private Team team;
    private List<Answer> answers;
    private SurveyId surveyId;
    private Role role;

    public AnswerSetBuilder setId(Long id) {
        this.id = new AnswerSetId(id);
        return this;
    }

    public AnswerSetBuilder setTeam(Team team) {
        this.team = team;
        return this;
    }

    public AnswerSetBuilder setAnswers(List<Answer> answers) {
        this.answers = answers;
        return this;
    }

    public AnswerSetBuilder setSurveyId(Long surveyId) {
        this.surveyId = new SurveyId(surveyId);
        return this;
    }
    public AnswerSetBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public AnswerSet createAnswerSet() {
        return new AnswerSet(id, team, answers, surveyId, role);
    }
}