package org.teamone.projecttemplate.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.entity.Wbs;
import org.teamone.projecttemplate.query.repository.WbsMapper;

import java.util.List;

@Service
public class WbsService {

    @Autowired
    private final WbsMapper wbsMapper;

    @Autowired
    public WbsService(WbsMapper wbsMapper) {
        this.wbsMapper = wbsMapper;
    }

    /* 설명. project ID를 이용하여 해당하는 WBS 전체 조회 */
    public List<Wbs> selectAllWbsByProjectId(int projectId) {

        List<Wbs> wbsList = wbsMapper.selectAllWbsByProjectId(projectId);
        wbsList.forEach(System.out::println);

        return wbsList;
    }

    /* 설명. manager ID - 담당자 ID를 이용하여 작성한 wbs 조회 */
    public List<Wbs> selectWbsByManagerId(int managerId) {

        List<Wbs> wbsList = wbsMapper.selectWbsByManagerId(managerId);
        wbsList.forEach(System.out::println);

        return wbsList;
    }

    /* 설명. project ID와 담당자 ID에 해당하는 WBS 조회 */
    public List<Wbs> selectWbsByProjectIdAndManagerId(int projectId, int managerId) {

        List<Wbs> wbsList = wbsMapper.selectWbsByProjectIdAndManagerId(projectId, managerId);
        wbsList.forEach(System.out::println);

        return wbsList;
    }


}
