package com.icomfortableworld.domain.feed.entity;

import com.icomfortableworld.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@SQLDelete(sql="update feeds set deleted_date = NOW() where id=?")
@SQLRestriction(value="deleted_date is NULL")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="feeds")
public class Feed extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    @Column(nullable = false, length=140)
    private String content;

    @Column(nullable = false)
    private Long likeCount;


}
