package org.teamone.projecttemplate.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.command.entity.CommandTestcase;
import org.teamone.projecttemplate.command.repository.CommandTestcaseRepository;

import java.util.List;

@Service
public class CommandTestcaseServiceImpl implements CommandTestcaseService {
    private CommandTestcaseRepository commandTestcaseRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommandTestcaseServiceImpl(CommandTestcaseRepository commandTestcaseRepository, ModelMapper modelMapper) {
        this.commandTestcaseRepository = commandTestcaseRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. 테스트케이스 추가(testNo 자동 설정) */
    @Override
    @Transactional
    public void registTestcase(CommandTestcaseDTO commandTestcaseDTO) {

        /* 설명. 프로젝트 id가 같은 프로젝트 찾음 */
        List<CommandTestcase> testcaseList = commandTestcaseRepository.findByProjectId(commandTestcaseDTO
                .getProjectId());

        /* 설명. testNo의 가장 큰 값을 찾음 */
        int maxNo = testcaseList.size();

        /* 설명. DTO에 적용 */
        commandTestcaseDTO.setTestNo(maxNo + 1);

        CommandTestcase commandTestcase = modelMapper.map(commandTestcaseDTO, CommandTestcase.class);
        commandTestcaseRepository.save(commandTestcase);
    }

    /* 설명. 테스트케이스 수정 */
    @Override
    @Transactional
    public void modifyTestcase(CommandTestcaseDTO commandTestcaseDTO) {

        /* 설명. 테스트케이스 id로 해당 테스트 케이스를 찾아 변경 */
        int id = commandTestcaseDTO.getId();
        CommandTestcase commandTestcase = commandTestcaseRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        commandTestcase.setSeparate(commandTestcaseDTO.getSeparate());
        commandTestcase.setContent(commandTestcaseDTO.getContent());
        commandTestcase.setExpectedValue(commandTestcaseDTO.getExpectedValue());
        commandTestcase.setResult(commandTestcaseDTO.getResult());
        commandTestcase.setNote(commandTestcaseDTO.getNote());
    }

    /* 설명. 테스트케이스 순서 수정 */
    @Override
    @Transactional
    public void modifySequenceTestcase(int id, int num) {
        CommandTestcase commandTestcase = commandTestcaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("변경할 테스트케이스가 존재하지 않습니다."));

        CommandTestcase sequenceTestEntity = commandTestcaseRepository.findByProjectIdAndTestNo(
                commandTestcase.getProjectId(),
                commandTestcase.getTestNo() + num);

        /* 설명. null일 때 예외처리 */
        if (sequenceTestEntity == null)
            throw new IllegalArgumentException("순서 변경 없음");

        commandTestcase.setTestNo(commandTestcase.getTestNo() + num);
        sequenceTestEntity.setTestNo(sequenceTestEntity.getTestNo() - num);
    }

    /* 설명. 테스트케이스 삭제 */
    @Override
    @Transactional
    public void deleteTestcase(int id) {
        /* 설명. 삭제할 테스트케이스 찾기 */
        CommandTestcase commandTestcase = commandTestcaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 테스트케이스가 존재하지 않습니다."));


        /* 설명. 삭제할 테스트케이스와 같은 프로젝트인 테스트케이스 찾기 */
        List<CommandTestcase> testcaseList = commandTestcaseRepository
                .findByProjectIdOrderByTestNoAsc(commandTestcase.getProjectId());

        /* 설명. 삭제할 테스트케이스 다음 순서의 테스트케이스들을 앞당김 */
        int testNo = commandTestcase.getTestNo();
        for (int i = testNo; i < testcaseList.size(); i++) {
            testcaseList.get(i).setTestNo(i);
        }

        /* 설명. 테스트케이스 삭제 */
        commandTestcaseRepository.deleteById(id);
    }


    /* 설명. 해당 프로젝트의 테스트케이스 전체 삭제 */
    @Override
    @Transactional
    public void deleteAllTestcase(int projectId) {
        commandTestcaseRepository.deleteAllByProjectId(projectId);
    }
}
