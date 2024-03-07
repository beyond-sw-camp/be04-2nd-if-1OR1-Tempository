package org.teamone.tempository.project.query.dto;

import lombok.Data;
import org.teamone.tempository.project.command.type.ProjectStatus;
import org.teamone.tempository.project.query.entity.ProjectDefinitionOfTable;

import java.util.List;

@Data
public class ProjectDTO {
    private int id;
    private String name;

    private boolean isPublic;

    private int likeCnt;

    private ProjectStatus status;

    private String content;

    private List<ProjectMemberDTO> projectMemberList;

    private List<ProjectIssueDTO> projectIssueList;

    private List<ProjectDefinitionOfTableDTO> projectDefinitionOfTableList;
}
