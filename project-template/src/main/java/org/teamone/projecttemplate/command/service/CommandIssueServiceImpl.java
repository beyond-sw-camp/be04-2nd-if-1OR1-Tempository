package org.teamone.projecttemplate.command.service;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.command.dto.CommandIssueDTO;
import org.teamone.projecttemplate.command.entity.CommandIssue;
import org.teamone.projecttemplate.command.repository.CommandIssueRepository;

import java.util.List;

@Service
public class CommandIssueServiceImpl implements CommandIssueService {

    private final CommandIssueRepository commandIssueRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommandIssueServiceImpl(CommandIssueRepository commandIssueRepository,
                                   ModelMapper modelMapper) {
        this.commandIssueRepository = commandIssueRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. Insert, Update Issue */
    @Transactional
    @Override
    public void registIssue(CommandIssueDTO issueDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CommandIssue> commandIssueList = commandIssueRepository.findByProjectId(issueDTO.getProjectId());

        int maxNo = commandIssueList.size();
        issueDTO.setIssueNo(maxNo + 1);
        CommandIssue commandIssue = modelMapper.map(issueDTO, CommandIssue.class);

        commandIssueRepository.save(commandIssue);
    }

    /* 설명. Modify Issue Status By Project Id*/
    /* CLOSED */
    @Transactional
    @Override
    public List<CommandIssue> modifyAllStatusToClosedByProjectId(int projectId) {
        List<CommandIssue> commandIssueList = commandIssueRepository.findAllByProjectId(projectId);

        for (CommandIssue commandIssue : commandIssueList) {
            commandIssue.setIssueStatus("CLOSED");
        }

        return commandIssueRepository.saveAll(commandIssueList);
    }

    /* OPEN */
    @Transactional
    @Override
    public List<CommandIssue> modifyAllStatusToReopenByProjectId(int projectId) {
        List<CommandIssue> commandIssueList = commandIssueRepository.findAllByProjectId(projectId);

        for (CommandIssue commandIssue : commandIssueList) {
            commandIssue.setIssueStatus("OPEN");
        }

        return commandIssueRepository.saveAll(commandIssueList);
    }

    /* 설명. Delete Issue By Project ID */
    @Transactional
    @Override
    public void removeAllIssueByProjectId(int projectId) {
        commandIssueRepository.deleteAllByProjectId(projectId);
    }

    /* 설명. Delete Issue By Issue No */
    @Transactional
    @Override
    public CommandIssueDTO removeIssueByIssueNo(int projectId, int issueNo) {
        CommandIssue findCommandIssue = commandIssueRepository.findByProjectIdAndIssueNo(projectId, issueNo);

        if (findCommandIssue != null) {
            commandIssueRepository.deleteByProjectIdAndIssueNo(projectId, issueNo);
            List<CommandIssue> commandIssueList = commandIssueRepository.findByProjectIdAndIssueNoGreaterThan(projectId, issueNo);

            for (CommandIssue commandIssue: commandIssueList){
                commandIssue.setIssueNo(commandIssue.getIssueNo() - 1);
                commandIssueRepository.save(commandIssue);
            }

            return modelMapper.map(findCommandIssue, CommandIssueDTO.class);

        } else {
            throw new EntityNotFoundException("해당 프로젝트 ID와 이슈 NO에 대한 이슈가 존재하지 않음");
        }
    }
}
