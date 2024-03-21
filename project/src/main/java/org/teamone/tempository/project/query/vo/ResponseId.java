package org.teamone.tempository.project.query.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResponseId {
    private int id;

    private List<ResponseIssue> issueList;

    private List<ResponseWbs> wbsList;

    private List<ResponseRequirement> responseRequirementList;

    private List<ResponseTestCase> testCaseList;

    private List<ResponseDefinitionOfTable> responseDefinitionOfTableList;

}
