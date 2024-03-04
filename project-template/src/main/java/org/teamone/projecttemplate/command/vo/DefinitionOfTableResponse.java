package org.teamone.projecttemplate.command.vo;

public class DefinitionOfTableResponse {
    private int id;
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

    public DefinitionOfTableResponse() {
    }

    public DefinitionOfTableResponse(int id, int definitionNo, String tableName, String propertyName, boolean primaryKey, boolean foreignKey, boolean nullAble, String columnName, String defaultValue, String dataType, String note) {
        this.id = id;
        this.definitionNo = definitionNo;
        this.tableName = tableName;
        this.propertyName = propertyName;
        this.primaryKey = primaryKey;
        this.foreignKey = foreignKey;
        this.nullAble = nullAble;
        this.columnName = columnName;
        this.defaultValue = defaultValue;
        this.dataType = dataType;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefinitionNo() {
        return definitionNo;
    }

    public void setDefinitionNo(int definitionNo) {
        this.definitionNo = definitionNo;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(boolean foreignKey) {
        this.foreignKey = foreignKey;
    }

    public boolean isNullAble() {
        return nullAble;
    }

    public void setNullAble(boolean nullAble) {
        this.nullAble = nullAble;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "DefinitionOfTableResponse{" +
                "id=" + id +
                ", definitionNo=" + definitionNo +
                ", tableName='" + tableName + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", primaryKey=" + primaryKey +
                ", foreignKey=" + foreignKey +
                ", nullAble=" + nullAble +
                ", columnName='" + columnName + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", dataType='" + dataType + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
