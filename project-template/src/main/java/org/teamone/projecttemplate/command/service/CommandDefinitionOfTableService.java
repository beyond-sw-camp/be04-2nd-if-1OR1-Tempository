package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandDefinitionOfTableDTO;
import org.teamone.projecttemplate.query.dto.DefinitionOfTableDTO;

public interface CommandDefinitionOfTableService {
    void registDefinition(CommandDefinitionOfTableDTO commandDefinitionOfTableDTO);

    void removeAllDefinitionByProjectId(int projectId);

    DefinitionOfTableDTO removeDefinitionByDefinitionNo(int projectId, int definitionNo);
}
