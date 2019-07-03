package fi.joufa.domain.model;

import java.util.ArrayList;
import java.util.List;

public class SurveyHistory {
    private List<SurveyStatus> history;

    public SurveyHistory(List<SurveyStatus> history) {
            this.history = history;
    }

    public SurveyHistory() {
        this.history = new ArrayList<>();
    }

    public void add(SurveyStatus surveyStatus) {
        if (surveyStatus == null ||surveyStatus.isOpen() ||surveyStatus.isDraft()) {
            throw new IllegalArgumentException("Cannot archive an open survey");
        }
        this.history.add(surveyStatus);
    }

    public List<SurveyStatus> getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return "SurveyHistory{" +
                "history=" + history +
                '}';
    }
}
