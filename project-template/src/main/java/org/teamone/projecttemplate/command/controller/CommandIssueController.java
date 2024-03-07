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
import org.teamone.projecttemplate.command.vo.IssueRequest;
import org.teamone.projecttemplate.command.vo.IssueResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/issue")
public class CommandIssueController {
    private ModelMapper modelMapper;
    private CommandIssueService commandIssueService;

    @Autowired
    public CommandIssueController(ModelMapper modelMapper,
                                  CommandIssueService commandIssueService) {
        this.modelMapper = modelMapper;
        this.commandIssueService = commandIssueService;
    }

    /* 설명. Insert, Update 이슈 */
    @PostMapping("regist_and_modify")
    public ResponseEntity<IssueResponse> registIssue(@RequestBody IssueRequest issueRequest){
        CommandIssueDTO commandIssueDTO = modelMapper.map(issueRequest, CommandIssueDTO.class);

        commandIssueService.registIssue(commandIssueDTO);
        IssueResponse issueResponse = modelMapper.map(commandIssueDTO, IssueResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(issueResponse);
    }

    /* 설명. 프로젝트 ID를 통한 상태 일괄 처리 */
    /* Closed */
    @PutMapping("/modify/status/closed/{projectId}")
    public ResponseEntity<List<IssueResponse>> modifyAllStatusToClosedByProjectId(@PathVariable("projectId") int projectId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandIssue> modifyCommandIssueList = commandIssueService.modifyAllStatusToClosedByProjectId(projectId);

        List<IssueResponse> issueResponses = modifyCommandIssueList.stream()
                .map(dot -> modelMapper.map(dot, IssueResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(issueResponses);
    }

    /* Open */
    @PutMapping("/modify/status/reopen/{projectId}")
    public ResponseEntity<List<IssueResponse>> modifyAllStatusToReopenByProjectId(@PathVariable("projectId") int projectId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<CommandIssue> modifyCommandIssueList = commandIssueService.modifyAllStatusToReopenByProjectId(projectId);

        List<IssueResponse> issueResponses = modifyCommandIssueList.stream()
                .map(dot -> modelMapper.map(dot, IssueResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(issueResponses);
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
