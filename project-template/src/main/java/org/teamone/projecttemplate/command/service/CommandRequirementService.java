package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;

public interface CommandRequirementService {
    void registRequirement(CommandRequirementDTO commandRequirementDTO);

    void modifyRequirement(CommandRequirementDTO commandRequirementDTO);

    CommandRequirementDTO modifyRequirementSequence(CommandRequirementDTO commandRequirementDTO, int num);

    void removeRequirement(int projectId, int requirementNo);

    void removeAllRequirment(int projectId);
}
