package org.teamone.projecttemplate.command.service;

import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.command.dto.CommandIssueDTO;

@Service
public interface CommandIssueService {
    void registIssue(CommandIssueDTO issueDTO);
}
