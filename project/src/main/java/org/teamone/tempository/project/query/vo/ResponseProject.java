package org.teamone.tempository.project.query.vo;

import lombok.*;
import org.teamone.tempository.project.query.dto.ProjectMemberDTO;
import org.teamone.tempository.project.query.type.ProjectStatus;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class ResponseProject {
    private int id;

    private String name;

    private boolean isPublic;

    private int likeCnt;

    private String content;

    private ProjectStatus status;

    private List<ProjectMemberDTO> projectMemberDTOList;

}
