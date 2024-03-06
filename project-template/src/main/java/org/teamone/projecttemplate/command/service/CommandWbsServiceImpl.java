package org.teamone.projecttemplate.command.service;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;
import org.teamone.projecttemplate.command.repository.CommandWbsRepository;

import java.util.List;

@Service
public class CommandWbsServiceImpl implements CommandWbsService{

    private final ModelMapper modelMapper;

    private final CommandWbsRepository commandWbsRepository;

    @Autowired
    public CommandWbsServiceImpl(ModelMapper modelMapper, CommandWbsRepository commandWbsRepository) {
        this.modelMapper = modelMapper;
        this.commandWbsRepository = commandWbsRepository;
    }

    @Override
    @Transactional
    public void registWbs(CommandWbsDTO newWbs) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandWbs> wbsList = commandWbsRepository.findByProjectId(newWbs.getProjectId());
        int maxNo = wbsList.size();
        newWbs.setWbsNo(maxNo + 1);

        commandWbsRepository.save(modelMapper.map(newWbs, CommandWbs.class));

    }

    @Override
    @Transactional
    public void modifyWbs(CommandWbsDTO updatedWbsDTO) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

//        CommandWbs wbs = commandWbsRepository.findById()

        // projectId와 wbsNo를 사용해서 해당하는 wbs 엔티티 찾기
        CommandWbs existingWbs = commandWbsRepository.findByProjectIdAndWbsNo(updatedWbsDTO.getProjectId(), updatedWbsDTO.getWbsNo());

        if (existingWbs != null) {

            // 해당하는 wbs 엔티티가 존재하면 wbsDTO의 정보를 existingWbs에 업데이트
            existingWbs.setContent(updatedWbsDTO.getContent());
            existingWbs.setTaskStatus(updatedWbsDTO.getTaskStatus());
            existingWbs.setStartDate(updatedWbsDTO.getStartDate());
            existingWbs.setEndDate(updatedWbsDTO.getEndDate());
            existingWbs.setManagerId(updatedWbsDTO.getManagerId());

            // 변경된 엔티티 저장
            commandWbsRepository.save(existingWbs);
        } else {
            throw new EntityNotFoundException("해당 project id와 wbs no에 대한 wbs 없음");
        }

    }

    @Override
    @Transactional
    public void deleteWbs(int projectId, int wbsNo) {

        commandWbsRepository.deleteByProjectIdAndWbsNo(projectId, wbsNo);
    }


}
