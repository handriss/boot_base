package com.codecool.repository;


import com.codecool.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String title);

    Post findById(Long id);

}