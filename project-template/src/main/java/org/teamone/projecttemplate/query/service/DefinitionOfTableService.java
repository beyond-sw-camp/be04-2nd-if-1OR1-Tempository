package org.teamone.projecttemplate.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.dto.DefinitionOfTableDTO;
import org.teamone.projecttemplate.query.entity.DefinitionOfTable;
import org.teamone.projecttemplate.query.repository.DefinitionOfTableMapper;

import java.util.List;


@Service
public class DefinitionOfTableService {
    @Autowired
    private final DefinitionOfTableMapper definitionOfTableMapper;

    @Autowired
    public DefinitionOfTableService(DefinitionOfTableMapper definitionOfTableMapper) {
        this.definitionOfTableMapper = definitionOfTableMapper;
    }

    /* 설명. Project ID로 해당 테이블 정의서 모두 조회 */
    public List<DefinitionOfTable> selectAllDefinitionOfTables(DefinitionOfTableDTO definitionDTO) {

        DefinitionOfTable definitionOfTable = new DefinitionOfTable(definitionDTO.getProjectId());
        List<DefinitionOfTable> result = definitionOfTableMapper.selectAllDefinitionOfTables(definitionOfTable);

        return result;
    }

    /* 설명. Table Name 으로 해당 테이블 정의서 모두 조회 */
    public List<DefinitionOfTable> selectTableByName(DefinitionOfTableDTO definitionDTO) {
        DefinitionOfTable definitionOfTable = new DefinitionOfTable(definitionDTO.getTableName());
        List<DefinitionOfTable> result = definitionOfTableMapper.selectDefinitionOfTableByName(definitionOfTable);

        return result;
    }
}
