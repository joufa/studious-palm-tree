package fi.joufa.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SurveyStatus {
    private LocalDateTime openedOn;
    private LocalDateTime closedOn;
    private List<SurveyStatus> history;
    private boolean archived;

    public SurveyStatus(LocalDateTime openedOn, LocalDateTime closedOn, List<SurveyStatus> history) {
        this.openedOn = openedOn;
        this.closedOn = closedOn;
        this.archived = false;
        if (history == null) {
            this.history = new ArrayList<>();
        } else {
            this.history = history;
        }
    }

    public static SurveyStatus createInitial() {return new SurveyStatus(null, null, null);}
    public static SurveyStatus createWithHistory(List<SurveyStatus> history) {
        if (history == null) {
            throw new IllegalArgumentException("History cannot be null");
        }
        return new SurveyStatus(null, null, history);
    }

    public boolean isOpen() {
        return this.openedOn != null;
    }

    public boolean isClosed() {
        return this.closedOn != null && this.openedOn != null;

    }
    public boolean isDraft() {
     return this.closedOn == null && this.openedOn == null;
    }
    private void archive() {
        this.archived = true;
    }

    public boolean isArchived() {
        return archived;
    }

    public void reOpen() {
        if (this.isClosed()) {
            this.archive();
            this.history.add(this);
            this.openedOn = null;
            this.closedOn = null;
        }
    }
}
