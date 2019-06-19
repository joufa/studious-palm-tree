package fi.joufa.domain.model;

import java.time.LocalDateTime;

public class SurveyStatus {
    private LocalDateTime openedOn;
    private LocalDateTime closedOn;

    public SurveyStatus(LocalDateTime openedOn, LocalDateTime closedOn) {
        this.openedOn = openedOn;
        this.closedOn = closedOn;
    }

    public LocalDateTime getOpenedOn() {
        return openedOn;
    }

    public LocalDateTime getClosedOn() {
        return closedOn;
    }
}
