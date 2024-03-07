package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;
import org.teamone.projecttemplate.command.service.CommandRequirementService;
import org.teamone.projecttemplate.command.vo.RequirementRequest;
import org.teamone.projecttemplate.command.vo.RequirementSequenceRequest;

@RestController
@RequestMapping("/requirement")
public class RequirementController {
    private final Environment environment;

    private final ModelMapper modelMapper;
    private final CommandRequirementService commandRequirementService;

    @Autowired
    public RequirementController(Environment environment,ModelMapper modelMapper, CommandRequirementService commandRequirementService) {
        this.environment = environment;
        this.modelMapper = modelMapper;
        this.commandRequirementService = commandRequirementService;
    }

    /* 설명. 요구사항 명세서 추가(RequirementNo 자동 추가) */
    @PostMapping("/regist")
    public String registRequirement(@RequestBody RequirementRequest requirementRequest) {
        CommandRequirementDTO commandRequirementDTO = modelMapper.map(requirementRequest, CommandRequirementDTO.class);
        commandRequirementService.registRequirement(commandRequirementDTO);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 요구사항 명세서 수정 */
    @PostMapping("/modify")
    public String modifyRequirement(@RequestBody RequirementRequest requirementRequest) {
        CommandRequirementDTO commandRequirementDTO = modelMapper.map(requirementRequest, CommandRequirementDTO.class);
        commandRequirementService.modifyRequirement(commandRequirementDTO);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 요구사항 명세서 순서 수정(한칸) */
    @PostMapping("/modify/sequence")
    public String modifySequenceRequirement(@RequestBody RequirementSequenceRequest requirementSequenceRequest) {
        CommandRequirementDTO commandRequirementDTO = new CommandRequirementDTO();

        commandRequirementDTO.setRequirementNo(requirementSequenceRequest.getRequirementNo());
        commandRequirementDTO.setProjectId(requirementSequenceRequest.getProjectId());

        int num = requirementSequenceRequest.getNum();

        commandRequirementService.modifySequenceRequirement(commandRequirementDTO, num);

        return "Server at " + environment.getProperty("local.server.port");
    }


    /* 설명. 프로젝트 id와 requirementNo로 요구사항 명세서 삭제 */
    @PostMapping("/delete/{projectId}/{requirementNo}")
    public String deleteRequirement(
            @PathVariable("projectId") int projectId,
            @PathVariable("requirementNo") int requirementNo){

        System.out.println("=========================");
        System.out.println("projectId = " + projectId);
        System.out.println("requirementNo = " + requirementNo);
        commandRequirementService.deleteRequirement(projectId, requirementNo);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 프로젝트 id로 요구사항 명세서 전체 삭제 */
    @PostMapping("/deleteAll/{projectId}")
    public String deleteAllRequirement(@PathVariable("projectId") int projectId) {
        commandRequirementService.deleteAllRequirment(projectId);

        return "Server at " + environment.getProperty("local.server.port");
    }
}
