package org.teamone.user.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.teamone.user.command.domain.aggregate.types.AccessLevel;
import org.teamone.user.command.domain.aggregate.types.Password;
import org.teamone.user.command.domain.aggregate.types.Provider;
import org.teamone.user.command.domain.aggregate.types.UserStatus;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Table(name = "tbl_user")
public class User {

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
    private Password password;

    @Column(name = "SNS_ID")
    private String snsId;

    @Builder
    public User(String name, String nickname, Provider provider, AccessLevel accessLevel, UserStatus userStatus,
                int followerCnt, int followingCnt, int grade, String email, Password password, String snsId) {
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
    }
}
