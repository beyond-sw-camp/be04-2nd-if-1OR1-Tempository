package org.teamone.tempository.project.query.vo;

import lombok.Data;
import org.teamone.tempository.project.query.type.ProjectStatus;


@Data
public class ResponseProject {
    private int id;

    private String name;

    private boolean isPublic;

    private int likeCnt;

    private ProjectStatus status;

    private String content;

}
