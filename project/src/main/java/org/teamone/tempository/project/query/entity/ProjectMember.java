package org.teamone.tempository.project.query.entity;


import lombok.*;
import org.teamone.tempository.project.query.type.ProjectMemberStatus;
import org.teamone.tempository.project.query.type.ProjectPosition;
import org.teamone.tempository.project.query.vo.ResponseUser;

import java.util.List;

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
