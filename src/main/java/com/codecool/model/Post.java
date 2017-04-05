package com.codecool.model;


import com.codecool.model.enums.PostCategoryEnum;
import com.codecool.model.enums.TargetCategoryEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;

    private ArrayList<PostCategoryEnum> postCategories;

    private ArrayList<TargetCategoryEnum> targetCategories;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name="postCategory_post", joinColumns = @JoinColumn(name="kutya2"), inverseJoinColumns = @JoinColumn(name="cica2"))
//    private Set<PostCategoryEnum> postCategories;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name="targetCategory_post", joinColumns = @JoinColumn(name="kutya"), inverseJoinColumns = @JoinColumn(name="cica"))
//    private Set<TargetCategoryEnum> targetCategories;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_post", joinColumns = @JoinColumn(name="role_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="post_file", joinColumns = @JoinColumn(name="post_id"), inverseJoinColumns = @JoinColumn(name="file_id"))
    private Set<File> files;

    public Post(){}

    public Post(String title) {
        this.title = title;
        this.postedOn = new Timestamp(System.currentTimeMillis());
    }
}
