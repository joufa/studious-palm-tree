package fi.joufa.domain.model;

import java.time.LocalDateTime;

public class SurveyStatus {
    private LocalDateTime openedOn;
    private LocalDateTime closedOn;

    public SurveyStatus(LocalDateTime openedOn, LocalDateTime closedOn) {
        this.openedOn = openedOn;
        this.closedOn = closedOn;
    }

    public static SurveyStatus createInitial() {return new SurveyStatus(null, null);}


    public boolean isOpen() {
        return this.openedOn != null && this.closedOn == null;
    }

    public boolean isDraft() {
        return this.closedOn == null && this.openedOn == null;
    }

    SurveyStatus close() {
        if (this.isOpen()) {
            this.closedOn = LocalDateTime.now();
            return this;
        }
        throw new IllegalStateException("Cannot close survey as it is not open yet.");
    }

    SurveyStatus open() {
        this.openedOn = LocalDateTime.now();
        this.closedOn = null;
        return this;
    }

    @Override
    public String toString() {
        return "SurveyStatus{" +
                "openedOn=" + openedOn +
                ", closedOn=" + closedOn +
                '}';
    }
}
