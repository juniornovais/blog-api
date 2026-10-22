package boot.spring.blog.dto;

import java.util.Set;

public record PostRequestDto (
        String title,
        String content,
        Set<TagRequestDto> tags


){
    public record TagRequestDto(
            String name
    ){}

}
