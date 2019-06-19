package fi.joufa.domain.model;

import java.time.LocalDateTime;

public class StatusFactory {

    private StatusFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates a new StatusHistory VO
     *
     * @return StatusHistory Statushistory VO
     */
    public static StatusHistory createHistory() {
        return new StatusHistory(LocalDateTime.now(), LocalDateTime.now());
    }

    public static StatusHistory update(StatusHistory statusHistory) {
        return new StatusHistory(
                statusHistory.getCreatedAt() == null ?
                        LocalDateTime.now() : statusHistory.getCreatedAt(), LocalDateTime.now()
        );
    }
}
