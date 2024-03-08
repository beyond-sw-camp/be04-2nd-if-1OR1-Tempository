package org.teamone.user.command.domain.aggregate.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ResponseUserAuthVO {
    private String nickname;
    private String email;
    private String userId;

    @Builder
    public ResponseUserAuthVO(String nickname, String email, String userId) {
        this.nickname = nickname;
        this.email = email;
        this.userId = userId;
    }
}
