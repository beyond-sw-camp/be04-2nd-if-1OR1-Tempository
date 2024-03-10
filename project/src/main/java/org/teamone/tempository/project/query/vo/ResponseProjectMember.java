package org.teamone.tempository.project.query.vo;

import lombok.Data;
import org.teamone.tempository.project.query.dto.ProjectMemberDTO;
import org.teamone.tempository.project.query.type.ProjectStatus;

import java.util.List;

@Data
public class ResponseProjectMember {

    private int id;

    private String name;

    private boolean isPublic;

    private int likeCnt;

    private ProjectStatus status;

    private String content;

    private List<ProjectMemberDTO> projectMemberDTOList;




}
