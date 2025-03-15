package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedArticleDto {

    @ManyToAny
    private Integer profiles;
    @ManyToMany
    private Integer articles;
    @CreatedDate
    private LocalDateTime createdDate;
}
