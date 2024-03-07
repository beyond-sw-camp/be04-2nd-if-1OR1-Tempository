package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.DefinitionOfTableDTO;
import org.teamone.projecttemplate.command.service.CommandDefinitionOfTableService;
import org.teamone.projecttemplate.command.vo.DefinitionOfTableRequest;
import org.teamone.projecttemplate.command.vo.DefinitionOfTableResponse;

@RestController
@RequestMapping("/definition")
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

    /* 설명. ID를 통한 Insert, Update 테이블 정의서 */
    @PostMapping("/regist_and_modify")
    public ResponseEntity<DefinitionOfTableResponse> registDefinition(@RequestBody DefinitionOfTableRequest definitionOfTableRequest) {
        DefinitionOfTableDTO definitionOfTableDTO = modelMapper.map(definitionOfTableRequest, DefinitionOfTableDTO.class);

        commandDefinitionOfTableService.registDefinition(definitionOfTableDTO);
        DefinitionOfTableResponse definitionOfTableResponse = modelMapper.map(
                definitionOfTableDTO, DefinitionOfTableResponse.class
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(definitionOfTableResponse);
    }

    /* 설명. 프로젝트 ID를 통한 Delete 테이블 정의서 */
    @PostMapping("/remove_by_project_id")
    public ResponseEntity<DefinitionOfTableResponse> removeDefinitionByProjectId(
            @RequestBody DefinitionOfTableRequest definitionOfTableRequest){
        DefinitionOfTableDTO definitionOfTableDTO = modelMapper.map(definitionOfTableRequest, DefinitionOfTableDTO.class);

        commandDefinitionOfTableService.removeDefinitionByProjectId(definitionOfTableDTO);
        DefinitionOfTableResponse definitionOfTableResponse = modelMapper.map(
                definitionOfTableDTO, DefinitionOfTableResponse.class
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(definitionOfTableResponse);
    }

    /* 설명. 테이블 정의서 ID를 통한 Delete 테이블 정의서 */
    @PostMapping("/remove_by_deifintion_id")
    public ResponseEntity<DefinitionOfTableResponse> removeDefinitionByDefinitionId(
            @RequestBody DefinitionOfTableRequest definitionOfTableRequest){
        DefinitionOfTableDTO definitionOfTableDTO = modelMapper.map(definitionOfTableRequest, DefinitionOfTableDTO.class);

        commandDefinitionOfTableService.removeDefinitionDefinitionId(definitionOfTableDTO);
        DefinitionOfTableResponse definitionOfTableResponse = modelMapper.map(
                definitionOfTableDTO, DefinitionOfTableResponse.class
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(definitionOfTableResponse);
    }

}
