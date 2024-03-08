package org.teamone.projecttemplate.command.vo;

import lombok.Setter;

@Setter
public class CommandTestcaseResponse {
    private int testNo;
    private String separate;
    private String content;
    private String expectedValue;
    private String result;
    private String note;
    private int projectId;

    public CommandTestcaseResponse() {
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
        return "TestcaseResponse{" +
                "testNo=" + testNo +
                ", separate='" + separate + '\'' +
                ", content='" + content + '\'' +
                ", expectedValue='" + expectedValue + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
