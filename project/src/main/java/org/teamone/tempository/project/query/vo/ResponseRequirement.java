package org.teamone.tempository.project.query.vo;

import lombok.Data;

@Data
public class ResponseRequirement {
    private int requirementNo;
    private String separate;
    private String name;
    private String content;
    private String note;
    private int projectId;
}
