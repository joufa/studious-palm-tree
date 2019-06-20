package fi.joufa.domain.model;

public class SurveyFactory {

    private SurveyFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Survey create(Team team) {
        return new Survey();
    }

}
