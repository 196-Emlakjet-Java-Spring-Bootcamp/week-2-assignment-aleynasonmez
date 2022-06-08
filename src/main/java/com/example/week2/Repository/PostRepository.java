package com.example.week2.Repository;

import com.example.week2.Enum.CategoryType;
import com.example.week2.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//maven spring run demeyi unutma db çalışmaz. jar dosyası
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByAuthor(String author);
    List<Post> getLatestPost();
    List<Post> findPostsByCategory(CategoryType category);
}
