package org.teamone.projecttemplate.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.command.entity.CommandTestcaseEntity;
import org.teamone.projecttemplate.command.repository.CommandTestcaseRepository;

@Service
public class CommandTestcaseService {
    private CommandTestcaseRepository commandTestcaseRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommandTestcaseService(CommandTestcaseRepository commandTestcaseRepository, ModelMapper modelMapper) {
        this.commandTestcaseRepository = commandTestcaseRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void registTestcase(CommandTestcaseDTO commandTestcaseDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CommandTestcaseEntity commandTestcaseEntity = modelMapper.map(commandTestcaseDTO, CommandTestcaseEntity.class);

        commandTestcaseRepository.save(commandTestcaseEntity);
    }
}
