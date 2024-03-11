package org.teamone.projecttemplate.query.vo;

import lombok.Data;

@Data
public class IssueUserResponse {

    private int id;
    private int issueNo;
    private String issueName;
    private String issueStatus;
    private String issueContent;
    private int managerId;
    private int writerId;
    private int projectId;

    private UserResponse userResponse;
}
