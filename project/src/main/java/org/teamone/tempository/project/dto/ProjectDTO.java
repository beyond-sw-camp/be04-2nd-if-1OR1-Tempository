package org.teamone.tempository.project.dto;

public class ProjectDTO {
    private int id;
    private String Status;

    public ProjectDTO(String status) {
        Status = status;
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
