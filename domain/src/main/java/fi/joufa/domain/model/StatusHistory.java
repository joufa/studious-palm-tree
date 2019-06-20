package fi.joufa.domain.model;

import java.time.LocalDateTime;

public class StatusHistory {
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public StatusHistory(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "StatusHistory{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
