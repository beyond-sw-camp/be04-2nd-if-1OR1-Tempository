package org.teamone.projecttemplate.query.vo;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WbsUserResponse {

    private int id;
    private int wbsNo;
    private String content;
    private String taskStatus;
    private Date startDate;
    private Date endDate;
    private int managerId;
    private int projectId;

    private UserResponse userResponse;

}
