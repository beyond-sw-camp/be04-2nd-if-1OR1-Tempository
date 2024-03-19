package org.teamone.projecttemplate.query.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.client.ProjectTemplateServiceClient;
import org.teamone.projecttemplate.query.dto.IssueDTO;
import org.teamone.projecttemplate.query.dto.IssueUserDTO;
import org.teamone.projecttemplate.query.entity.Issue;
import org.teamone.projecttemplate.query.repository.IssueMapper;
import org.teamone.projecttemplate.query.vo.UserResponse;

import java.util.*;

@Service
public class IssueService {

    @Autowired
    private final IssueMapper issueMapper;
    private final ModelMapper  modelMapper;

    /* 설명. FeignClient 이후 추가할 부분 */
    private ProjectTemplateServiceClient projectTemplateServiceClient;

    @Autowired
    public IssueService(IssueMapper issueMapper, ModelMapper  modelMapper, ProjectTemplateServiceClient projectTemplateServiceClient) {
        this.issueMapper = issueMapper;
        this.modelMapper = modelMapper;
        this.projectTemplateServiceClient = projectTemplateServiceClient;
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

    public IssueUserDTO findIssueByProjectIdAndIssueNo(int projectId, int issueNo, String token) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Map<String, Integer> intMap = new HashMap();
        intMap.put("projectId", projectId);
        intMap.put("issueNo",  issueNo);

        Issue issue = issueMapper.selectIssueByProjectIdAndIssueNo(intMap);

        IssueUserDTO issueUserDTO = modelMapper.map(issue, IssueUserDTO.class);

        UserResponse userResponse = projectTemplateServiceClient.getUserById(issue.getManagerId(), token);

        issueUserDTO.setUserResponse(userResponse);

        return issueUserDTO;
    }

}
