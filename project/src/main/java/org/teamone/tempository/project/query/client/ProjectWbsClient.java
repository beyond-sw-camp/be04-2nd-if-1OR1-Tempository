package org.teamone.tempository.project.query.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.teamone.tempository.project.query.vo.ResponseUser;
import org.teamone.tempository.project.query.vo.ResponseWbs;

import java.util.List;

@FeignClient(name="wbs", url="localhost:8000")
public interface ProjectWbsClient {
    @GetMapping("/find/{projectId}")
    List<ResponseWbs> findWbsList(@PathVariable("projectId") String projectId
            , @RequestHeader("Authorization") String token);
}
