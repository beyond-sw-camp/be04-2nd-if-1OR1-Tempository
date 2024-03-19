package org.teamone.projecttemplate.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.query.dto.WbsDTO;
import org.teamone.projecttemplate.query.entity.Wbs;

import java.util.List;

@SpringBootTest
public class WbsServiceTest {

    @Autowired
    private WbsService wbsService;

    @DisplayName("프로젝트 ID로 해당하는 WBS 전체 조회")
    @Test
    void findAllWbsByProjectId() {
        List<WbsDTO> wbsList = wbsService.findAllWbsByProjectId(1);
        Assertions.assertNotNull(wbsList);
    }

    @DisplayName("담당자 ID를 이용하여 작성한 wbs 조회")
    @Test
    void findWbsByManagerId() {
        List<WbsDTO> wbsList = wbsService.findWbsByManagerId(1);

        Assertions.assertNotNull(wbsList);
    }

    @DisplayName("프로젝트 ID와 담당자 ID를 이용하여 해당하는 WBS 조회")
    @Test
    void findWbsByProjectIdAndManagerId() {
        WbsDTO wbsDTO = new WbsDTO(1, 1);

        List<WbsDTO> wbsDTOList = wbsService.findWbsByProjectIdAndManagerId(wbsDTO);

        Assertions.assertNotNull(wbsDTOList);
    }

    @DisplayName("프로젝트 ID와 WBS NO를 이용하여 해당하는 WBS 조회")
    @Test
    void findWbsByProjectIdAndWbsNo() {
        WbsDTO wbsDTO = wbsService.findWbsByProjectIdAndWbsNo(1, 1);

        Assertions.assertNotNull(wbsDTO);
    }

}
