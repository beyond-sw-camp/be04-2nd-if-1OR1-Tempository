package org.teamone.projecttemplate.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;
import org.teamone.projecttemplate.command.entity.CommandRequirement;
import org.teamone.projecttemplate.command.repository.CommandRequirementRepository;

import java.util.List;

@Service
public class CommandRequirementServiceImpl implements CommandRequirementService{

    private final CommandRequirementRepository commandRequirementRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommandRequirementServiceImpl(CommandRequirementRepository commandRequirementRepository, ModelMapper modelMapper) {
        this.commandRequirementRepository = commandRequirementRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. 요구사항 명세서 추가(RequirementNo 자동 추가) */
    @Override
    @Transactional
    public void addRequirement(CommandRequirementDTO commandRequirementDTO) {
        List<CommandRequirement> commandRequirementList = commandRequirementRepository.findByProjectId(commandRequirementDTO.getProjectId());

        int maxNo = commandRequirementList.size();
        commandRequirementDTO.setRequirementNo(maxNo + 1);

        CommandRequirement commandRequirement = modelMapper.map(commandRequirementDTO, CommandRequirement.class);

        commandRequirementRepository.save(commandRequirement);
    }

    /* 설명. 요구사항 명세서 수정 */
    @Override
    @Transactional
    public void modifyRequirement(CommandRequirementDTO commandRequirementDTO) {

        CommandRequirement commandRequirement = commandRequirementRepository.findByProjectIdAndRequirementNo(
                commandRequirementDTO.getProjectId(),
                commandRequirementDTO.getRequirementNo()
        );

        commandRequirement.setSeparate(commandRequirementDTO.getSeparate());
        commandRequirement.setName(commandRequirementDTO.getName());
        commandRequirement.setContent(commandRequirementDTO.getContent());
        commandRequirement.setNote(commandRequirementDTO.getNote());

    }

    /* 설명. 요구사항 명세서 순서 수정(한칸) */
    @Override
    @Transactional
    public CommandRequirementDTO modifyRequirementSequence(CommandRequirementDTO commandRequirementDTO, int num) {

        int projectId = commandRequirementDTO.getProjectId();
        int requirementNo = commandRequirementDTO.getRequirementNo();

        /* 설명, 바꿀 요구사항 */
        CommandRequirement commandRequirement = commandRequirementRepository.findByProjectIdAndRequirementNo(
                projectId,
                requirementNo
        );

        /* 설명. 다음 순서의 요구사항 */
        CommandRequirement sequenceRequirement = commandRequirementRepository.findByProjectIdAndRequirementNo(
                projectId,
                requirementNo + num
        );

        if (sequenceRequirement == null)
            throw new IllegalArgumentException("요구 사항 순서 변경 없음");

        commandRequirement.setRequirementNo(commandRequirement.getRequirementNo() + num);
        sequenceRequirement.setRequirementNo(sequenceRequirement.getRequirementNo() - num);

        /* 설명. 변경된 DTO 반환 */
        commandRequirementDTO = modelMapper.map(commandRequirement, CommandRequirementDTO.class);

        return commandRequirementDTO;
    }

    /* 설명. 프로젝트 id와 requirementNo로 요구사항 명세서 삭제  */
    @Override
    @Transactional
    public void removeRequirement(int projectId, int requirementNo) {

        /* 설명. 프로젝트 id와 requirementNo로 요구사항 명세서 삭제  */
        commandRequirementRepository.deleteByProjectIdAndRequirementNo(projectId, requirementNo);

        /* 설명. 해당 요구사항 명세서 다음 순서의 요구사항 명세서들 조회 */
        List<CommandRequirement> commandRequirementList = commandRequirementRepository
                .findByProjectIdAndRequirementNoGreaterThanOrderByRequirementNoAsc(projectId, requirementNo);

        for (CommandRequirement nextRequirement: commandRequirementList){
            nextRequirement.setRequirementNo(nextRequirement.getRequirementNo() -1);
        }
    }

    @Override
    @Transactional
    public void removeAllRequirement(int projectId) {
        commandRequirementRepository.deleteAllByProjectId(projectId);
    }
}
