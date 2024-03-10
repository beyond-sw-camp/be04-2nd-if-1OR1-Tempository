package org.teamone.user.query.domainData.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseUserForServiceVO {
    private String message;
    private String name;
    private String nickname;
    private int followerCnt;
    private int followingCnt;
    private int grade;
    private String email;
    private String userId;

    @Builder
    public ResponseUserForServiceVO(String message, String name, String nickname, int followerCnt, int followingCnt, int grade, String email, String userId) {
        this.message = message;
        this.name = name;
        this.nickname = nickname;
        this.followerCnt = followerCnt;
        this.followingCnt = followingCnt;
        this.grade = grade;
        this.email = email;
        this.userId = userId;
    }
}
