package fi.joufa.domain.model;

public class SurveyFactory {

    private SurveyFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Survey createNew(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        return new SurveyBuilder()
                .setName(name)
                .initStatus()
                .createSurvey();
    }

}
