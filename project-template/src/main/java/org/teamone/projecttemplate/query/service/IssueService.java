package org.teamone.projecttemplate.query.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.dto.IssueDTO;
import org.teamone.projecttemplate.query.entity.Issue;
import org.teamone.projecttemplate.query.repository.IssueMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    @Autowired
    private final IssueMapper issueMapper;
    private final ModelMapper  modelMapper;

    @Autowired
    public IssueService(IssueMapper issueMapper, ModelMapper  modelMapper) {
        this.issueMapper = issueMapper;
        this.modelMapper = modelMapper;
    }

    /* 설명. Project ID로 해당 이슈 모두 조회 */
//    public List<Issue> selectIssueByProjectId(IssueDTO issueDTO) {
//        Issue issue = new Issue(issueDTO.getProjectId());
//        List<Issue> result = issueMapper.selectIssueByProjectId(issue);
//        return result;
//    }

    /* 설명. Project ID로 해당 이슈 모두 조회 */
    public List<IssueDTO> selectIssueByProjectId(int projectId) {

        List<Issue> result = issueMapper.selectIssueByProjectId(projectId);

        List<IssueDTO> issueDTOList = new ArrayList<>();
        for (Issue nextissue: result) {
            IssueDTO newIssueDTO = modelMapper.map(nextissue, IssueDTO.class);
            issueDTOList.add(newIssueDTO);
        }

        return issueDTOList;
    }

    public List<Issue> selectIssueByStatus(IssueDTO issueDTO) {
        Issue issue = new Issue(issueDTO.getIssueStatus());
        List<Issue> result = issueMapper.selectIssueByStatus(issue);
        return result;
    }
}
