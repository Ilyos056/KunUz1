package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private LocalDateTime createdDate;
    @CreatedDate
    private LocalDateTime updatedDate;
    @ManyToMany
    private Integer profiles;
    @Column(nullable = false)
    private String content;
    @ManyToMany
    private UUID articlesid;
    @Column(nullable = false)
    private Integer reply_id;
    @Column(nullable = false)
    private boolean visible;
}
