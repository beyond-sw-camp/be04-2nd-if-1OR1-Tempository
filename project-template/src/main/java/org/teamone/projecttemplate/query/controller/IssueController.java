package org.teamone.projecttemplate.query.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.query.dto.IssueDTO;
import org.teamone.projecttemplate.query.dto.IssueUserDTO;
import org.teamone.projecttemplate.query.service.IssueService;
import org.teamone.projecttemplate.query.vo.IssueResponse;
import org.teamone.projecttemplate.query.vo.IssueUserResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {
    private final IssueService issueService;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueController(IssueService issueService, ModelMapper modelMapper) {
        this.issueService = issueService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<IssueResponse>> findIssueByProjectId(@PathVariable("projectId") int projectId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<IssueDTO> issueDTOList = issueService.selectIssueByProjectId(projectId);

        List<IssueResponse> issueResponseList = new ArrayList<>();
        for (IssueDTO issue: issueDTOList) {
            IssueResponse issueResponse = modelMapper.map(issue, IssueResponse.class);
            issueResponseList.add(issueResponse);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(issueResponseList);
    }

    @GetMapping("/{projectId}/{issueNo}")
    public ResponseEntity<IssueUserResponse> findIssueByProjectIdAndIssueNo(@PathVariable("projectId") int projectId,
                                                                            @PathVariable("issueNo") int issue,
                                                                            @RequestHeader("Authorization") String token) {

        IssueUserDTO issueUserDTO = issueService.selectIssueByProjectIdAndIssueNo(projectId, issue, token);

        IssueUserResponse issueUserResponse = modelMapper.map(issueUserDTO, IssueUserResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(issueUserResponse);
    }
}
