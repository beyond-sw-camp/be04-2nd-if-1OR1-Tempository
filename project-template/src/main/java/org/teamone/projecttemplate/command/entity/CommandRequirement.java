package org.teamone.projecttemplate.command.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_project_requirement")
public class CommandRequirement {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "REQUIREMENT_NO", nullable = false)
    private int requirementNo;

    @Column(name = "SEPARATE", nullable = false)
    private String separate;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "PROJECT_ID", nullable = false)
    private int projectId;

    public CommandRequirement() {
    }

    public CommandRequirement(int id, int requirementNo, String separate, String name, String content, String note, int projectId) {
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
        return "CommandRequirement{" +
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
