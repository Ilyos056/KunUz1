package tadjik.ilyosjon.kunuz1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import tadjik.ilyosjon.kunuz1.model.entity.Status;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ArticleLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Profile> profileId;
    @ManyToMany
    private List<Article> articleId;
    @CreatedDate
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    public void setId(List<Profile> profile) {


    }
}
