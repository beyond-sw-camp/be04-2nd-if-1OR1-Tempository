package org.teamone.projecttemplate.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;
import org.teamone.projecttemplate.command.repository.CommandWbsRepository;

import java.util.List;

@Service
public class CommandWbsServiceImpl implements CommandWbsService{

    private final ModelMapper modelMapper;

    private final CommandWbsRepository commandWbsRepository;

    @Autowired
    public CommandWbsServiceImpl(ModelMapper modelMapper, CommandWbsRepository commandWbsRepository) {
        this.modelMapper = modelMapper;
        this.commandWbsRepository = commandWbsRepository;
    }

    @Transactional
    @Override
    public void registWbs(CommandWbsDTO newWbs) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandWbs> wbsList = commandWbsRepository.findByProjectId(newWbs.getProjectId());
        int maxNo = wbsList.size();
        newWbs.setWbsNo(maxNo + 1);

        commandWbsRepository.save(modelMapper.map(newWbs, CommandWbs.class));

    }
}
