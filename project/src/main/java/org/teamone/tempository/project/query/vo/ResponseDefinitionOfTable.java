package org.teamone.tempository.project.query.vo;

import lombok.Data;

@Data
public class ResponseDefinitionOfTable {
    private int tableId;
    private int definitionNo;
    private String tableName;
    private String propertyName;
    private boolean primaryKey;
    private boolean foreignKey;
    private boolean nullable;
    private String columnName;
    private String defaultValue;
    private String dataType;
    private String note;
    private int projectId;
}
