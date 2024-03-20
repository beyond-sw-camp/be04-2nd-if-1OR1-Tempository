package org.teamone.tempository.project.query.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseWbs {
    private int wbsNo;
    private String content;
    private String taskStatus;
    private Date startDate;
    private Date endDate;
    private int managerId;
    private int projectId;
}
