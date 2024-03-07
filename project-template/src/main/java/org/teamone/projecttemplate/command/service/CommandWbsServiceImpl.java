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
import org.teamone.projecttemplate.command.vo.WbsRequest;

import java.util.ArrayList;
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

    /* insert */
    /* WBS 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
    @Override
    @Transactional
    public void insertWbs(CommandWbsDTO newWbs) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandWbs> wbsList = commandWbsRepository.findByProjectId(newWbs.getProjectId());
        int maxNo = wbsList.size();
        newWbs.setWbsNo(maxNo + 1);

        commandWbsRepository.save(modelMapper.map(newWbs, CommandWbs.class));

    }

    /* Project ID에 해당하는 WBS 하나 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
    @Override
    @Transactional
    public CommandWbsDTO insertWbsByProjectId(CommandWbsDTO newWbs) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandWbs> wbsList = commandWbsRepository.findByProjectId(newWbs.getProjectId());
        int maxNo = wbsList.size();
        newWbs.setWbsNo(maxNo + 1);

        CommandWbs commandWbs = modelMapper.map(newWbs, CommandWbs.class);
        CommandWbs savedEntity = commandWbsRepository.save(commandWbs);

        return modelMapper.map(savedEntity, CommandWbsDTO.class);
    }

    /* Project ID에 해당하는 WBS 일괄 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
    @Override
    @Transactional
    public void insertManyWbsByProjectId(int projectId, List<WbsRequest> wbs) {
        List<CommandWbs> wbsList = new ArrayList<>();

        List<CommandWbs> existingWbsList = commandWbsRepository.findByProjectId(projectId);
        int maxNo = existingWbsList.size();

        for (WbsRequest wbsRequest : wbs) {
            CommandWbs commandWbs = new CommandWbs();
            commandWbs.setProjectId(projectId);
            commandWbs.setContent(wbsRequest.getContent());
            commandWbs.setTaskStatus(wbsRequest.getTaskStatus());
            commandWbs.setStartDate(wbsRequest.getStartDate());
            commandWbs.setEndDate(wbsRequest.getEndDate());
            commandWbs.setManagerId(wbsRequest.getManagerId());

            commandWbs.setWbsNo(++maxNo);

            wbsList.add(commandWbs);
        }

        commandWbsRepository.saveAll(wbsList);

    }


    /* modify */
    /* Project ID, Wbs No에 해당하는 WBS 수정 */
    @Override
    @Transactional
    public void modifyWbs(CommandWbsDTO updatedWbsDTO) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandWbs existingWbs = commandWbsRepository.findByProjectIdAndWbsNo(updatedWbsDTO.getProjectId(), updatedWbsDTO.getWbsNo());

        if (existingWbs != null) {
            existingWbs.setContent(updatedWbsDTO.getContent());
            existingWbs.setTaskStatus(updatedWbsDTO.getTaskStatus());
            existingWbs.setStartDate(updatedWbsDTO.getStartDate());
            existingWbs.setEndDate(updatedWbsDTO.getEndDate());
            existingWbs.setManagerId(updatedWbsDTO.getManagerId());

            commandWbsRepository.save(existingWbs);
        } else {
            throw new EntityNotFoundException("해당 project id와 wbs no에 대한 wbs 없음");
        }
    }

    /* 프로젝트 ID로 wbs 전체 status = completed 상태로 바꾸기(프로젝트 마무리되었을 경우) */
    @Override
    @Transactional
    public List<CommandWbs> modifyAllWbsStatusToCompleted(int projectId) {
        List<CommandWbs> wbsList = commandWbsRepository.findAllByProjectId(projectId);

        for (CommandWbs wbs : wbsList) {
            wbs.setTaskStatus("COMPLETED");
        }

        return commandWbsRepository.saveAll(wbsList);
    }

    /* 프로젝트 ID와 WBS NO에 해당하는 WBS content만 수정 */
    @Override
    @Transactional
    public void modifyWbsContentByProjectIdAndWbsNo(int projectId, int wbsNo, String content) {
        CommandWbs existingWbs = commandWbsRepository.findByProjectIdAndWbsNo(projectId, wbsNo);

        if (existingWbs != null) {
            existingWbs.setContent(content);
            commandWbsRepository.save(existingWbs);
        } else {
            throw new EntityNotFoundException("해당 프로젝트 ID와 WBS NO에 대한 WBS가 존재하지 않음");
        }

    }


    /* delete */
    /* 프로젝트 ID, WBS NO에 해당하는 WBS 하나 삭제(wbs no 자동 업데이트 기능 추가) */
    @Override
    @Transactional
    public CommandWbsDTO deleteWbs(int projectId, int wbsNo) {

        CommandWbs deletedWbs = commandWbsRepository.findByProjectIdAndWbsNo(projectId, wbsNo);
        if (deletedWbs != null) {

            commandWbsRepository.deleteByProjectIdAndWbsNo(projectId, wbsNo);
            List<CommandWbs> wbsList = commandWbsRepository.findByProjectIdAndWbsNoGreaterThan(projectId, wbsNo);

            for (CommandWbs wbs : wbsList) {
                wbs.setWbsNo(wbs.getWbsNo() - 1);
                commandWbsRepository.save(wbs);
            }

            return modelMapper.map(deletedWbs, CommandWbsDTO.class);

        } else {
            throw new EntityNotFoundException("해당 프로젝트 ID와 WBS NO에 대한 WBS가 존재하지 않음");
        }
    }

    /* 프로젝트 ID에 해당하는 WBS 전체 삭제 */
    @Override
    @Transactional
    public void deleteAllWbsByProjectId(int projectId) {
        commandWbsRepository.deleteAllWbsByProjectId(projectId);
    }



}
