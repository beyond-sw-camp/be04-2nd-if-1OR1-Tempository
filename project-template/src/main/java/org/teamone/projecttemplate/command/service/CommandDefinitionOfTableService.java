package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandDefinitionOfTableDTO;

public interface CommandDefinitionOfTableService {
    void registDefinition(CommandDefinitionOfTableDTO commandDefinitionOfTableDTO);

    void removeAllDefinitionByProjectId(int projectId);

    CommandDefinitionOfTableDTO removeDefinitionByDefinitionNo(int projectId, int definitionNo);
}
