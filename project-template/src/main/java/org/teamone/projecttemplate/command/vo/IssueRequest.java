package org.teamone.projecttemplate.command.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class IssueRequest {
    private int id;
    private int issueNo;
    private String issueName;
    private String issueStatus;
    private String issueContent;
    private int managerId;
    private int writerId;
    private int projectId;
}
