package org.teamone.tempository.project.query.dto;

import lombok.Data;

@Data
public class ProjectIssueDTO {
    private int issueNo;
    private String issueName;
    private String issueStatus;
    private String issueContent;
    private int managerId;
    private int writerId;
    private int projectId;
}
