package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.vo.WbsResponse;

public interface CommandWbsService {

    void registWbs(CommandWbsDTO wbsDTO);

    void modifyWbs(CommandWbsDTO wbsDTO);

    void deleteWbs(int projectId, int wbsNo);
}
