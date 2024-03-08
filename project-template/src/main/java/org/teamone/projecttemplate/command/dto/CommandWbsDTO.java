package org.teamone.projecttemplate.command.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommandWbsDTO {

    private int id;
    private int wbsNo;
    private String content;
    private String taskStatus;
    private java.util.Date startDate;
    private java.util.Date endDate;
    private int managerId;
    private int projectId;

}
