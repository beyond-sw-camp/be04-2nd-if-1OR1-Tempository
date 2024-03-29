package org.teamone.user.command.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommandUserDTO {
    private String name;
    private String nickname;
    private String email;
    private String password;
    private String userId;

    @Builder
    public CommandUserDTO(String name, String nickname, String email, String password, String userId) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.userId = userId;
    }
}
