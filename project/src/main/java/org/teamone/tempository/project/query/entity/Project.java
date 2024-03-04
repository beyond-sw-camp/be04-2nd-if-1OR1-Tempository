package org.teamone.tempository.project.query.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_project")
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(name = "like_cnt")
    private int likeCnt;

    @Column(name = "status")
    private String status;
    @Column(name = "content")
    private String content;

    public Project(int id, String name, boolean isPublic, int likeCnt, String status, String content) {
        this.id = id;
        this.name = name;
        this.isPublic = isPublic;
        this.likeCnt = likeCnt;
        this.status = status;
        this.content = content;
    }

    public Project(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public String getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPublic=" + isPublic +
                ", likeCnt=" + likeCnt +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Project(int id) {
        this.id = id;
    }

    public Project() {
    }
}
