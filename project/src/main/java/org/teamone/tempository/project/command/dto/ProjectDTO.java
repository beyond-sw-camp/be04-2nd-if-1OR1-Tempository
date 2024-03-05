package org.teamone.tempository.project.command.dto;

import lombok.*;
import org.teamone.tempository.project.command.status.ProjectStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDTO {

    private int id;

    private String name;

    private boolean isPublic;

    private int likeCnt;

    private ProjectStatus status;

    private String content;
}
