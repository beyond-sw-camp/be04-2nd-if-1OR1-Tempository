package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;
import org.teamone.projecttemplate.command.vo.WbsRequest;

import java.util.List;

public interface CommandWbsService {

    void insertWbs(CommandWbsDTO wbsDTO);

    void modifyWbs(CommandWbsDTO wbsDTO);

    CommandWbsDTO deleteWbs(int projectId, int wbsNo);

    void deleteAllWbsByProjectId(int projectId);

    List<CommandWbs> modifyAllWbsStatusToCompleted(int projectId);

    void modifyWbsContentByProjectIdAndWbsNo(int projectId, int wbsNo, String content);

    void insertManyWbsByProjectId(int projectId, List<WbsRequest> wbs);

    CommandWbsDTO insertWbsByProjectId(CommandWbsDTO wbsDTO);
}
