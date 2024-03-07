package org.teamone.tempository.project.query.vo;

import lombok.Data;
import org.teamone.tempository.project.query.dto.ProjectIssueDTO;

import java.util.List;

@Data
public class ResponseProjectIssue {

    private int id;

    private List<ProjectIssueDTO> projectIssueDTOList;

}
