package org.teamone.projecttemplate.command.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommandIssueRequest {
    private int issueNo;
    private String issueName;
    private String issueStatus;
    private String issueContent;
    private int managerId;
    private int writerId;
    private int projectId;
}
