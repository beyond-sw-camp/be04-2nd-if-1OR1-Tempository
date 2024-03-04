package org.teamone.projecttemplate.command.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_project_definition_of_table")
public class CommandDefinitionOfTable {
    @Id
    @Column(name = "id")
    private int tableId;
    @Column(name = "definition_no")
    private int definitionNo;
    @Column(name = "name")
    private String tableName;
    @Column(name = "property_name")
    private String propertyName;
    @Column(name = "primary_key")
    private boolean primaryKey;
    @Column(name = "foreign_key")
    private boolean foreignKey;
    @Column(name = "null_able")
    private boolean nullable;
    @Column(name = "column_name")
    private String columnName;
    @Column(name = "default_value")
    private String defaultValue;
    @Column(name = "data_type")
    private String dataType;
    @Column(name = "note")
    private String note;
    @Column(name = "project_id")
    private int projectId;
}

