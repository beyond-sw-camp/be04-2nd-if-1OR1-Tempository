package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;

public interface CommandRequirementService {
    void registRequirement(CommandRequirementDTO commandRequirementDTO);
}