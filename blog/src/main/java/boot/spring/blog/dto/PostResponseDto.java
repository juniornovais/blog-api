package boot.spring.blog.dto;

import boot.spring.blog.entitie.Tag;

import java.util.Set;

public record PostResponseDto (
        Long id,
        String title,
        String content,
        Set<Tag> tags)
        { }
