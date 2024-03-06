package org.teamone.tempository.project.query.entity;


import jakarta.persistence.Column;
import org.teamone.tempository.project.query.type.ProjectPosition;

public class ProjectMember {

    private int memberId;

    private int projectId;

    private ProjectPosition position;

    private String memberStatus;
}
