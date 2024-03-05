package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.service.CommandWbsService;
import org.teamone.projecttemplate.command.vo.WbsRequest;
import org.teamone.projecttemplate.command.vo.WbsResponse;

@RestController
@RequestMapping("/wbs")
public class WbsController {

    private final CommandWbsService commandWbsService;

    private final Environment env;

    private final ModelMapper modelMapper;

    @Autowired
    public WbsController(CommandWbsService commandWbsService, Environment env, ModelMapper modelMapper) {
        this.commandWbsService = commandWbsService;
        this.env = env;
        this.modelMapper = modelMapper;
    }

    /* Environment 활용해 설정 값 불러오기(getProperty) */
    @GetMapping("/health_check")
    public String status() {
        return "Server at " + env.getProperty("local.server.port");
    }

    @Transactional
    @PostMapping("/regist")
    public ResponseEntity<WbsResponse> registUser(@RequestBody WbsRequest wbs) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CommandWbsDTO wbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);
        System.out.println("wbsDTO = " + wbsDTO);

        commandWbsService.registWbs(wbsDTO);
        WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);
        System.out.println("wbsResponse = " + wbsResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(wbsResponse);
    }

}
