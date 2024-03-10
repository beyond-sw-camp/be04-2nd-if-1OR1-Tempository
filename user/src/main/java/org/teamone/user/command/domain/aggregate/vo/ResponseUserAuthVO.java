package org.teamone.user.command.domain.aggregate.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ResponseUserAuthVO {
    private String message;
    private String name;
    private String nickname;
    private String email;

    @Builder
    public ResponseUserAuthVO(String message, String name, String nickname, String email) {
        this.message = message;
        this.nickname = nickname;
        this.email = email;
        this.name = name;
    }
}
