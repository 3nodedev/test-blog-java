package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="comment")
@NamedQuery(name="Comment.findAll", query="SELECT c from Comment c")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String text;

    private Post post;

    public Comment() {

    }

    @Id
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length=45)
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @ManyToOne
    @JoinColumn(name="postId", nullable=false)
    @JsonBackReference
    public Post getPost() {
        return this.post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
