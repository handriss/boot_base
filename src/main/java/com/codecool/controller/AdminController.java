package com.codecool.controller;


import com.codecool.model.Post;
import com.codecool.service.PostService;
import com.codecool.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public AdminController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/posts")
    public String list(Model model){
        model.addAttribute("posts", postService.findAll());
        return "admin/list";
    }

    @GetMapping("/create-post")
    public String createPost(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "admin/create-post";
    }

    @PostMapping("/create-post")
    public String savePost(Post post){
        postService.save(post);
        return "admin/list";
    }

    @GetMapping("/browse-files")
    public String listFiles(Model model){

        return "admin/browse-file";
    }
}