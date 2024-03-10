package org.teamone.user.query.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QueryProjectMemberDTO {
    private int memberId;
    private int projectId;
    private String position;
    private String memberStatus;

    @Builder
    public QueryProjectMemberDTO(int memberId, int projectId, String position, String memberStatus) {
        this.memberId = memberId;
        this.projectId = projectId;
        this.position = position;
        this.memberStatus = memberStatus;
    }
}
