package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.DefinitionOfTable;
import java.util.List;

@Mapper
public interface DefinitionOfTableMapper {
    List<DefinitionOfTable> selectAllDefinitionOfTables(DefinitionOfTable definitionOfTable);

    List<DefinitionOfTable> selectDefinitionOfTableByName(DefinitionOfTable definitionOfTable);
}
