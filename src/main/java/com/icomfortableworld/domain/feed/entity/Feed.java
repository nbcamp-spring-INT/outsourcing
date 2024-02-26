package com.icomfortableworld.domain.feed.entity;

import com.icomfortableworld.common.entity.Timestamped;
import com.icomfortableworld.domain.feed.dto.FeedRequestDto;
import com.icomfortableworld.domain.feed.model.FeedModel;
import com.icomfortableworld.domain.member.entity.Member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.userdetails.User;

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

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    public Feed(FeedRequestDto requestDto, Member member){
        this.content=requestDto.getContent();
        this.likeCount=requestDto.getLikeCount();
       // this.createdDate=requestDto.getCreatedDate();
        this.member=member;
    }
}
