package org.teamone.tempository.project.command.entity;

import jakarta.persistence.*;
import lombok.*;
import org.teamone.tempository.project.command.status.ProjectStatus;

@Entity
@Table(name = "tbl_project")
@Getter
@NoArgsConstructor
@ToString
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
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Column(name = "content")
    private String content;

    @Builder
    public Project( String name, boolean isPublic, int likeCnt, ProjectStatus status, String content) {
        this.name = name;
        this.isPublic = isPublic;
        this.likeCnt = likeCnt;
        this.status = status;
        this.content = content;
    }
}
