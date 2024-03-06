package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;

public interface CommandTestcaseService {
    void registTestcase(CommandTestcaseDTO commandTestcaseDTO);

    void modifyTestcase(CommandTestcaseDTO commandTestcaseDTO);

    void modifySequenceTestcase(int id, int num);

    void deleteTestcase(int id);

    void deleteAllTestcase(int projectId);
}
