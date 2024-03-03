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


}
