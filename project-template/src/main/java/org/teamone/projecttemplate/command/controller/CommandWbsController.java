package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;
import org.teamone.projecttemplate.command.service.CommandWbsService;
import org.teamone.projecttemplate.command.vo.CommandWbsRequest;
import org.teamone.projecttemplate.command.vo.CommandWbsResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wbs")
public class CommandWbsController {

    private final CommandWbsService commandWbsService;

    private final ModelMapper modelMapper;


    @Autowired
    public CommandWbsController(CommandWbsService commandWbsService, ModelMapper modelMapper) {
        this.commandWbsService = commandWbsService;
        this.modelMapper = modelMapper;
    }


    /* add */
    /* WBS 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
    @PostMapping("/add")
    public ResponseEntity<CommandWbsResponse> addWbs(@RequestBody CommandWbsRequest wbs) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CommandWbsDTO commandWbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);
        commandWbsService.addWbs(commandWbsDTO);
        CommandWbsResponse commandWbsResponse = modelMapper.map(commandWbsDTO, CommandWbsResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(commandWbsResponse);
    }


    /* modify */
    /* WBS 수정 */
    @PutMapping("/modify")
    public ResponseEntity<CommandWbsResponse> modifyWbs(@RequestBody CommandWbsRequest commandWbsRequest) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CommandWbsDTO commandWbsDTO = modelMapper.map(commandWbsRequest, CommandWbsDTO.class);

        commandWbsService.modifyWbs(commandWbsDTO);

        CommandWbsResponse commandWbsResponse = modelMapper.map(commandWbsDTO, CommandWbsResponse.class);

        return ResponseEntity.ok().body(commandWbsResponse);

    }


    /* 프로젝트 ID로 wbs 전체 status = completed 상태로 바꾸기(프로젝트 마무리되었을 경우) */
    @PutMapping("/modify/status/completed/{projectId}")
    public ResponseEntity<List<CommandWbsResponse>> modifyAllWbsStatusToCompleted(@PathVariable("projectId") int projectId) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CommandWbs> modifiedCommandWbsList = commandWbsService.modifyAllWbsStatusToCompleted(projectId);
        List<CommandWbsResponse> commandWbsResponse = modifiedCommandWbsList.stream()
                .map(wbs -> modelMapper.map(wbs, CommandWbsResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(commandWbsResponse);

    }


    /* remove */
    /* 프로젝트 ID, WBS NO에 해당하는 WBS 하나 삭제(wbs no 자동 업데이트 기능 추가) */
    @DeleteMapping("/remove/{projectId}/{wbsNo}")
    public ResponseEntity<CommandWbsResponse> removeWbs(@PathVariable("projectId") int projectId,
                                                        @PathVariable("wbsNo") int wbsNo) {

        CommandWbsDTO removedCommandWbsDTO = commandWbsService.removeWbs(projectId, wbsNo);
        CommandWbsResponse removedCommandWbsResponse = modelMapper.map(removedCommandWbsDTO, CommandWbsResponse.class);
        return ResponseEntity.ok().body(removedCommandWbsResponse);
    }


    /* 프로젝트 ID에 해당하는 WBS 전체 삭제 */
    @DeleteMapping("/remove/{projectId}")
    public ResponseEntity<Void> removeAllWbsByProjectId(@PathVariable("projectId") int projectId) {

        commandWbsService.removeAllWbsByProjectId(projectId);
        return ResponseEntity.ok().build();
    }




    // 테스트코드 때 사용할 조회 메소드
    @GetMapping("/{projectId}/{wbsNo}")
    public ResponseEntity<CommandWbsResponse> findWbsByProjectIdAndWbsNo(@PathVariable("projectId") int projectId,
                                                                        @PathVariable("wbsNo") int wbsNo) {
        CommandWbsDTO commandWbsDTO = commandWbsService.findWbsByProjectIdAndWbsNo(projectId, wbsNo);
        if (commandWbsDTO != null) {
            CommandWbsResponse commandWbsResponse = modelMapper.map(commandWbsDTO, CommandWbsResponse.class);
            return ResponseEntity.ok().body(commandWbsResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<CommandWbsResponse>> findAllWbsByProjectId(@PathVariable("projectId") int projectId) {
        List<CommandWbsDTO> wbsDTOList = commandWbsService.findAllWbsByProjectId(projectId);

        if (!wbsDTOList.isEmpty()) {
            List<CommandWbsResponse> wbsResponseList = wbsDTOList.stream()
                    .map(wbsDTO -> modelMapper.map(wbsDTO, CommandWbsResponse.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(wbsResponseList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





    /* Project ID에 해당하는 WBS 하나 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
//    @PostMapping("/{projectId}")
//    public ResponseEntity<CommandWbsResponse> addWbsByProjectId(@PathVariable("projectId") int projectId,
//                                                                   @RequestBody CommandWbsRequest wbs) {
//
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        CommandWbsDTO commandWbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);
//        commandWbsDTO.setProjectId(projectId);
//        CommandWbsDTO createdCommandWbsDTO = commandWbsService.addWbsByProjectId(commandWbsDTO);
//        CommandWbsResponse commandWbsResponse = modelMapper.map(createdCommandWbsDTO, CommandWbsResponse.class);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(commandWbsResponse);
//
//    }


    /* Project ID에 해당하는 WBS 일괄 추가(같은 프로젝트의 마지막 WBS 이후로 WBS NO 설정됨) */
//    @PostMapping("/add-many/{projectId}")
//    public ResponseEntity<Void> addManyWbsByProjectId(@PathVariable("projectId") int projectId,
//                                                     @RequestBody List<CommandWbsRequest> wbs) {
//
//        commandWbsService.addManyWbsByProjectId(projectId, wbs);
//
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }


    /* Project Id, Wbs No에 해당하는 WBS 하나 수정 */
    //    @PutMapping("/{projectId}/{wbsNo}")
//    public ResponseEntity<CommandWbsResponse> modifyWbs(@PathVariable("projectId") int projectId,
//                                                        @PathVariable("wbsNo") int wbsNo,
//                                                        @RequestBody CommandWbsRequest wbs) {
//
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        CommandWbsDTO commandWbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);
//        commandWbsDTO.setProjectId(projectId);
//        commandWbsDTO.setWbsNo(wbsNo);
//        commandWbsService.modifyWbs(commandWbsDTO);
//        CommandWbsResponse commandWbsResponse = modelMapper.map(commandWbsDTO, CommandWbsResponse.class);
//
//        return ResponseEntity.ok().body(commandWbsResponse);
//
//    }
//

    //    /* 프로젝트 ID와 WBS NO에 해당하는 WBS content만 수정 */
//    @PutMapping("/modify-content/{projectId}/{wbsNo}")
//    public ResponseEntity<Void> modifyWbsContentByProjectIdAndWbsNo(@PathVariable("projectId") int projectId,
//                                                                    @PathVariable("wbsNo") int wbsNo,
//                                                                    @RequestBody String content) {
//
//        commandWbsService.modifyWbsContentByProjectIdAndWbsNo(projectId, wbsNo, content);
//
//        return ResponseEntity.ok().build();
//    }

}
