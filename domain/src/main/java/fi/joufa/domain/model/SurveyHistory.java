package fi.joufa.domain.model;

import java.util.ArrayList;
import java.util.List;

public class SurveyHistory {
    private List<Survey> history;

    public SurveyHistory(List<Survey> history) {
        this.history = history;
    }

    public SurveyHistory() {
        this.history = new ArrayList<>();
    }

    List<Survey> findAll() {
        return this.history;
    }

}
