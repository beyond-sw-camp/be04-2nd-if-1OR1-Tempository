package org.teamone.projecttemplate.query.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequirementResponse {
    private int id;
    private int requirementNo;
    private String separate;
    private String name;
    private String content;
    private String note;
    private int projectId;
}
