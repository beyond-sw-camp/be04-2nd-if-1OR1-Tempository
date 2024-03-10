package org.teamone.user.command.domain.aggregate.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseUpdatePasswordVO {
    private String message;

    @Builder
    public ResponseUpdatePasswordVO(String message) {
        this.message = message;
    }
}
