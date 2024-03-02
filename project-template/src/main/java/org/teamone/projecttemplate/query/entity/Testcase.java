package org.teamone.projecttemplate.query.entity;

public class Testcase {
    private int id;
    private int testNo;
    private String separate;
    private String content;
    private String expectedValue;
    private String result;
    private String note;
    private int projectId;

    public Testcase() {
    }

    public Testcase(String separate, int projectId) {
        this.separate = separate;
        this.projectId = projectId;
    }

    public Testcase(int id, int testNo, String separate, String content, String expectedValue, String result, String note, int projectId) {
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
