package com.example.week2.Controller;

import com.example.week2.Enum.CategoryType;
import com.example.week2.Model.Post;
import com.example.week2.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @PostMapping("/create")
    public Post createPost(@RequestBody Post post){
        System.out.println("deneme");
        return postRepository.save(post);
    }
    @GetMapping("byId")
    public Optional<Post> postGetById(@RequestParam Long id){
        System.out.println("denemeGet");
        return postRepository.findById(id);
    }
    @GetMapping("all")
    public List<Post> getAllPosts(){
        System.out.println("denemeGetAll");
        return postRepository.findAll();
    }

    @GetMapping("/author")
    public List<Post> findPostByAuthor(@RequestParam String author){
        return postRepository.findPostsByAuthor(author);
    }
    @GetMapping("/category")
    public List<Post> findPostsByCategory(@RequestParam CategoryType category){
        return this.postRepository.findPostsByCategory(category);
    }

    @GetMapping("/findTopThree")
    public List<Post> findFirstThreeByOrderByCreatedAtDesc(){
        return this.postRepository.getLatestPost();
    }
    @PutMapping("/updatePost")
    Optional<Post> updatePost(@RequestBody Post post, @RequestParam Long id, String person){
        return postRepository.findById(id).map(c -> {
            c.setAuthor(post.getAuthor());
            c.setCategory(post.getCategory());
            c.setUpdatedAt(LocalDateTime.now());
            c.setUpdatedBy(person);
            c.setText(post.getText());
            c.setTitle(post.getTitle());
            return postRepository.save(c);
        });
    }
}
