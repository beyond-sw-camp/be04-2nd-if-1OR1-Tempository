package org.teamone.projecttemplate.query.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestcaseResponse {
    private int id;
    private int testNo;
    private String separate;
    private String content;
    private String expectedValue;
    private String result;
    private String note;
    private int projectId;
}
