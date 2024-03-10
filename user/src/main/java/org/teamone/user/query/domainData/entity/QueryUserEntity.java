package org.teamone.user.query.domainData.entity;

import jakarta.persistence.*;
import lombok.*;
import org.teamone.user.query.domainData.enums.Provider;
import org.teamone.user.query.domainData.enums.UserStatus;
import org.teamone.user.query.domainData.enums.AccessLevel;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "tbl_user")
public class QueryUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NICKNAME", nullable = false, unique = true)
    private String nickname;

    @Column(name = "PROVIDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Column(name = "ACCESS_LEVEL")
    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;

    @Column(name = "USER_STATUS")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(name = "FOLLOWER_CNT")
    private int followerCnt;

    @Column(name = "FOLLOWING_CNT")
    private int followingCnt;

    @Column(name = "GRADE")
    private int grade;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SNS_ID")
    private String snsId;

    @Column(name = "USER_ID")
    private String userId;


    @Builder
    public QueryUserEntity(String name, String nickname, Provider provider, AccessLevel accessLevel, UserStatus userStatus,
                           int followerCnt, int followingCnt, int grade, String email, String password, String snsId, String userId) {
        this.name = name;
        this.nickname = nickname;
        this.provider = provider;
        this.accessLevel = accessLevel;
        this.userStatus = userStatus;
        this.followerCnt = followerCnt;
        this.followingCnt = followingCnt;
        this.grade = grade;
        this.email = email;
        this.password = password;
        this.snsId = snsId;
        this.userId = userId;
    }
}
