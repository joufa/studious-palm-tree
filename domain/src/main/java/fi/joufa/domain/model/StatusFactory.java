package fi.joufa.domain.model;

import java.time.LocalDateTime;
import java.util.Date;

public class StatusFactory {

    public static StatusHistory create(StatusHistoryTypes type) {
        switch (type) {
            case BOTH:
                return new StatusHistory(LocalDateTime.now(), LocalDateTime.now());
            default:
                throw new IllegalArgumentException("Unknown parameter");
        }
    }
    public static StatusHistory update(StatusHistory statusHistory) {
        return new StatusHistory(statusHistory.getCreatedAt() == null ? LocalDateTime.now() : statusHistory.getCreatedAt(), LocalDateTime.now());
    }
    public static StatusHistory createFromDates(Date updated, Date created) {
        return null;
    }

    public static SurveyStatus openSurvey() {
        return new SurveyStatus(LocalDateTime.now(), null);
    }

    public static SurveyStatus closeSurvey(SurveyStatus surveyStatus) {
        return new SurveyStatus(surveyStatus.getOpenedOn(), LocalDateTime.now());
    }
}
