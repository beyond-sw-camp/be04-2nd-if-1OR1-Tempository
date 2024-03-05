package org.teamone.projecttemplate.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;
import org.teamone.projecttemplate.command.repository.CommandWbsRepository;

@Service
public class CommandWbsService {

    private final ModelMapper modelMapper;

    private final CommandWbsRepository commandWbsRepository;

    @Autowired
    public CommandWbsService(ModelMapper modelMapper, CommandWbsRepository commandWbsRepository) {
        this.modelMapper = modelMapper;
        this.commandWbsRepository = commandWbsRepository;
    }

    @Transactional
    public void registWbs(CommandWbsDTO newWbs) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandWbs commandWbs = modelMapper.map(newWbs, CommandWbs.class);
        System.out.println("commandWbs = " + commandWbs);
        commandWbsRepository.save(commandWbs);

    }

}
