package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;

public interface CommandRequirementService {
    void registRequirement(CommandRequirementDTO commandRequirementDTO);

    void modifyRequirement(CommandRequirementDTO commandRequirementDTO);

    void modifySequenceRequirement(CommandRequirementDTO commandRequirementDTO, int num);

    void deleteRequirement(int projectId, int requirementNo);

    void deleteAllRequirment(int projectId);
}
