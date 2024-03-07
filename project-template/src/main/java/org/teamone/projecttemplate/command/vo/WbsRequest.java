package org.teamone.projecttemplate.command.vo;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class WbsRequest {

    private int wbsNo;
    private String content;
    private String taskStatus;
    private Date startDate;
    private Date endDate;
    private int managerId;
    private int projectId;
}
