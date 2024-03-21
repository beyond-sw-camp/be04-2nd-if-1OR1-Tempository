package org.teamone.tempository.project.query.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="DefinitionOfTable", url="localhost:8000")
public interface ProjectDefinitionOfTableClient {
}
