package org.teamone.projecttemplate.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_project_issue")
public class CommandIssue {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "issue_no")
    private int issueNo;

    @Column(name = "issue_name")
    private String issueName;

    @Column(name = "issue_status")
    private String issueStatus;

    private String issueContent;

    private int managerId;

    private int writerId;

    private int projectId;
}
