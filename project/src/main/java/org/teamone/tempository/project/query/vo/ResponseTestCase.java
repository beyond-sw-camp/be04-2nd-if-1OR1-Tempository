package org.teamone.tempository.project.query.vo;

import lombok.Data;

@Data
public class ResponseTestCase {
    private int testNo;
    private String separate;
    private String content;
    private String expectedValue;
    private String result;
    private String note;
    private int projectId;
}
