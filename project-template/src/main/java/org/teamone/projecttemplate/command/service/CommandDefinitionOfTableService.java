package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.DefinitionOfTableDTO;

public interface CommandDefinitionOfTableService {
    void registDefinition(DefinitionOfTableDTO definitionOfTableDTO);

    void removeDefinitionByProjectId(DefinitionOfTableDTO definitionOfTableDTO);

    void removeDefinitionDefinitionId(DefinitionOfTableDTO definitionOfTableDTO);
}
