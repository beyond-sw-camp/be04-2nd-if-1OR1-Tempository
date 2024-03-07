package org.teamone.tempository.project.query.dto;

import lombok.Data;
import org.teamone.tempository.project.query.type.ProjectMemberStatus;
import org.teamone.tempository.project.query.type.ProjectPosition;

@Data
public class ProjectMemberDTO {
    private int memberId;

    private int projectId;

    private ProjectPosition position;

    private ProjectMemberStatus memberStatus;
}
