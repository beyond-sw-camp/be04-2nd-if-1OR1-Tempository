package org.teamone.projecttemplate.command.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.command.service.CommandRequirementService;

@RestController
@RequestMapping("/requirement")
public class RequirementController {
    private final Environment environment;
    private final CommandRequirementService commandRequirementService;

    @Autowired
    public RequirementController(Environment environment, CommandRequirementService commandRequirementService) {
        this.environment = environment;
        this.commandRequirementService = commandRequirementService;
    }

    /* 설명. 요구사항 명세서 추가(RequirementNo 자동 추가) */
    @PostMapping("/regist")
    public String registRequirement(@RequestBody CommandRequirementDTO commandRequirementDTO) {
        commandRequirementService.registRequirement(commandRequirementDTO);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 요구사항 명세서 수정 */
    @PostMapping("/modify")
    public String modifyRequirement(@RequestBody CommandRequirementDTO commandRequirementDTO) {
        commandRequirementService.modifyRequirement(commandRequirementDTO);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 요구사항 명세서 순서 수정(한칸) */
    @PostMapping("/modify/sequence")
    public String modifySequenceRequirement(@RequestParam("id") int id, @RequestParam("num") int num) {
        commandRequirementService.modifySequenceRequirement(id, num);

        return "Server at " + environment.getProperty("local.server.port");
    }


    /* 설명. 요구사항 id로 요구사항 명세서 삭제 */
    @PostMapping("/delete")
    public String deleteRequirement(@RequestParam("id") int id){
        commandRequirementService.deleteRequirement(id);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 요구사항 명세서 전체 삭제 */
}
