package org.teamone.projecttemplate.command.service;

import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.command.dto.CommandIssueDTO;
import org.teamone.projecttemplate.command.entity.CommandIssue;

import java.util.List;

@Service
public interface CommandIssueService {
    void registIssue(CommandIssueDTO issueDTO);

    List<CommandIssue> modifyAllStatusToClosedByProjectId(int projectId);

    List<CommandIssue> modifyAllStatusToReopenByProjectId(int projectId);

    void removeAllIssueByProjectId(int projectId);

    CommandIssueDTO removeIssueByIssueNo(int projectId, int issueNo);
}
