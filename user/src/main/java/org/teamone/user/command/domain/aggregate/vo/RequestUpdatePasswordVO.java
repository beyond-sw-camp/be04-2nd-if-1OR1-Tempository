package org.teamone.user.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdatePasswordVO {
    private String oldPassword;
    private String newPassword;
}
