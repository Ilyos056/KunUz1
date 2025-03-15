package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.Column;
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
public class ArticleDto {
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, unique = true)
    private String content;
    @Column(nullable = false)
    private Integer shared_count;
    @Column(nullable = false)
    private Integer image_id;
    @ManyToMany
    private Integer regionsid;
    @ManyToMany
    private Integer categoryid;
    @Column(nullable = false)
    private Integer moderator_id;
    @Column(nullable = false)
    private Integer publisher_id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreatedDate
    private LocalDateTime created_Date;
    @CreatedDate
    private LocalDateTime published_date;
    private boolean visible;
    @Column(nullable = false)
    private Integer view_count;
}
