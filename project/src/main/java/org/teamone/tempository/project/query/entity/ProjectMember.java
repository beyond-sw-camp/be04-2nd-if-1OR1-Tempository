package org.teamone.tempository.project.query.entity;


import lombok.*;
import org.teamone.tempository.project.query.type.ProjectMemberStatus;
import org.teamone.tempository.project.query.type.ProjectPosition;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectMember {

    private int memberId;

    private int projectId;

    private ProjectPosition position;

    private ProjectMemberStatus memberStatus;
}
