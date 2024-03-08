package org.teamone.projecttemplate.query.entity;

public class Requirement {
    private int id;
    private int requirementNo;
    private String separate;
    private String name;
    private String content;
    private String note;
    private int projectId;

    public Requirement() {
    }

    public Requirement(String separate, int projectId) {
        this.separate = separate;
        this.projectId = projectId;
    }

    public Requirement(int id, int requirementNo, String separate, String name, String content, String note, int projectId) {
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
        return "Requirement{" +
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
