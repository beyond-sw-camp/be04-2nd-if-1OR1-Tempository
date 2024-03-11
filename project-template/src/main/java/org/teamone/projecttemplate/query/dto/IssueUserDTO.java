package org.teamone.projecttemplate.query.dto;

import lombok.Data;
import org.teamone.projecttemplate.query.vo.UserResponse;

@Data
public class IssueUserDTO {

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
