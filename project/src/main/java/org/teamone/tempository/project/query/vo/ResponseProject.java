package org.teamone.tempository.project.query.vo;

import lombok.*;
import org.teamone.tempository.project.command.type.ProjectStatus;
import org.teamone.tempository.project.query.dto.ProjectMemberDTO;

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
