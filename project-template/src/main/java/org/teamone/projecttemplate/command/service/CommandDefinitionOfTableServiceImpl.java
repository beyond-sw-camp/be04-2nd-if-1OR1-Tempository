package org.teamone.projecttemplate.command.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.command.dto.DefinitionOfTableDTO;
import org.teamone.projecttemplate.command.entity.CommandDefinitionOfTable;
import org.teamone.projecttemplate.command.repository.CommandDefinitionOfTableRepository;

@Service
public class CommandDefinitionOfTableServiceImpl implements CommandDefinitionOfTableService{

    private CommandDefinitionOfTableRepository commandDefinitionOfTableRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommandDefinitionOfTableServiceImpl(CommandDefinitionOfTableRepository commandDefinitionOfTableRepository,
                                               ModelMapper modelMapper) {
        this.commandDefinitionOfTableRepository = commandDefinitionOfTableRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. Insert, Update Definition */
    @Transactional
    @Override
    public void registDefinition(DefinitionOfTableDTO definitionOfTableDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandDefinitionOfTable definitionOfTable = modelMapper.map(definitionOfTableDTO, CommandDefinitionOfTable.class);
        commandDefinitionOfTableRepository.save(definitionOfTable);
    }
}
