package fi.joufa.domain.model;

import fi.joufa.domain.model.common.TeamId;

import java.util.HashMap;
import java.util.HashSet;

public class SurveyFactory {

    private SurveyFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Survey createNew() {
        return new SurveyBuilder().setSurveyId(null).setTeams(new HashSet<TeamId>()).setQuestionSet(new HashMap<Integer, QuestionSet>()).setStatusHistory(StatusFactory.createHistory()).setStatus(SurveyStatus.createInitial()).createSurvey();
    }



}
