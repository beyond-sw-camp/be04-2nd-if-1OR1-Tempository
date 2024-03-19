package org.teamone.projecttemplate.query.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teamone.projecttemplate.query.dto.RequirementDTO;
import org.teamone.projecttemplate.query.service.RequirementService;
import org.teamone.projecttemplate.query.vo.IssueResponse;
import org.teamone.projecttemplate.query.vo.RequirementResponse;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/requirement")
public class RequirementController {

    private final RequirementService requirementService;

    private final ModelMapper modelMapper;

    @Autowired
    public RequirementController(RequirementService requirementService, ModelMapper modelMapper) {
        this.requirementService = requirementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("find/{projectId}")
    public ResponseEntity<List<RequirementResponse>> findRequirementByProjectId(@PathVariable("projectId") int projectId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<RequirementDTO> requirementDTOList = requirementService.findRequirementByProjectId(projectId);

        List<RequirementResponse> requirementResponseList = new ArrayList<>();
        for (RequirementDTO requirement: requirementDTOList) {
            RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
            requirementResponseList.add(requirementResponse);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body( requirementResponseList);
    }

    @GetMapping("findSeparate/{projectId}/{separate}")
    public ResponseEntity<List<RequirementResponse>> findRequirementBySeparateAndProjectId(
            @PathVariable("projectId") int projectId,
            @PathVariable("separate") String separate) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        RequirementDTO requirementDTO = new RequirementDTO(separate, projectId);

        List<RequirementDTO> requirementDTOList = requirementService.findRequirementBySeparateAndProjectId(requirementDTO);

        List<RequirementResponse> requirementResponseList = new ArrayList<>();
        for (RequirementDTO requirement: requirementDTOList) {
            RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
            requirementResponseList.add(requirementResponse);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(requirementResponseList);
    }

    @GetMapping("findRequirementNo/{projectId}/{requirementNo}")
    public ResponseEntity<RequirementResponse> findRequirementByRequirementNoAndProjectId(
            @PathVariable("projectId") int projectId,
            @PathVariable("requirementNo") int requirementNo) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        RequirementDTO requirementDTO = requirementService.findRequirementByRequirementNoAndProjectId(requirementNo, projectId);

        RequirementResponse requirementResponse = modelMapper.map(requirementDTO, RequirementResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(requirementResponse);
    }
}
