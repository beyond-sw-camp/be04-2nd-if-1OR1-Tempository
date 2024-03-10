package org.teamone.projecttemplate.query.dto;

import lombok.*;
import org.teamone.projecttemplate.query.vo.UserResponse;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WbsUserDTO {

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
