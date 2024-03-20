package org.teamone.tempository.project.query.vo;

import lombok.Data;

@Data
public class ResponseIssue {
    private int issueNo;
    private String issueName;
    private String issueStatus;
    private String issueContent;
    private int managerId;
    private int writerId;
}
