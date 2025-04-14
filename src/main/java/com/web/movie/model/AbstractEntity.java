package com.web.movie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity<T extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private T id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt; // Sửa tên biến cho đúng convention (lowercase 'u')

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now; // Khi tạo mới, updatedAt cũng bằng createdAt
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date(); // Khi cập nhật, chỉ cập nhật updatedAt
    }
}
