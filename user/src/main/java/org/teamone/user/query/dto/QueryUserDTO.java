package org.teamone.user.query.dto;

import lombok.*;
import org.teamone.user.query.domainData.enums.UserStatus;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QueryUserDTO {
    private int id;
    private String name;
    private String nickname;
    private UserStatus userStatus;
    private int followerCnt;
    private int followingCnt;
    private int grade;
    private String email;
    private String password;
    private String snsId;
    private String userId;

    @Builder
    public QueryUserDTO(int id, String name, String nickname, UserStatus userStatus, int followerCnt, int followingCnt,
                        int grade, String email, String password, String snsId, String userId) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
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
