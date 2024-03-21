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

    public void validate() {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("내용은 필수 입력 항목입니다.");
        }

//        if (startDate.after(endDate)) {
//            throw new IllegalArgumentException("시작일은 종료일보다 이전이어야 합니다.");
//        }
    }
}
