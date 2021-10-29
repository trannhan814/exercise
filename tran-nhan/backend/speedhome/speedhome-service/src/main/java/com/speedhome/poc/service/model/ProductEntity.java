package com.speedhome.poc.service.model;

import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

@Indexed
@Entity
@Table(name = "Product")
public class ProductEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private String id;
    @Column(name = "IMAGE", nullable = false)
    private String image;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "TIME", nullable = false)
    private String time ;
    @Column(name = "CATEGORY", nullable = false)
    private String category;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "CONTEXT", nullable = false)
    private String context;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
