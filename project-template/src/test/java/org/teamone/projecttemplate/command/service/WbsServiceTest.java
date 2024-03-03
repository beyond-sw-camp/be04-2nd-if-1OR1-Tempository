package org.teamone.projecttemplate.command.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.command.entity.Wbs;
import org.teamone.projecttemplate.command.repository.WbsRepository;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
public class WbsServiceTest {

    @Autowired
    WbsRepository wbsRepository;

    @DisplayName("WBS 입력하기")
    @Test
    void registWbs() {
//        wbsRepository.save(new Wbs(8, 8, "wbs insert 테스트", "COMPLETED", '2024/03/04', 2024/03/04, 5, 1));
    }

}
