package org.teamone.tempository.project.query.entity;

import lombok.*;
import org.teamone.tempository.project.command.type.ProjectStatus;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {

    private int id;
    private String name;

    private boolean isPublic;

    private int likeCnt;

    private ProjectStatus status;

    private String content;

    private List<ProjectMember> projectMemberList;
    private List<ProjectIssue> projectIssueList;

}
