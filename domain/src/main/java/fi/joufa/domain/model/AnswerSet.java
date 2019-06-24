package fi.joufa.domain.model;

import fi.joufa.domain.model.common.AnswerSetId;
import fi.joufa.domain.model.common.SurveyId;

import java.util.List;

public class AnswerSet {
    private AnswerSetId id;
    private Team team;
    private List<Answer> answers;
    private SurveyId surveyId;

}
