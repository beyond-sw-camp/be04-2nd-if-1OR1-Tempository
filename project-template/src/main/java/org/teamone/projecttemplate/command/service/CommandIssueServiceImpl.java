package org.teamone.projecttemplate.command.service;


import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.command.dto.CommandIssueDTO;
import org.teamone.projecttemplate.command.entity.CommandIssue;
import org.teamone.projecttemplate.command.repository.CommandIssueRepository;

@Service
public class CommandIssueServiceImpl implements CommandIssueService {

    private CommandIssueRepository commandIssueRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommandIssueServiceImpl(CommandIssueRepository commandIssueRepository,
                                   ModelMapper modelMapper) {
        this.commandIssueRepository = commandIssueRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public void registIssue(CommandIssueDTO issueDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandIssue commandIssue = modelMapper.map(issueDTO, CommandIssue.class);
        commandIssueRepository.save(commandIssue);
    }
}
