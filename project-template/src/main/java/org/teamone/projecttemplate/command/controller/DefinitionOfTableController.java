package org.teamone.projecttemplate.command.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.projecttemplate.command.dto.DefinitionOfTableDTO;

import java.util.List;

@RestController
@RequestMapping("/")
public class DefinitionOfTableController {
    private List<DefinitionOfTableDTO> definitionOfTableDTOList;

    public DefinitionOfTableController(List<DefinitionOfTableDTO> definitionOfTableDTOList) {
        this.definitionOfTableDTOList = definitionOfTableDTOList;
    }
}
