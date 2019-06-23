package fi.joufa.domain.model;

import fi.joufa.domain.model.common.TeamId;

import java.util.HashMap;
import java.util.HashSet;

public class SurveyFactory {

    private SurveyFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Survey createNew(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        return new SurveyBuilder().setSurveyId(null).setName(name).setTeams(new HashSet<TeamId>()).setQuestionSet(new HashMap<Integer, QuestionSet>()).setStatusHistory(StatusFactory.createHistory()).setStatus(SurveyStatus.createInitial()).createSurvey();
    }



}
