package org.teamone.projecttemplate.command.service;

import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;

import java.util.List;

public interface CommandWbsService {

    void addWbs(CommandWbsDTO wbsDTO);

    void modifyWbs(CommandWbsDTO wbsDTO);

    List<CommandWbs> modifyAllWbsStatusToCompleted(int projectId);

    CommandWbsDTO removeWbs(int projectId, int wbsNo);

    void removeAllWbsByProjectId(int projectId);

    CommandWbsDTO findWbsByProjectIdAndWbsNo(int projectId, int wbsNo);

    List<CommandWbsDTO> findAllWbsByProjectId(int projectId);


    //    CommandWbsDTO addWbsByProjectId(CommandWbsDTO wbsDTO);

    //    void addManyWbsByProjectId(int projectId, List<CommandWbsRequest> wbs);

    //    void modifyWbsContentByProjectIdAndWbsNo(int projectId, int wbsNo, String content);
}
