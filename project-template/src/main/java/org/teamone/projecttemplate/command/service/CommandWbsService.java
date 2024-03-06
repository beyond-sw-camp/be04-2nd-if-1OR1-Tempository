package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandWbsDTO;

public interface CommandWbsService {

    void registWbs(CommandWbsDTO wbsDTO);

    void modifyWbs(CommandWbsDTO wbsDTO);
}
