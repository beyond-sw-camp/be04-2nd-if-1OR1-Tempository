package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;
import org.teamone.projecttemplate.command.service.CommandRequirementService;
import org.teamone.projecttemplate.command.vo.RequirementRequest;
import org.teamone.projecttemplate.command.vo.RequirementResponse;
import org.teamone.projecttemplate.command.vo.RequirementSequenceRequest;

@RestController
@RequestMapping("/requirement")
public class RequirementController {
    private final ModelMapper modelMapper;
    private final CommandRequirementService commandRequirementService;

    @Autowired
    public RequirementController(ModelMapper modelMapper, CommandRequirementService commandRequirementService) {
        this.modelMapper = modelMapper;
        this.commandRequirementService = commandRequirementService;
    }

    /* 설명. 요구사항 명세서 추가(RequirementNo 자동 추가) */
    @PostMapping("/regist")
    public ResponseEntity<RequirementResponse> registRequirement(@RequestBody RequirementRequest requirementRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandRequirementDTO commandRequirementDTO = modelMapper.map(requirementRequest, CommandRequirementDTO.class);

        commandRequirementService.registRequirement(commandRequirementDTO);

        RequirementResponse requirementResponse = modelMapper.map(commandRequirementDTO, RequirementResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(requirementResponse);
    }

    /* 설명. 요구사항 명세서 수정 */
    @PutMapping("/modify")
    public ResponseEntity<RequirementResponse> modifyRequirement(
            @RequestBody RequirementRequest requirementRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandRequirementDTO commandRequirementDTO = modelMapper.map(requirementRequest, CommandRequirementDTO.class);

        commandRequirementService.modifyRequirement(commandRequirementDTO);

        RequirementResponse requirementResponse = modelMapper.map(commandRequirementDTO, RequirementResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(requirementResponse);
    }

    /* 설명. 요구사항 명세서 순서 수정(한칸) */
    @PutMapping("/modify/sequence")
    public ResponseEntity<RequirementResponse> modifyRequirementSequence(
            @RequestBody RequirementSequenceRequest requirementSequenceRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandRequirementDTO commandRequirementDTO = new CommandRequirementDTO();

        commandRequirementDTO.setRequirementNo(requirementSequenceRequest.getRequirementNo());
        commandRequirementDTO.setProjectId(requirementSequenceRequest.getProjectId());

        int num = requirementSequenceRequest.getNum();

        commandRequirementDTO = commandRequirementService.modifyRequirementSequence(commandRequirementDTO, num);

        RequirementResponse requirementResponse = modelMapper.map(commandRequirementDTO, RequirementResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(requirementResponse);
    }


    /* 설명. 프로젝트 id와 requirementNo로 요구사항 명세서 삭제 */
    @DeleteMapping("/remove/{projectId}/{requirementNo}")
    public ResponseEntity<String> removeRequirement(
            @PathVariable("projectId") int projectId,
            @PathVariable("requirementNo") int requirementNo){

        commandRequirementService.removeRequirement(projectId, requirementNo);

        return ResponseEntity.ok("요구사항 명세서가 삭제되었습니다.");
    }

    /* 설명. 프로젝트 id로 요구사항 명세서 전체 삭제 */
    @DeleteMapping("/removeAll/{projectId}")
    public ResponseEntity<String> removeAllRequirement(@PathVariable("projectId") int projectId) {
        commandRequirementService.removeAllRequirment(projectId);

        return ResponseEntity.ok("테스트케이스가 전체 삭제되었습니다.");
    }
}
