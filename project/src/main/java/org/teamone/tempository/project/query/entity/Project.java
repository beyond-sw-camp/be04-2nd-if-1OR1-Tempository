package org.teamone.tempository.project.query.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.teamone.tempository.project.command.type.ProjectStatus;
import org.teamone.tempository.project.query.dto.ProjectDTO;

import java.util.List;

@Data
public class Project {

    private int id;
    private String name;

    private boolean isPublic;

    private int likeCnt;

    private ProjectStatus status;

    private String content;

    private List<ProjectMember> projectMemberList;

}
