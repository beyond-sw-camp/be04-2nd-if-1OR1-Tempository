package org.teamone.projecttemplate.command.controller;

import lombok.extern.slf4j.Slf4j;
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

@Controller
@RequestMapping("/")
public class DefinitionOfTableController {
    private final CommandDefinitionOfTableService commandDefinitionOfTableService;
    private final Environment env;
    private final ModelMapper modelMapper;

    @Autowired
    public DefinitionOfTableController(CommandDefinitionOfTableService commandDefinitionOfTableService, Environment env, ModelMapper modelMapper) {
        this.commandDefinitionOfTableService = commandDefinitionOfTableService;
        this.env = env;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/health_check")
    public String status() {
        return "Server at " + env.getProperty("local.server.port")
                + "\nswcamp.message: " + env.getProperty("swcamp.message");
    }

    @PostMapping("/definitions_of_tables_from_project")
    public ResponseEntity<DefinitionOfTableResponse> insertDefinitionOfTable (@RequestBody DefinitionOfTableRequest definitionOfTableRequest) {
        DefinitionOfTableDTO definitionOfTableDTO = modelMapper.map(definitionOfTableRequest, DefinitionOfTableDTO.class);
        System.out.println("definitionOfTableDTO = " + definitionOfTableDTO);

        DefinitionOfTableResponse definitionOfTableResponse = new DefinitionOfTableResponse();
        definitionOfTableResponse.setTableName(definitionOfTableDTO.getTableName());
        definitionOfTableResponse.setPropertyName(definitionOfTableDTO.getPropertyName());
        definitionOfTableResponse.setPrimaryKey(definitionOfTableDTO.isPrimaryKey());
        definitionOfTableResponse.setForeignKey(definitionOfTableDTO.isForeignKey());
        definitionOfTableResponse.setNullAble(definitionOfTableDTO.isNull_able());
        definitionOfTableResponse.setColumnName(definitionOfTableDTO.getColumnName());
        definitionOfTableResponse.setDefaultValue(definitionOfTableDTO.getDefaultValue());
        definitionOfTableResponse.setDataType(definitionOfTableDTO.getDataType());
        definitionOfTableResponse.setNote(definitionOfTableDTO.getNote());

        return ResponseEntity.status(HttpStatus.CREATED).body(definitionOfTableResponse);
    }

    @GetMapping("/regist")
    public void registPage() {}
    @PostMapping("/regist")
    public String registDefinitionOfTable(DefinitionOfTableDTO newDefinitionOfTable) {
        commandDefinitionOfTableService.registDefinitionOfTable(newDefinitionOfTable);
        System.out.println("newDefinitionOfTable = " + newDefinitionOfTable);

        return commandDefinitionOfTableService.toString();
    }
}
