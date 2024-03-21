package org.teamone.projecttemplate.command.service;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.command.entity.CommandTestcase;
import org.teamone.projecttemplate.command.repository.CommandTestcaseRepository;

import java.util.List;

@Service
public class CommandTestcaseServiceImpl implements CommandTestcaseService {
    private final CommandTestcaseRepository commandTestcaseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommandTestcaseServiceImpl(CommandTestcaseRepository commandTestcaseRepository, ModelMapper modelMapper) {
        this.commandTestcaseRepository = commandTestcaseRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. 테스트케이스 추가(testNo 자동 설정) */
    @Override
    @Transactional
    public void AddTestcaseByProjectId(CommandTestcaseDTO commandTestcaseDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        /* 설명. 프로젝트 id가 같은 테스트케이스 찾음 */
        List<CommandTestcase> testcaseList = commandTestcaseRepository.findByProjectId(commandTestcaseDTO.getProjectId());

        /* 설명. testNo의 가장 큰 값을 찾음 */
        int maxNo = testcaseList.size();

        /* 설명. DTO에 testNo 적용 */
        commandTestcaseDTO.setTestNo(maxNo + 1);
        try {
            CommandTestcase commandTestcase = modelMapper.map(commandTestcaseDTO, CommandTestcase.class);
            commandTestcaseRepository.save(commandTestcase);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("부적절한 값으로 인해 테스트케이스를 추가할 수 없습니다.");
        }
    }

    /* 설명. 테스트케이스 수정 */
    @Override
    @Transactional
    public void modifyTestcase(CommandTestcaseDTO commandTestcaseDTO) {

        /* 설명. projectId와 testNo로 테스트케이스를 찾아 변경 */
        CommandTestcase commandTestcase = commandTestcaseRepository.findByProjectIdAndTestNo(
                commandTestcaseDTO.getProjectId(),
                commandTestcaseDTO.getTestNo()
        );

        if (commandTestcase != null) {
            commandTestcase.setSeparate(commandTestcaseDTO.getSeparate());
            commandTestcase.setContent(commandTestcaseDTO.getContent());
            commandTestcase.setExpectedValue(commandTestcaseDTO.getExpectedValue());
            commandTestcase.setResult(commandTestcaseDTO.getResult());
            commandTestcase.setNote(commandTestcaseDTO.getNote());
        } else {
            throw new EntityNotFoundException("해당 테스트 케이스를 찾을 수 없습니다.");
        }
    }

    /* 설명. 테스트케이스 순서 수정 */
    @Override
    @Transactional
    public CommandTestcaseDTO modifyTestcaseSequence(CommandTestcaseDTO commandTestcaseDTO, int num) {

        /* 설명. 바꿀 테스트케이스 */
        CommandTestcase commandTestcase = commandTestcaseRepository.findByProjectIdAndTestNo(
                commandTestcaseDTO.getProjectId(),
                commandTestcaseDTO.getTestNo()
        );

        /* 설명. 다음 순서의 테스트케이스 */
        CommandTestcase sequenceTestcase = commandTestcaseRepository.findByProjectIdAndTestNo(
                commandTestcase.getProjectId(),
                commandTestcase.getTestNo() + num);

        /* 설명. null일 때 예외처리 */
        if (sequenceTestcase == null)
            throw new IllegalArgumentException("순서 변경 없음");

        /* 설명. 순서 바꿈 */
        commandTestcase.setTestNo(commandTestcase.getTestNo() + num);
        sequenceTestcase.setTestNo(sequenceTestcase.getTestNo() - num);

        /* 설명. 변경된 DTO 반환 */
        commandTestcaseDTO = modelMapper.map(commandTestcase, CommandTestcaseDTO.class);

        return commandTestcaseDTO;
    }

    /* 설명. 테스트케이스 삭제 */
    @Override
    @Transactional
    public void removeTestcase(int projectId, int testNo) {

        CommandTestcase commandTestcase = commandTestcaseRepository.findByProjectIdAndTestNo(projectId, testNo);
        if (commandTestcase != null) {
            /* 설명. projectId와 testNo로 테스트케이스 삭제 */
            commandTestcaseRepository.deleteByProjectIdAndTestNo(projectId, testNo);

            /* 설명. 삭제할 테스트케이스와 같은 프로젝트이고 뒷순서인 테스트케이스들 찾기 */
            List<CommandTestcase> testcaseList = commandTestcaseRepository
                    .findByProjectIdAndTestNoGreaterThanOrderByTestNoAsc(projectId, testNo);

            /* 설명. 삭제할 테스트케이스 다음 순서의 테스트케이스들을 앞당김 */
            for (CommandTestcase nextTestcase: testcaseList) {
                nextTestcase.setTestNo(nextTestcase.getTestNo() -1);
            }
        } else {
            throw  new EntityNotFoundException("해당 테스트케이스가 없습니다.");
        }
    }


    /* 설명. 해당 프로젝트의 테스트케이스 전체 삭제 */
    @Override
    @Transactional
    public void removeAllTestcase(int projectId) {
        List<CommandTestcase> commandTestcaseList = commandTestcaseRepository.findByProjectId(projectId);
        if(!commandTestcaseList.isEmpty()) {
            commandTestcaseRepository.deleteAllByProjectId(projectId);
        } else {
            throw new EntityNotFoundException("해당 프로젝트에 테스트케이스가 없습니다.");
        }
    }
}
