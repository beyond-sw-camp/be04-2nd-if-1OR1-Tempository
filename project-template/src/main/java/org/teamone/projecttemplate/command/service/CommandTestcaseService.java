package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;

public interface CommandTestcaseService {
    void registTestcase(CommandTestcaseDTO commandTestcaseDTO);

    void modifyTestcase(CommandTestcaseDTO commandTestcaseDTO);

    CommandTestcaseDTO modifyTestcaseSequence(CommandTestcaseDTO commandTestcaseDTO, int num);

    void removeTestcase(int projectId, int testNo);

    void deleteAllTestcase(int projectId);
}
