package org.teamone.projecttemplate.command.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.command.service.CommandTestcaseService;

@RestController
@RequestMapping("/testcase")
@Slf4j
public class TestcaseController {
    private Environment environment;

    private CommandTestcaseService commandTestcaseService;

    @Autowired
    public TestcaseController(Environment environment, CommandTestcaseService commandTestcaseService) {
        this.environment = environment;
        this.commandTestcaseService = commandTestcaseService;
    }

    /* 설명. 테이스케이스 추가(POST /regist) */
    @PostMapping("/regist")
    public String registTestcase(@RequestBody CommandTestcaseDTO commandTestcaseDTO) {

        commandTestcaseService.registTestcase(commandTestcaseDTO);

        return "Server at " + environment.getProperty("local.server.port");
    }

    @PostMapping("/modify")
    public String modifyTestcase(@RequestBody CommandTestcaseDTO commandTestcaseDTO) {

        System.out.println("commandTestcaseDTO = " + commandTestcaseDTO);
        commandTestcaseService.modifyTestcase(commandTestcaseDTO);

        return "Server at " + environment.getProperty("local.server.port");
    }

}
