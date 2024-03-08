package org.teamone.projecttemplate.query.entity;

public class Issue {
    private int id;
    private int issueNo;
    private String issueName;
    private String issueStatus;
    private String issueContent;
    private int managerId;
    private int writerId;
    private int projectId;

    public Issue() {
    }

    public Issue(int projectId) {
        this.projectId = projectId;
    }

    public Issue(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Issue(int id, int issueNo, String issueName, String issueStatus, String issueContent, int managerId, int writerId, int projectId) {
        this.id = id;
        this.issueNo = issueNo;
        this.issueName = issueName;
        this.issueStatus = issueStatus;
        this.issueContent = issueContent;
        this.managerId = managerId;
        this.writerId = writerId;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public String getIssueName() {
        return issueName;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public String getIssueContent() {
        return issueContent;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getWriterId() {
        return writerId;
    }

    public int getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "Id=" + id +
                ", issueNo=" + issueNo +
                ", issueName='" + issueName + '\'' +
                ", issueStatus='" + issueStatus + '\'' +
                ", issueContent='" + issueContent + '\'' +
                ", managerId=" + managerId +
                ", writerId=" + writerId +
                ", projectId=" + projectId +
                '}';
    }
}
