package org.teamone.projecttemplate.query.dto;

public class TestcaseDTO {
    private int id;
    private int testNo;
    private String separate;
    private String content;
    private String expectedValue;
    private String result;
    private String note;
    private int projectId;

    public TestcaseDTO() {
    }

    public TestcaseDTO(String separate, int projectId) {
        this.separate = separate;
        this.projectId = projectId;
    }

    public TestcaseDTO(int projectId, String result) {
        this.projectId = projectId;
        this.result = result;
    }

    public TestcaseDTO(int testNo, String separate, String content, String expectedValue, String result, String note, int projectId) {
        this.testNo = testNo;
        this.separate = separate;
        this.content = content;
        this.expectedValue = expectedValue;
        this.result = result;
        this.note = note;
        this.projectId = projectId;
    }

    public TestcaseDTO(int id, int testNo, String separate, String content, String expectedValue, String result, String note, int projectId) {
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
        return "TestcaseDTO{" +
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
