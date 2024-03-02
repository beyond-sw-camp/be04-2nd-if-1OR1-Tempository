package org.teamone.projecttemplate.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.dto.RequirementDTO;
import org.teamone.projecttemplate.query.entity.Requirement;
import org.teamone.projecttemplate.query.repository.RequirementMapper;

import java.util.List;

@Service
public class RequirementService {

    private final RequirementMapper requirementMapper;

    @Autowired
    public RequirementService(RequirementMapper requirementMapper) {
        this.requirementMapper = requirementMapper;
    }

    /* 설명. projectId로 요구사항 명세서 내용 조회 */
    public List<Requirement> requirementInfoByProjectId(int projectId) {
        List<Requirement> requirementList = requirementMapper.requirementInfoByProjectId(projectId);

        requirementList.forEach(System.out::println);

        return requirementList;
    }

    /* 설명. separate와 projectId로 요구사항 명세서 내용 조회 */
    public List<Requirement> requirementInfoBySeparateAndProjectId(RequirementDTO requirementDTO) {
        Requirement requirement = new Requirement(requirementDTO.getSeparate(), requirementDTO.getProjectId());

        List<Requirement> requirementList = requirementMapper.requirementInfoBySeparateAndProjectId(requirement);

        requirementList.forEach(System.out::println);

        return requirementList;
    }
}
