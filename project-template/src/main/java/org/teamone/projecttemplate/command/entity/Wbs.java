package org.teamone.projecttemplate.command.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "tbl_project_wbs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Wbs {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "wbs_no")
    private int wbsNo;

    @Column(name = "content")
    private String content;

    @Column(name = "task_status")
    private String taskStatus;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "project_id")
    private int projectId;
}
