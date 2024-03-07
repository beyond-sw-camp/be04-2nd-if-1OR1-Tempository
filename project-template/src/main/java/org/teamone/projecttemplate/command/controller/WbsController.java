package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;
import org.teamone.projecttemplate.command.service.CommandWbsService;
import org.teamone.projecttemplate.command.vo.WbsRequest;
import org.teamone.projecttemplate.command.vo.WbsResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wbs")
public class WbsController {

    private final CommandWbsService commandWbsService;

    private final ModelMapper modelMapper;

    @Autowired
    public WbsController(CommandWbsService commandWbsService, Environment env, ModelMapper modelMapper) {
        this.commandWbsService = commandWbsService;
        this.modelMapper = modelMapper;
    }

    /* insert */
    /* WBS 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
    @PostMapping("/insert")
    public ResponseEntity<WbsResponse> insertWbs(@RequestBody WbsRequest wbs) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandWbsDTO wbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);
        commandWbsService.insertWbs(wbsDTO);
        WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(wbsResponse);
    }

    /* Project ID에 해당하는 WBS 하나 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
    @PostMapping("/insert/{projectId}")
    public ResponseEntity<WbsResponse> insertWbsByProjectId(@PathVariable("projectId") int projectId,
                                                            @RequestBody WbsRequest wbs) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandWbsDTO wbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);
        wbsDTO.setProjectId(projectId);
        CommandWbsDTO createdWbsDTO = commandWbsService.insertWbsByProjectId(wbsDTO);
        WbsResponse wbsResponse = modelMapper.map(createdWbsDTO, WbsResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(wbsResponse);

    }

    /* Project ID에 해당하는 WBS 일괄 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
    @PostMapping("/insert-many/{projectId}")
    public ResponseEntity<Void> insertManyWbsByProjectId(@PathVariable("projectId") int projectId,
                                                     @RequestBody List<WbsRequest> wbs) {

        commandWbsService.insertManyWbsByProjectId(projectId, wbs);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /* modify */
    /* Project ID, Wbs No에 해당하는 WBS 수정 */
    @PutMapping("/modify/{projectId}/{wbsNo}")
    public ResponseEntity<WbsResponse> modifyWbs(@PathVariable("projectId") int projectId,
                                                 @PathVariable("wbsNo") int wbsNo,
                                                 @RequestBody WbsRequest wbs) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandWbsDTO wbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);
        wbsDTO.setProjectId(projectId);
        wbsDTO.setWbsNo(wbsNo);
        commandWbsService.modifyWbs(wbsDTO);
        WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);

        return ResponseEntity.ok().body(wbsResponse);

    }

    /* 프로젝트 ID로 wbs 전체 status = completed 상태로 바꾸기(프로젝트 마무리되었을 경우) */
    @PutMapping("/modify/completed/{projectId}")
    public ResponseEntity<List<WbsResponse>> modifyAllWbsStatusToCompleted(@PathVariable("projectId") int projectId) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CommandWbs> modifiedWbsList = commandWbsService.modifyAllWbsStatusToCompleted(projectId);
        List<WbsResponse> wbsResponse = modifiedWbsList.stream()
                .map(wbs -> modelMapper.map(wbs, WbsResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(wbsResponse);

    }

    /* 프로젝트 ID와 WBS NO에 해당하는 WBS content만 수정 */
    @PutMapping("/modify/content/{projectId}/{wbsNo}")
    public ResponseEntity<Void> modifyWbsContentByProjectIdAndWbsNo(@PathVariable("projectId") int projectId,
                                                                    @PathVariable("wbsNo") int wbsNo,
                                                                    @RequestBody String content) {

        commandWbsService.modifyWbsContentByProjectIdAndWbsNo(projectId, wbsNo, content);

        return ResponseEntity.ok().build();
    }


    /* delete */
    /* 프로젝트 ID, WBS NO에 해당하는 WBS 하나 삭제(wbs no 자동 업데이트 기능 추가) */
    @DeleteMapping("/delete/{projectId}/{wbsNo}")
    public ResponseEntity<WbsResponse> deleteWbs(@PathVariable("projectId") int projectId,
                                          @PathVariable("wbsNo") int wbsNo) {

        CommandWbsDTO deletedWbsDTO = commandWbsService.deleteWbs(projectId, wbsNo);
        WbsResponse deletedWbsResponse = modelMapper.map(deletedWbsDTO, WbsResponse.class);
        return ResponseEntity.ok().body(deletedWbsResponse);
    }

    /* 프로젝트 ID에 해당하는 WBS 전체 삭제 */
    @DeleteMapping("delete/{projectId}")
    public ResponseEntity<Void> deleteAllWbsByProjectId(@PathVariable("projectId") int projectId) {

        commandWbsService.deleteAllWbsByProjectId(projectId);
        return ResponseEntity.ok().build();
    }


}
