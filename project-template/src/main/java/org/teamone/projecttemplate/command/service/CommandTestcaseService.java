package org.teamone.projecttemplate.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.command.entity.CommandTestcaseEntity;
import org.teamone.projecttemplate.command.repository.CommandTestcaseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandTestcaseService {
    private CommandTestcaseRepository commandTestcaseRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommandTestcaseService(CommandTestcaseRepository commandTestcaseRepository, ModelMapper modelMapper) {
        this.commandTestcaseRepository = commandTestcaseRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. 테스트케이스 추가 */
//    @Transactional
//    public void registTestcase(CommandTestcaseDTO commandTestcaseDTO) {
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        CommandTestcaseEntity commandTestcaseEntity = modelMapper.map(commandTestcaseDTO, CommandTestcaseEntity.class);
//
//        commandTestcaseRepository.save(commandTestcaseEntity);
//    }

//    public List<CommandTestcaseDTO> findAllTestcaseById(int projectId) {
//        List<CommandTestcaseEntity> testcaseList = commandTestcaseRepository.findByProjectId(projectId);
//
//        testcaseList.forEach(System.out::println);
//
//        return testcaseList.stream().map(menu -> modelMapper.map(menu, CommandTestcaseDTO.class)).collect(Collectors.toList());
//    }

    /* 설명. 테스트케이스 추가(testNo 자동 설정) */
    @Transactional
    public void registTestcase(CommandTestcaseDTO commandTestcaseDTO) {

        /* 설명. 프로젝트 id가 같은 프로젝트 찾음 */
        List<CommandTestcaseEntity> testcaseList = commandTestcaseRepository.findByProjectId(commandTestcaseDTO.getProjectId());

        /* 설명. testNo의 가장 큰 값을 찾음 */
        int maxNo = testcaseList.size();

        /* 설명. DTO에 적용 */
        commandTestcaseDTO.setTestNo(maxNo + 1);

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

    /* 설명. 테스트케이스 삭제 */
    @Transactional
    public void deleteTestcase(int id) {
        commandTestcaseRepository.deleteById(id);
    }
}