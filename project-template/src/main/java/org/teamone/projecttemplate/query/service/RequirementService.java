package org.teamone.projecttemplate.query.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.dto.RequirementDTO;
import org.teamone.projecttemplate.query.entity.Requirement;
import org.teamone.projecttemplate.query.repository.RequirementMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequirementService {

    private final RequirementMapper requirementMapper;

    private final ModelMapper modelMapper;

    @Autowired
    public RequirementService(RequirementMapper requirementMapper,
                              ModelMapper modelMapper) {
        this.requirementMapper = requirementMapper;
        this.modelMapper = modelMapper;
    }

    /* 설명. projectId로 요구사항 명세서 내용 조회 */
    public List<RequirementDTO> findRequirementByProjectId(int projectId) {
        List<Requirement> requirementList = requirementMapper.selectRequirementByProjectId(projectId);

        List<RequirementDTO> requirementDTOList = new ArrayList<>();
        for (Requirement nextRequirement: requirementList) {
            RequirementDTO newIssueDTO = modelMapper.map(nextRequirement, RequirementDTO.class);
            requirementDTOList.add(newIssueDTO);
        }

        return requirementDTOList;
    }

    /* 설명. separate와 projectId로 요구사항 명세서 내용 조회 */
    public List<RequirementDTO> findRequirementBySeparateAndProjectId(RequirementDTO requirementDTO) {
        Requirement requirement = new Requirement(requirementDTO.getSeparate(), requirementDTO.getProjectId());

        List<Requirement> requirementList = requirementMapper.selectRequirementBySeparateAndProjectId(requirement);
        List<RequirementDTO> requirementDTOList = new ArrayList<>();
        for (Requirement nextRequirement: requirementList) {
            RequirementDTO newIssueDTO = modelMapper.map(nextRequirement, RequirementDTO.class);
            requirementDTOList.add(newIssueDTO);
        }

        return requirementDTOList;
    }

    /* 설명. 테스트케이스 id와 requirementNo로 조회 */
    public RequirementDTO findRequirementByRequirementNoAndProjectId(int requirementNo, int projectId) {
        Map<String, Integer> intMap = new HashMap<>();
        intMap.put("requirementNo", requirementNo);
        intMap.put("projectId", projectId);

        Requirement requirement = requirementMapper.selectRequirementByRequirementNoAndProjectId(intMap);
        RequirementDTO requirementDTO =  modelMapper.map(requirement, RequirementDTO.class);

        return requirementDTO;
    }
}
