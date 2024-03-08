package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;
import org.teamone.projecttemplate.command.service.CommandRequirementService;
import org.teamone.projecttemplate.command.vo.CommandRequirementRequest;
import org.teamone.projecttemplate.command.vo.CommandRequirementResponse;
import org.teamone.projecttemplate.command.vo.CommandRequirementSequenceRequest;

@RestController
@RequestMapping("/requirement")
public class CommandRequirementController {
    private final ModelMapper modelMapper;
    private final CommandRequirementService commandRequirementService;

    @Autowired
    public CommandRequirementController(ModelMapper modelMapper, CommandRequirementService commandRequirementService) {
        this.modelMapper = modelMapper;
        this.commandRequirementService = commandRequirementService;
    }

    /* 설명. 요구사항 명세서 추가(RequirementNo 자동 추가) */
    @PostMapping("/regist")
    public ResponseEntity<CommandRequirementResponse> registRequirement(@RequestBody CommandRequirementRequest commandRequirementRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandRequirementDTO commandRequirementDTO = modelMapper.map(commandRequirementRequest, CommandRequirementDTO.class);

        commandRequirementService.registRequirement(commandRequirementDTO);

        CommandRequirementResponse commandRequirementResponse = modelMapper.map(commandRequirementDTO, CommandRequirementResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(commandRequirementResponse);
    }

    /* 설명. 요구사항 명세서 수정 */
    @PutMapping("/modify")
    public ResponseEntity<CommandRequirementResponse> modifyRequirement(
            @RequestBody CommandRequirementRequest commandRequirementRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandRequirementDTO commandRequirementDTO = modelMapper.map(commandRequirementRequest, CommandRequirementDTO.class);

        commandRequirementService.modifyRequirement(commandRequirementDTO);

        CommandRequirementResponse commandRequirementResponse = modelMapper.map(commandRequirementDTO, CommandRequirementResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(commandRequirementResponse);
    }

    /* 설명. 요구사항 명세서 순서 수정(한칸) */
    @PutMapping("/modify/sequence")
    public ResponseEntity<CommandRequirementResponse> modifyRequirementSequence(
            @RequestBody CommandRequirementSequenceRequest commandRequirementSequenceRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandRequirementDTO commandRequirementDTO = new CommandRequirementDTO();

        commandRequirementDTO.setRequirementNo(commandRequirementSequenceRequest.getRequirementNo());
        commandRequirementDTO.setProjectId(commandRequirementSequenceRequest.getProjectId());

        int num = commandRequirementSequenceRequest.getNum();

        commandRequirementDTO = commandRequirementService.modifyRequirementSequence(commandRequirementDTO, num);

        CommandRequirementResponse commandRequirementResponse = modelMapper.map(commandRequirementDTO, CommandRequirementResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(commandRequirementResponse);
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
