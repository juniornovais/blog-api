package boot.spring.blog.services;

import boot.spring.blog.dto.PostRequestDto;
import boot.spring.blog.dto.PostResponseDto;
import boot.spring.blog.entitie.Post;
import boot.spring.blog.entitie.Tag;
import boot.spring.blog.repository.PostRepository;
import boot.spring.blog.repository.TagRepository;
import jakarta.persistence.Table;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    public PostService(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    public PostResponseDto criar(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setTittle(postRequestDto.title());
        post.setContent(postRequestDto.content());

        Set<Tag> tags = postRequestDto.tags().stream()
                        .map(tagRequestDto -> {
                            Tag tag = new Tag();
                            tag.setName(tagRequestDto.name());
                            return tag;
                        }).collect(Collectors.toSet());

        Set<Tag> tagsSalva = new HashSet<>(tagRepository.saveAll(tags));

        post.setTags(tagsSalva);

        Post postSalvo = postRepository.save(post);
        return new PostResponseDto(
                postSalvo.getId(),
                postSalvo.getTittle(),
                postSalvo.getContent(),
                postSalvo.getTags()

        );
    }
}
