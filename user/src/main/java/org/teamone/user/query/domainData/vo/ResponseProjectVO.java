package org.teamone.user.query.domainData.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseProjectVO {
    private int id;

    private String name;

    private String status;

    @Builder
    public ResponseProjectVO(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
