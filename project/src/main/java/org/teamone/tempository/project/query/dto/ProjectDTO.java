package org.teamone.tempository.project.query.dto;

public class ProjectDTO {
    private int id;
    private String Status;
    private boolean isPublic;

    public ProjectDTO(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public ProjectDTO(String status) {
        this.Status = status;
    }


    public ProjectDTO() {
    }

    public ProjectDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                '}';
    }
}
