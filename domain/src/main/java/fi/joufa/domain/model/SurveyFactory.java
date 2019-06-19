package fi.joufa.domain.model;

public class SurveyFactory {

    public static Survey create(Team team) {
        return new Survey(team);
    }

}
