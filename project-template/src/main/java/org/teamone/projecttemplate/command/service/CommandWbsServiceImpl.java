package org.teamone.projecttemplate.command.service;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;
import org.teamone.projecttemplate.command.repository.CommandWbsRepository;
import org.teamone.projecttemplate.query.client.ProjectTemplateServiceClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandWbsServiceImpl implements CommandWbsService{

    private final ModelMapper modelMapper;

    private final CommandWbsRepository commandWbsRepository;

    private final ProjectTemplateServiceClient projectTemplateServiceClient;

    @Autowired
    public CommandWbsServiceImpl(ModelMapper modelMapper, CommandWbsRepository commandWbsRepository, ProjectTemplateServiceClient projectTemplateServiceClient) {
        this.modelMapper = modelMapper;
        this.commandWbsRepository = commandWbsRepository;
        this.projectTemplateServiceClient = projectTemplateServiceClient;
    }


    /* add */
    /* WBS 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
    @Override
    @Transactional
    public void addWbs(CommandWbsDTO newCommandWbs) {

        newCommandWbs.validate();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandWbs> commandWbsList = commandWbsRepository.findByProjectId(newCommandWbs.getProjectId());
        int maxNo = commandWbsList.size();
        newCommandWbs.setWbsNo(maxNo + 1);

        try {
            commandWbsRepository.save(modelMapper.map(newCommandWbs, CommandWbs.class));
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("부적절한 값으로 인해 WBS를 추가할 수 없습니다.");
        }

    }


    /* modify */
    /* WBS 수정 */
    @Override
    @Transactional
    public void modifyWbs(CommandWbsDTO updatedCommandWbsDTO) {

        updatedCommandWbsDTO.validate();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandWbs existingCommandWbs = commandWbsRepository.findByProjectIdAndWbsNo(updatedCommandWbsDTO.getProjectId(), updatedCommandWbsDTO.getWbsNo());

        if (existingCommandWbs != null) {
            existingCommandWbs.setContent(updatedCommandWbsDTO.getContent());
            existingCommandWbs.setTaskStatus(updatedCommandWbsDTO.getTaskStatus());
            existingCommandWbs.setStartDate(updatedCommandWbsDTO.getStartDate());
            existingCommandWbs.setEndDate(updatedCommandWbsDTO.getEndDate());
            existingCommandWbs.setManagerId(updatedCommandWbsDTO.getManagerId());

            commandWbsRepository.save(existingCommandWbs);
        } else {
            throw new EntityNotFoundException("해당 project id와 wbs no에 대한 wbs 없음");
        }
    }

    /* 프로젝트 ID로 wbs 전체 status = completed 상태로 바꾸기(프로젝트 마무리되었을 경우) */
    @Override
    @Transactional
    public List<CommandWbs> modifyAllWbsStatusToCompleted(int projectId) {
        List<CommandWbs> commandWbsList = commandWbsRepository.findAllByProjectId(projectId);

        if (commandWbsList.isEmpty()) {
            throw new EntityNotFoundException("해당 project id에 대한 wbs 없음");
        }

        for (CommandWbs commandWbs : commandWbsList) {
            commandWbs.setTaskStatus("COMPLETED");
        }

        return commandWbsRepository.saveAll(commandWbsList);
    }


    /* remove */
    /* 프로젝트 ID, WBS NO에 해당하는 WBS 하나 삭제(wbs no 자동 업데이트 기능 추가) */
    @Override
    @Transactional
    public CommandWbsDTO removeWbs(int projectId, int wbsNo) {

        CommandWbs removedCommandWbs = commandWbsRepository.findByProjectIdAndWbsNo(projectId, wbsNo);
        if (removedCommandWbs != null) {

            commandWbsRepository.deleteByProjectIdAndWbsNo(projectId, wbsNo);
            List<CommandWbs> commandWbsList = commandWbsRepository.findByProjectIdAndWbsNoGreaterThan(projectId, wbsNo);

            for (CommandWbs commandWbs : commandWbsList) {
                commandWbs.setWbsNo(commandWbs.getWbsNo() - 1);
                commandWbsRepository.save(commandWbs);
            }

            return modelMapper.map(removedCommandWbs, CommandWbsDTO.class);

        } else {
            throw new EntityNotFoundException("해당 프로젝트 ID와 WBS NO에 대한 WBS가 존재하지 않음");
        }
    }

    /* 프로젝트 ID에 해당하는 WBS 전체 삭제 */
    @Override
    @Transactional
    public void removeAllWbsByProjectId(int projectId) {
        List<CommandWbs> commandWbsList = commandWbsRepository.findAllByProjectId(projectId);
        if (commandWbsList.isEmpty()) {
            throw new EntityNotFoundException("해당 project id에 대한 wbs 없음");
        }
        commandWbsRepository.deleteAllWbsByProjectId(projectId);
    }



    // 테스트코드 때 사용할 조회 메소드
    @Override
    public CommandWbsDTO findWbsByProjectIdAndWbsNo(int projectId, int wbsNo) {
        CommandWbs commandWbs = commandWbsRepository.findByProjectIdAndWbsNo(projectId, wbsNo);
        if (commandWbs != null) {
            return modelMapper.map(commandWbs, CommandWbsDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<CommandWbsDTO> findAllWbsByProjectId(int projectId) {
        List<CommandWbs> commandWbsList = commandWbsRepository.findByProjectId(projectId);
        return commandWbsList.stream()
                .map(wbs -> modelMapper.map(wbs, CommandWbsDTO.class))
                .collect(Collectors.toList());
    }




    //    /* Project ID에 해당하는 WBS 하나 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
//    @Override
//    @Transactional
//    public CommandWbsDTO addWbsByProjectId(CommandWbsDTO newCommandWbs) {
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        List<CommandWbs> commandWbsList = commandWbsRepository.findByProjectId(newCommandWbs.getProjectId());
//        int maxNo = commandWbsList.size();
//        newCommandWbs.setWbsNo(maxNo + 1);
//
//        CommandWbs commandWbs = modelMapper.map(newCommandWbs, CommandWbs.class);
//        CommandWbs savedCommandWbs = commandWbsRepository.save(commandWbs);
//
//        return modelMapper.map(savedCommandWbs, CommandWbsDTO.class);
//    }

//    /* Project ID에 해당하는 WBS 일괄 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
//    @Override
//    @Transactional
//    public void addManyWbsByProjectId(int projectId, List<CommandWbsRequest> wbs) {
//        List<CommandWbs> commandWbsList = new ArrayList<>();
//
//        List<CommandWbs> existingCommandWbsList = commandWbsRepository.findByProjectId(projectId);
//        int maxNo = existingCommandWbsList.size();
//
//        for (CommandWbsRequest commandWbsRequest : wbs) {
//            CommandWbs commandWbs = new CommandWbs();
//            commandWbs.setProjectId(projectId);
//            commandWbs.setContent(commandWbsRequest.getContent());
//            commandWbs.setTaskStatus(commandWbsRequest.getTaskStatus());
//            commandWbs.setStartDate(commandWbsRequest.getStartDate());
//            commandWbs.setEndDate(commandWbsRequest.getEndDate());
//            commandWbs.setManagerId(commandWbsRequest.getManagerId());
//
//            commandWbs.setWbsNo(++maxNo);
//
//            commandWbsList.add(commandWbs);
//        }
//
//        commandWbsRepository.saveAll(commandWbsList);
//
//    }

    //    /* 프로젝트 ID와 WBS NO에 해당하는 WBS content만 수정 */
//    @Override
//    @Transactional
//    public void modifyWbsContentByProjectIdAndWbsNo(int projectId, int wbsNo, String content) {
//        CommandWbs existingCommandWbs = commandWbsRepository.findByProjectIdAndWbsNo(projectId, wbsNo);
//
//        if (existingCommandWbs != null) {
//            existingCommandWbs.setContent(content);
//            commandWbsRepository.save(existingCommandWbs);
//        } else {
//            throw new EntityNotFoundException("해당 프로젝트 ID와 WBS NO에 대한 WBS가 존재하지 않음");
//        }
//
//    }

}
