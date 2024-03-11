package org.teamone.user.command.domain.aggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserAuthVO {
    private String name;
    private String nickname;
    private String email;
    private String password;
}
