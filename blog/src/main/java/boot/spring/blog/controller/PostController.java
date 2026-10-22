package boot.spring.blog.controller;

import boot.spring.blog.dto.PostRequestDto;
import boot.spring.blog.dto.PostResponseDto;
import boot.spring.blog.entitie.Post;
import boot.spring.blog.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    public ResponseEntity<PostResponseDto> criar(@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto postNovo = postService.criar(postRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(postNovo);
    }
}
