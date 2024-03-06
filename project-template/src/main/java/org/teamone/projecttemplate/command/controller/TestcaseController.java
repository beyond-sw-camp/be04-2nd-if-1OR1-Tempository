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


    /* 설명. 테스트케이스 추가(POST /regist) */
//    @PostMapping("/regist")
//    public String registTestcase(@RequestBody CommandTestcaseDTO commandTestcaseDTO) {
//
//        commandTestcaseService.registTestcase(commandTestcaseDTO);
//
//        return "Server at " + environment.getProperty("local.server.port");
//    }

    /* 설명. 테스트케이스 추가(testNo 자동 설정) */
    @PostMapping("/regist")
    public String registTestcase(@RequestBody CommandTestcaseDTO commandTestcaseDTO) {
        commandTestcaseService.registTestcase(commandTestcaseDTO);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 테스트케이스 수정(POST /modify) */
    @PostMapping("/modify")
    public String modifyTestcase(@RequestBody CommandTestcaseDTO commandTestcaseDTO) {

        commandTestcaseService.modifyTestcase(commandTestcaseDTO);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 테스트케이스 순서 수정(POST /modify/sequence) */
    /* 설명. 파라미터로 테스트케이스 id와 숫자(-1: 순서 위로, 1: 순서 아래로) */
    @PostMapping("/modify/sequence")
    public String modifySequenceTestcase(@RequestParam("id") int id, @RequestParam("num") int num){
        System.out.println("id = " + id);
        System.out.println("num = " + num);
        commandTestcaseService.modifySequenceTestcase(id, num);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 테스트케이스 삭제(POST /delete) */
    @PostMapping("/delete")
    public String deleteTestcase(@RequestParam("id") int id) {
        commandTestcaseService.deleteTestcase(id);

        return "Server at " + environment.getProperty("local.server.port");
    }

}
