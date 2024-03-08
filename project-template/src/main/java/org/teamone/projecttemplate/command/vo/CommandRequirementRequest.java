package org.teamone.projecttemplate.command.vo;

public class CommandRequirementRequest {
    private int requirementNo;
    private String separate;
    private String name;
    private String content;
    private String note;
    private int projectId;

    public CommandRequirementRequest() {
    }

    public CommandRequirementRequest(int requirementNo, String separate, String name, String content, String note, int projectId) {
        this.requirementNo = requirementNo;
        this.separate = separate;
        this.name = name;
        this.content = content;
        this.note = note;
        this.projectId = projectId;
    }

    public int getRequirementNo() {
        return requirementNo;
    }

    public String getSeparate() {
        return separate;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getNote() {
        return note;
    }

    public int getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "RequirementRequest{" +
                "requirementNo=" + requirementNo +
                ", separate='" + separate + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", note='" + note + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
