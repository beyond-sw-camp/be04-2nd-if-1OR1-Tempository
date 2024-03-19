package org.teamone.projecttemplate.query.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.client.ProjectTemplateServiceClient;
import org.teamone.projecttemplate.query.dto.WbsDTO;
import org.teamone.projecttemplate.query.dto.WbsUserDTO;
import org.teamone.projecttemplate.query.entity.Wbs;
import org.teamone.projecttemplate.query.repository.WbsMapper;
import org.teamone.projecttemplate.query.vo.UserResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WbsService {

    @Autowired
    private final WbsMapper wbsMapper;

    private final ModelMapper modelMapper;

    private final ProjectTemplateServiceClient projectTemplateServiceClient;

    @Autowired
    public WbsService(WbsMapper wbsMapper, ModelMapper modelMapper, ProjectTemplateServiceClient projectTemplateServiceClient) {

        this.wbsMapper = wbsMapper;
        this.modelMapper = modelMapper;
        this.projectTemplateServiceClient = projectTemplateServiceClient;
    }

    /* 설명. project ID를 이용하여 해당하는 WBS 전체 조회 */
    public List<Wbs> findAllWbsByProjectId(int projectId) {

        List<Wbs> wbsList = wbsMapper.selectAllWbsByProjectId(projectId);
        return wbsList;
    }

    /* 설명. manager ID - 담당자 ID를 이용하여 작성한 wbs 조회 */
    public List<Wbs> findWbsByManagerId(int managerId) {

        List<Wbs> wbsList = wbsMapper.selectWbsByManagerId(managerId);
        return wbsList;
    }

    /* 설명. project ID와 담당자 ID에 해당하는 WBS 조회 */
    public List<Wbs> findWbsByProjectIdAndManagerId(int projectId, int managerId) {

        List<Wbs> wbsList = wbsMapper.selectWbsByProjectIdAndManagerId(projectId, managerId);
        return wbsList;
    }


//    /* project Id로 해당 wbs 모두 조회 */
//    public List<WbsDTO> findWbsByProjectId(String projectId) {
//
//        List<Wbs> result = wbsMapper.selectWbsByProjectId(projectId);
//
//        List<WbsDTO> wbsDTOList = new ArrayList<>();
//        for (Wbs nextWbs : result) {
//            WbsDTO newWbsDTO = modelMapper.map(nextWbs, WbsDTO.class);
//            wbsDTOList.add(newWbsDTO);
//        }
//
//        return wbsDTOList;
//
//    }

//    public WbsUserDTO findWbsByProjectIdAndWbsNo(int projectId, int wbsNo, String token) {
//
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        Map<String, Integer> intMap = new HashMap();
//        intMap.put("projectId", projectId);
//        intMap.put("wbsNo",  wbsNo);
//
//        Wbs wbs = wbsMapper.selectWbsByProjectIdAndWbsNo(intMap);
//        System.out.println("wbs = " + wbs);
//
//        WbsUserDTO wbsUserDTO = modelMapper.map(wbs, WbsUserDTO.class);
//        System.out.println("before wbsUserDTO = " + wbsUserDTO);
//
//        UserResponse userResponse = projectTemplateServiceClient.getUserById(wbs.getManagerId(), token);
//        System.out.println("userResponse = " + userResponse);
//
//        wbsUserDTO.setUserResponse(userResponse);
//        System.out.println("after wbsUserDTO = " + wbsUserDTO);
//
//        return wbsUserDTO;
//    }
}
