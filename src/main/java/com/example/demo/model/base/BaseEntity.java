package com.example.demo.model.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
@Audited
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Version
    @Column(name = "version", columnDefinition = "BIGINT(20) default 0", nullable = false)
    private Long version;

    @Column(name = "created_date", columnDefinition = "DATETIME")
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        this.setCreatedDate(LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC));
    }
}
