package org.teamone.tempository.project.query.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResponseId {
    int id;
    List<ResponseIssue> issueList;
    List<ResponseWbs> wbsList;
}
