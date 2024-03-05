package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.DefinitionOfTableDTO;
import org.teamone.projecttemplate.command.service.CommandDefinitionOfTableService;
import org.teamone.projecttemplate.command.vo.DefinitionOfTableRequest;
import org.teamone.projecttemplate.command.vo.DefinitionOfTableResponse;

@RestController
@RequestMapping("/")
public class DefinitionOfTableController {
   private Environment env;
    private ModelMapper modelMapper;
    private CommandDefinitionOfTableService commandDefinitionOfTableService;

    @Autowired
    public DefinitionOfTableController(Environment env,
                                       ModelMapper modelMapper,
                                       CommandDefinitionOfTableService commandDefinitionOfTableService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.commandDefinitionOfTableService = commandDefinitionOfTableService;
    }

    /* 설명. Insert 테이블 정의서 */
    @PostMapping("/insert_definitions")
    public ResponseEntity<DefinitionOfTableResponse> registDefinition(@RequestBody DefinitionOfTableRequest definitionOfTableRequest){
        DefinitionOfTableDTO definitionOfTableDTO = modelMapper.map(definitionOfTableRequest, DefinitionOfTableDTO.class);

        commandDefinitionOfTableService.registDefinition(definitionOfTableDTO);
        DefinitionOfTableResponse definitionOfTableResponse = modelMapper.map(
                definitionOfTableDTO, DefinitionOfTableResponse.class
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(definitionOfTableResponse);
    }

    /* 설명. Update 테이블 정의서 */
}
