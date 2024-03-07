package org.teamone.tempository.project.query.vo;

import lombok.Data;
import org.teamone.tempository.project.query.dto.ProjectDefinitionOfTableDTO;
import org.teamone.tempository.project.query.entity.ProjectDefinitionOfTable;

import java.util.List;

@Data
public class ResponseProjectDefinitionOfTable {

    private int id;

    private List<ProjectDefinitionOfTableDTO> projectDefinitionOfTableList;
}
