package org.teamone.projecttemplate.command.vo;

public class CommandTestcaseSequenceRequest {
    private int projectId;
    private int testNo;
    private int num;

    public CommandTestcaseSequenceRequest() {
    }

    public CommandTestcaseSequenceRequest(int projectId, int testNo, int num) {
        this.projectId = projectId;
        this.testNo = testNo;
        this.num = num;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getTestNo() {
        return testNo;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "TestcaseSequenceRequest{" +
                "projectId=" + projectId +
                ", testNo=" + testNo +
                ", num=" + num +
                '}';
    }
}
