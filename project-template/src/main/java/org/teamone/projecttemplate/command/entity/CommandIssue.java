package org.teamone.projecttemplate.command.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    @Column(name = "issue_content")
    private String issueContent;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "writer_id")
    private int writerId;

    @Column(name = "project_id")
    private int projectId;
}
