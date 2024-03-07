package org.teamone.projecttemplate.command.dto;

public class CommandRequirementDTO {

    private int id;
    private int requirementNo;
    private String separate;
    private String name;
    private String content;
    private String note;
    private int projectId;

    public CommandRequirementDTO() {
    }

    public CommandRequirementDTO(int id, int requirementNo, String separate, String name, String content, String note, int projectId) {
        this.id = id;
        this.requirementNo = requirementNo;
        this.separate = separate;
        this.name = name;
        this.content = content;
        this.note = note;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequirementNo() {
        return requirementNo;
    }

    public void setRequirementNo(int requirementNo) {
        this.requirementNo = requirementNo;
    }

    public String getSeparate() {
        return separate;
    }

    public void setSeparate(String separate) {
        this.separate = separate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "CommandRequirementDTO{" +
                "id=" + id +
                ", requirementNo=" + requirementNo +
                ", separate='" + separate + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", note='" + note + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
