package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;

public interface CommandRequirementService {
    void registRequirement(CommandRequirementDTO commandRequirementDTO);

    void modifyRequirement(CommandRequirementDTO commandRequirementDTO);

    void modifySequenceRequirement(int id, int num);

    void deleteRequirement(int id);

    void deleteAllRequirment(int projectId);
}
