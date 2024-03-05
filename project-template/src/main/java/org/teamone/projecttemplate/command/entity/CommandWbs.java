package org.teamone.projecttemplate.command.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_project_wbs")
public class CommandWbs {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "wbs_no", nullable = false)
    private int wbsNo;

    @Column(name = "content", nullable = false, length = 127)
    private String content;

    @Column(name = "task_status", length = 31)
    private String taskStatus;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "project_id", nullable = false)
    private int projectId;
}
