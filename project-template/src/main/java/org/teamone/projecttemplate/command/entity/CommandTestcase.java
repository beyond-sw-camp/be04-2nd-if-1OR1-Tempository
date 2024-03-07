package org.teamone.projecttemplate.command.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_project_testcase")
public class CommandTestcase {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="TEST_NO", nullable = false)
    private int testNo;

    @Column(name="SEPARATE", nullable = false)
    private String separate;

    @Column(name="CONTENT", nullable = false)
    private String content;

    @Column(name="EXPECTED_VALUE")
    private String expectedValue;

    @Column(name="RESULT")
    private String result;

    @Column(name="NOTE")
    private String note;

    @Column(name="PROJECT_ID", nullable = false)
    private int projectId;

    public CommandTestcase() {
    }

    public CommandTestcase(String separate, int projectId) {
        this.separate = separate;
        this.projectId = projectId;
    }

    public CommandTestcase(int testNo, String separate, String content, String expectedValue, String result, String note, int projectId) {
        this.testNo = testNo;
        this.separate = separate;
        this.content = content;
        this.expectedValue = expectedValue;
        this.result = result;
        this.note = note;
        this.projectId = projectId;
    }

    public CommandTestcase(int id, int testNo, String separate, String content, String expectedValue, String result, String note, int projectId) {
        this.id = id;
        this.testNo = testNo;
        this.separate = separate;
        this.content = content;
        this.expectedValue = expectedValue;
        this.result = result;
        this.note = note;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public int getTestNo() {
        return testNo;
    }

    public String getSeparate() {
        return separate;
    }

    public String getContent() {
        return content;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public String getResult() {
        return result;
    }

    public String getNote() {
        return note;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public void setSeparate(String separate) {
        this.separate = separate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Testcase{" +
                "id=" + id +
                ", testNo=" + testNo +
                ", separate='" + separate + '\'' +
                ", content='" + content + '\'' +
                ", expectedValue='" + expectedValue + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
