package org.teamone.user.query.domainData.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseUserInfoByTokenVO {
    String message;
    int id;
    String name;
    String nickname;
    String email;
    String userId;

    @Builder
    public ResponseUserInfoByTokenVO(String message, int id, String name, String nickname, String email, String userId) {
        this.message = message;
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.userId = userId;
    }
}
