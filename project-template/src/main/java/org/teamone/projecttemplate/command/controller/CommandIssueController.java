package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandIssueDTO;
import org.teamone.projecttemplate.command.entity.CommandIssue;
import org.teamone.projecttemplate.command.service.CommandIssueService;
import org.teamone.projecttemplate.command.vo.CommandIssueRequest;
import org.teamone.projecttemplate.command.vo.CommandIssueResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/issue")
public class CommandIssueController {
    private final ModelMapper modelMapper;
    private final CommandIssueService commandIssueService;

    @Autowired
    public CommandIssueController(ModelMapper modelMapper,
                                  CommandIssueService commandIssueService) {
        this.modelMapper = modelMapper;
        this.commandIssueService = commandIssueService;
    }

    /* 설명. Insert, Update 이슈 */
    @PostMapping("regist-and-modify")
    public ResponseEntity<CommandIssueResponse> registIssue(@RequestBody CommandIssueRequest issueRequest){
        CommandIssueDTO commandIssueDTO = modelMapper.map(issueRequest, CommandIssueDTO.class);

        commandIssueService.registIssue(commandIssueDTO);
        CommandIssueResponse commandIssueResponse = modelMapper.map(commandIssueDTO, CommandIssueResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(commandIssueResponse);
    }

    /* 설명. 프로젝트 ID를 통한 상태 일괄 처리 */
    /* Closed */
    @PutMapping("/modify/status/closed/{projectId}")
    public ResponseEntity<List<CommandIssueResponse>> modifyAllStatusToClosedByProjectId(@PathVariable("projectId") int projectId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandIssue> modifyCommandIssueList = commandIssueService.modifyAllStatusToClosedByProjectId(projectId);

        List<CommandIssueResponse> commandIssueRespons = modifyCommandIssueList.stream()
                .map(dot -> modelMapper.map(dot, CommandIssueResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(commandIssueRespons);
    }

    /* Open */
    @PutMapping("/modify/status/reopen/{projectId}")
    public ResponseEntity<List<CommandIssueResponse>> modifyAllStatusToReopenByProjectId(@PathVariable("projectId") int projectId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandIssue> modifyCommandIssueList = commandIssueService.modifyAllStatusToReopenByProjectId(projectId);

        List<CommandIssueResponse> commandIssueRespons = modifyCommandIssueList.stream()
                .map(dot -> modelMapper.map(dot, CommandIssueResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(commandIssueRespons);
    }


    /* 설명. 프로젝트 ID를 통한 Delete 이슈 */
    @DeleteMapping("/remove/{projectId}")
    public ResponseEntity<Void> removeAllIssueByProjectId(@PathVariable("projectId") int projectId) {
        commandIssueService.removeAllIssueByProjectId(projectId);
        return ResponseEntity.ok().build();
    }



    /* 설명. 프로젝트 ID와 이슈 No를 통한 Delete 이슈 */
    @DeleteMapping("/remove/{projectId}/{issueNo}")
    public ResponseEntity<Void> removeIssueByIssueNo(@PathVariable("projectId") int projectId,
                                                     @PathVariable("issueNo") int issueNo) {
        commandIssueService.removeIssueByIssueNo(projectId, issueNo);
        return ResponseEntity.ok().build();
    }

}
