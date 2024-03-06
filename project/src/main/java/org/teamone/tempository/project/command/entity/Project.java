package org.teamone.tempository.project.command.entity;

import jakarta.persistence.*;
import lombok.*;
import org.teamone.tempository.project.command.status.ProjectStatus;

@Entity
@Table(name = "tbl_project")
@Getter
@NoArgsConstructor
@ToString
@Setter
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 127, nullable = false)
    private String name;

    @Column(name = "is_public" , nullable = false)
    private boolean isPublic;

    @Column(name = "like_cnt", nullable = false)
    private int likeCnt;

    @Column(name = "status", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Column(name = "content", length = 2047)
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
