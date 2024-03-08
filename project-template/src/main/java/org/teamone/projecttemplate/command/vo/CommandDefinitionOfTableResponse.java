package org.teamone.projecttemplate.command.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommandDefinitionOfTableResponse {
    private int definitionNo;
    private String tableName;
    private String propertyName;
    private boolean primaryKey;
    private boolean foreignKey;
    private boolean nullAble;
    private String columnName;
    private String defaultValue;
    private String dataType;
    private String note;
    private int projectId;
}
