package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import tadjik.ilyosjon.kunuz1.model.entity.Status;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentLikeDto {

    @ManyToMany
    private Integer profiles;
    @ManyToMany
    private Integer comments;
    @CreatedDate
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    private Status status;
}
