package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="post")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String text;

    private String title;

    private List<Comment> comments;

    public Post() {

    }

    @Id
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    @Column(length=55)
    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    @Column
    public String getText() { return this.text; }

    public void setText(String text) { this.text = text; }

    @OneToMany(mappedBy = "post")
    @JsonManagedReference
    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Comment addComment(Comment comment) {
        getComments().add(comment);
        comment.setPost(this);
        return comment;
    }
}
