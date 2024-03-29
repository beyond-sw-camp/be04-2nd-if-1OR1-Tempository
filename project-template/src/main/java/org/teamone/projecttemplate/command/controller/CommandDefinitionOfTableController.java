package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandDefinitionOfTableDTO;
import org.teamone.projecttemplate.command.service.CommandDefinitionOfTableService;
import org.teamone.projecttemplate.command.vo.CommandDefinitionOfTableRequest;
import org.teamone.projecttemplate.command.vo.CommandDefinitionOfTableResponse;

@RestController
@RequestMapping("/definition")
public class CommandDefinitionOfTableController {
    private final ModelMapper modelMapper;
    private final CommandDefinitionOfTableService commandDefinitionOfTableService;

    @Autowired
    public CommandDefinitionOfTableController(ModelMapper modelMapper,
                                              CommandDefinitionOfTableService commandDefinitionOfTableService) {
        this.modelMapper = modelMapper;
        this.commandDefinitionOfTableService = commandDefinitionOfTableService;
    }

    /* 설명. Insert, Update 테이블 정의서 */
    @PostMapping("/regist-and-modify")
    public ResponseEntity<CommandDefinitionOfTableResponse> registDefinition(@RequestBody CommandDefinitionOfTableRequest definitionOfTableRequest) {
        CommandDefinitionOfTableDTO commandDefinitionOfTableDTO = modelMapper.map(definitionOfTableRequest, CommandDefinitionOfTableDTO.class);

        commandDefinitionOfTableService.registDefinition(commandDefinitionOfTableDTO);
        CommandDefinitionOfTableResponse definitionOfTableResponse = modelMapper.map(
                commandDefinitionOfTableDTO, CommandDefinitionOfTableResponse.class
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(definitionOfTableResponse);
    }

    /* 설명. 프로젝트 ID를 통한 Delete 모든 테이블 정의서 */
    @DeleteMapping("/remove/{projectId}")
    public ResponseEntity<Void> removeAllDefinitionByProjectId(@PathVariable("projectId") int projectId) {
        commandDefinitionOfTableService.removeAllDefinitionByProjectId(projectId);
        return ResponseEntity.ok().build();
    }

    /* 설명. 프로젝트 ID와 정의서 번호를 통한 Delete 테이블 정의서 */
    @DeleteMapping("/remove/{projectId}/{definitionNo}")
    public ResponseEntity<Void> removeDefinitionByDefinitionNo(@PathVariable("projectId") int projectId,
                                                               @PathVariable("definitionNo") int definitionNo) {
        commandDefinitionOfTableService.removeDefinitionByDefinitionNo(projectId, definitionNo);
        return ResponseEntity.ok().build();
    }
}
