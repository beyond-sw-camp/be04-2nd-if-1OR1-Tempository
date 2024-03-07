package org.teamone.tempository.project.query.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProjectDefinitionOfTable {
    private int id;

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
