package fi.joufa.domain.model;

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
        return new SurveyBuilder()
                .setSurveyId(null)
                .setName(name)
                .setTeams(new HashSet<>())
                .setQuestionSet(new HashMap<>())
                .setStatusHistory(StatusFactory.createHistory())
                .setStatus(SurveyStatus.createInitial())
                .createSurvey();
    }

    public static Survey clone(Survey survey) {
        if (survey == null) {
            throw new IllegalArgumentException("Cannot clone from empty survey");
        }
        return new SurveyBuilder()
                .setSurveyId(null)
                .setQuestionSet(survey.getQuestionSet())
                .setName(survey.getName())
                .setStatusHistory(StatusFactory.createHistory())
                .setStatus(SurveyStatus.createInitial())
                .createSurvey();
    }



}
