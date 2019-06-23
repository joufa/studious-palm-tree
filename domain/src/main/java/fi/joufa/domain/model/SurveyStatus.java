package fi.joufa.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class SurveyStatus {
    private LocalDateTime openedOn;
    private LocalDateTime closedOn;
    private List<SurveyStatus> history;
    private boolean archived;

    public SurveyStatus(LocalDateTime openedOn, LocalDateTime closedOn) {
        this.openedOn = openedOn;
        this.closedOn = closedOn;
        this.archived = false;
    }

    public static SurveyStatus createInitial() {return new SurveyStatus(null, null);}

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
