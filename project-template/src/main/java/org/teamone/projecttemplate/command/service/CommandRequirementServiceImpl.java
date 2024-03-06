package org.teamone.projecttemplate.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.command.entity.CommandRequirement;
import org.teamone.projecttemplate.command.repository.CommandRequirementRepository;

import java.util.List;

@Service
public class CommandRequirementServiceImpl implements CommandRequirementService{

    private CommandRequirementRepository commandRequirementRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommandRequirementServiceImpl(CommandRequirementRepository commandRequirementRepository, ModelMapper modelMapper) {
        this.commandRequirementRepository = commandRequirementRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. 요구사항 명세서 추가(RequirementNo 자동 추가) */
    @Override
    @Transactional
    public void registRequirement(CommandRequirementDTO commandRequirementDTO) {
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
        CommandRequirement commandRequirement = modelMapper.map(commandRequirementDTO, CommandRequirement.class);

        commandRequirementRepository.save(commandRequirement);
    }

    /* 설명. 요구사항 명세서 순서 수정(한칸) */
    @Override
    @Transactional
    public void modifySequenceRequirement(int id, int num) {
        CommandRequirement commandRequirement = commandRequirementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("변경할 요구사항이 존재하지 않습니다."));
        System.out.println("commandRequirement = " + commandRequirement);

        CommandRequirement sequenceRequirement = commandRequirementRepository
                .findByProjectIdAndRequirementNo(
                        commandRequirement.getProjectId(),
                        commandRequirement.getRequirementNo() + num
                );
        System.out.println("sequenceRequirement = " + sequenceRequirement);

        if (sequenceRequirement == null)
            throw new IllegalArgumentException("요구 사항 순서 변경 없음");

        commandRequirement.setRequirementNo(commandRequirement.getRequirementNo() + num);
        sequenceRequirement.setRequirementNo(sequenceRequirement.getRequirementNo() - num);
    }
}
