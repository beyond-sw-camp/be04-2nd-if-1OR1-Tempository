package org.teamone.user.query.domainData.entity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class QueryProjectMemberEntity {
    private int memberId;
    private int projectId;
    private String position;
    private String memberStatus;

    @Builder
    public QueryProjectMemberEntity(int memberId, int projectId, String position, String memberStatus) {
        this.memberId = memberId;
        this.projectId = projectId;
        this.position = position;
        this.memberStatus = memberStatus;
    }
}
