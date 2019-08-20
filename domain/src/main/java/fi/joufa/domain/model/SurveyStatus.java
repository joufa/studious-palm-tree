package fi.joufa.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class SurveyStatus {
    private UUID id;
    private LocalDateTime openedOn;
    private LocalDateTime closedOn;

    public SurveyStatus(UUID id, LocalDateTime openedOn, LocalDateTime closedOn) {
        this.id = id;
        this.openedOn = openedOn;
        this.closedOn = closedOn;
    }

    public static SurveyStatus createInitial() {return new SurveyStatus(null, null, null);}


    public boolean isOpen() {
        return this.openedOn != null && this.closedOn == null && this.id != null;
    }

    public boolean isDraft() {
        return this.closedOn == null && this.openedOn == null && this.id == null;
    }

    SurveyStatus close() {
        if (this.isOpen()) {
            this.closedOn = LocalDateTime.now();
            return this;
        }
        throw new IllegalStateException("Cannot close survey as it is not open yet.");
    }

    SurveyStatus open() {
        this.id = UUID.randomUUID();
        this.openedOn = LocalDateTime.now();
        this.closedOn = null;
        return this;
    }

    public LocalDateTime getOpenedOn() {
        return openedOn;
    }

    public LocalDateTime getClosedOn() {
        return closedOn;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SurveyStatus{" +
                "id=" + id +
                ", openedOn=" + openedOn +
                ", closedOn=" + closedOn +
                '}';
    }
}
