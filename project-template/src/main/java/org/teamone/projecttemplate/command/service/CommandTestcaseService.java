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

    /* 설명. 테스트케이스 수정 */
    @Transactional
    public void modifyTestcase(CommandTestcaseDTO commandTestcaseDTO) {

        /* 설명. 테스트케이스 id로 해당 테스트 케이스를 찾아 변경 */
        int id = commandTestcaseDTO.getId();
        CommandTestcaseEntity commandTestcaseEntity = commandTestcaseRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        commandTestcaseEntity.setSeparate(commandTestcaseDTO.getSeparate());
        commandTestcaseEntity.setContent(commandTestcaseDTO.getContent());
        commandTestcaseEntity.setExpectedValue(commandTestcaseDTO.getExpectedValue());
        commandTestcaseEntity.setResult(commandTestcaseDTO.getResult());
        commandTestcaseEntity.setNote(commandTestcaseDTO.getNote());
    }

    @Transactional
    public void deleteTestcase(int id) {
        commandTestcaseRepository.deleteById(id);
    }
}
