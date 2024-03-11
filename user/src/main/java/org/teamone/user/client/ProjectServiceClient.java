package org.teamone.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.teamone.user.query.domainData.vo.ResponseProjectVO;

import java.util.List;

@FeignClient(name = "project", url = "localhost:8000")
public interface ProjectServiceClient {

    @GetMapping("/project/findProjectMember/{id}")
    List<ResponseProjectVO> getUserProjects(@PathVariable("id") String id, @RequestHeader("Authorization") String token);
}
