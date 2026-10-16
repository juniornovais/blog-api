package boot.spring.blog.entitie;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tittle;
    private String content;

    @ManyToMany(mappedBy = "tags")
    private List<Tags> tags = new ArrayList<>();

}
