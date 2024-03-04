package org.teamone.projecttemplate.command.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.command.dto.DefinitionOfTableDTO;
import org.teamone.projecttemplate.command.entity.CommandDefinitionOfTable;
import org.teamone.projecttemplate.command.repository.CommandDefinitionOfTableRepository;

@Service
public class CommandDefinitionOfTableService {

    private final ModelMapper mapper;
    private final CommandDefinitionOfTableRepository commandDefinitionOfTableRepository;

    @Autowired
    public CommandDefinitionOfTableService(ModelMapper mapper, CommandDefinitionOfTableRepository commandDefinitionOfTableRepository) {
        this.mapper = mapper;
        this.commandDefinitionOfTableRepository = commandDefinitionOfTableRepository;
    }

    /* 설명. Insert New Definition */
    @Transactional
    public void registDefinitionOfTable(DefinitionOfTableDTO newDefinitionOfTable) {
        commandDefinitionOfTableRepository.save(mapper.map(newDefinitionOfTable, CommandDefinitionOfTable.class));
    }

}
