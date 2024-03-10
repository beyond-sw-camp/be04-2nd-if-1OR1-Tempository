package org.teamone.user.query.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QueryProjectDTO {
    private int projectId;

    private String name;

    private String status;

    @Builder
    public QueryProjectDTO(int projectId, String name, String status) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
    }
}
