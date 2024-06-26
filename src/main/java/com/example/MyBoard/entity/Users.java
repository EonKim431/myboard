package com.example.MyBoard.entity;

import com.example.MyBoard.constant.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data @Builder
@EntityListeners(AuditingEntityListener.class)
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "like_color")
    private String likeColor;
    @Column(name = "created_at",updatable = false) @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "updated_at", insertable = false , updatable = true) @LastModifiedDate
    private LocalDateTime updatedAt;
}
