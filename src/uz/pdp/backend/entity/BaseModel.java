package uz.pdp.backend.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseModel {
    private String id;
    private Boolean isDeleted;
    private LocalDateTime localDateTime;

    public BaseModel() {
        this.id = UUID.randomUUID().toString();
        this.isDeleted = false;
        this.localDateTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
