package tadjik.ilyosjon.kunuz1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreatedDate
    private LocalDateTime createdDate;
    @CreatedDate
    private LocalDateTime updatedDate;
    @ManyToMany
    private List<Profile> profiles;
    @Column(nullable = false)
    private String content;
    @ManyToMany
    private List<Article> articlesid;
    @Column(nullable = false)
    private Integer reply_id;
    @Column(nullable = false)
    private boolean visible;

}
