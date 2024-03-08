package org.teamone.user.query.domainData.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseProjectMemberVO {
    String name;
    String nickname;
    String userId;

    @Builder
    public ResponseProjectMemberVO(String name, String nickname, String userId) {
        this.name = name;
        this.nickname = nickname;
        this.userId = userId;
    }
}
