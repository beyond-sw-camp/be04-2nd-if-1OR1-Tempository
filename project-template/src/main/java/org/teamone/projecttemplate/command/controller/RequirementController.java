package org.teamone.projecttemplate.command.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
