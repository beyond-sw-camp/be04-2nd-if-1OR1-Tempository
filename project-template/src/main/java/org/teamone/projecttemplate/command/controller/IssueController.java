package org.teamone.projecttemplate.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.projecttemplate.command.dto.CommandIssueDTO;
import org.teamone.projecttemplate.command.service.CommandIssueService;
import org.teamone.projecttemplate.command.vo.IssueRequest;
import org.teamone.projecttemplate.command.vo.IssueResponse;

@RestController
@RequestMapping("/issue")
public class IssueController {
    private Environment env;
    private ModelMapper modelMapper;
    private CommandIssueService commandIssueService;

    @Autowired
    public IssueController(Environment env, ModelMapper modelMapper, CommandIssueService commandIssueService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.commandIssueService = commandIssueService;
    }

    /* 설명. ID를 통한 Insert, Update 이슈 */
    @PostMapping("regist_and_modify")
    public ResponseEntity<IssueResponse> registIssue(@RequestBody IssueRequest issueRequest){
        CommandIssueDTO issueDTO = modelMapper.map(issueRequest, CommandIssueDTO.class);

        commandIssueService.registIssue(issueDTO);
        IssueResponse issueResponse = modelMapper.map(issueDTO, IssueResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(issueResponse);
    }


    /* 설명. 프로젝트 ID에 따른 해당 이슈 일괄 삭제 */

    /* 설명. 이슈 ID에 따른 해당 이슈 삭제 */

}
