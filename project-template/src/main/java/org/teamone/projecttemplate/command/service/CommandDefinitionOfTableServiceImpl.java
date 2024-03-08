package org.teamone.projecttemplate.command.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.command.dto.CommandDefinitionOfTableDTO;
import org.teamone.projecttemplate.command.entity.CommandDefinitionOfTable;
import org.teamone.projecttemplate.command.repository.CommandDefinitionOfTableRepository;

import java.util.List;

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

    /* 설명. Insert, Update Definition of Table */
    @Transactional
    @Override
    public void registDefinition(CommandDefinitionOfTableDTO commandDefinitionOfTableDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandDefinitionOfTable commandDefinitionOfTable = modelMapper.map(commandDefinitionOfTableDTO, CommandDefinitionOfTable.class);
        commandDefinitionOfTableRepository.save(commandDefinitionOfTable);
    }

    /* 설명. Delete Definition of Table By Project ID */
    @Transactional
    @Override
    public void removeAllDefinitionByProjectId(int projectId) {
        commandDefinitionOfTableRepository.deleteAllByProjectId(projectId);
    }

    /* 설명. Delete Definition of Table By Project ID and Table No */
    @Transactional
    @Override
    public CommandDefinitionOfTableDTO removeDefinitionByDefinitionNo(int projectId, int definitionNo) {
        CommandDefinitionOfTable findDefinition = commandDefinitionOfTableRepository.findByProjectIdAndDefinitionNo(projectId, definitionNo);

        if (findDefinition != null) {
            commandDefinitionOfTableRepository.deleteByProjectIdAndDefinitionNo(projectId, definitionNo);
            List<CommandDefinitionOfTable> commandDefinitionList = commandDefinitionOfTableRepository.findByProjectIdAndDefinitionNoGreaterThan(projectId, definitionNo);

            for (CommandDefinitionOfTable commandDefinitionOfTable: commandDefinitionList){
                commandDefinitionOfTable.setDefinitionNo(commandDefinitionOfTable.getDefinitionNo() - 1);
                commandDefinitionOfTableRepository.save(commandDefinitionOfTable);
            }

            return modelMapper.map(findDefinition, CommandDefinitionOfTableDTO.class);

        } else {
            throw new EntityNotFoundException("해당 프로젝트 ID와 테이블 정의서 NO에 대한 이슈가 존재하지 않음");
        }
    }
}
