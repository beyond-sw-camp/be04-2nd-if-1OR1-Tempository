package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandDefinitionOfTableDTO;
import org.teamone.projecttemplate.command.service.CommandDefinitionOfTableService;
import org.teamone.projecttemplate.command.vo.DefinitionOfTableRequest;
import org.teamone.projecttemplate.command.vo.DefinitionOfTableResponse;

@RestController
@RequestMapping("/definition")
public class CommandDefinitionOfTableController {
    private ModelMapper modelMapper;
    private CommandDefinitionOfTableService commandDefinitionOfTableService;

    @Autowired
    public CommandDefinitionOfTableController(ModelMapper modelMapper,
                                              CommandDefinitionOfTableService commandDefinitionOfTableService) {
        this.modelMapper = modelMapper;
        this.commandDefinitionOfTableService = commandDefinitionOfTableService;
    }

    /* 설명. ID를 통한 Insert, Update 테이블 정의서 */
    @PostMapping("/regist_and_modify")
    public ResponseEntity<DefinitionOfTableResponse> registDefinition(@RequestBody DefinitionOfTableRequest definitionOfTableRequest) {
        CommandDefinitionOfTableDTO commandDefinitionOfTableDTO = modelMapper.map(definitionOfTableRequest, CommandDefinitionOfTableDTO.class);

        commandDefinitionOfTableService.registDefinition(commandDefinitionOfTableDTO);
        DefinitionOfTableResponse definitionOfTableResponse = modelMapper.map(
                commandDefinitionOfTableDTO, DefinitionOfTableResponse.class
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(definitionOfTableResponse);
    }

    /* 설명. 프로젝트 ID를 통한 Delete 테이블 정의서 */
    @DeleteMapping("/remove/{projectId}")
    public ResponseEntity<Void> removeAllDefinitionByProjectId(@PathVariable("projectId") int projectId) {
        commandDefinitionOfTableService.removeAllDefinitionByProjectId(projectId);
        return ResponseEntity.ok().build();
    }

    /* 설명. 테이블 정의서 ID를 통한 Delete 테이블 정의서 */
    @DeleteMapping("/remove/{projectId}/{definitionNo}")
    public ResponseEntity<Void> removeDefinitionByDefinitionNo(@PathVariable("projectId") int projectId,
                                                               @PathVariable("definitionNo") int definitionNo) {
        commandDefinitionOfTableService.removeDefinitionByDefinitionNo(projectId, definitionNo);
        return ResponseEntity.ok().build();
    }
}
