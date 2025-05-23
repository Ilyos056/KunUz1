package tadjik.ilyosjon.kunuz1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import tadjik.ilyosjon.kunuz1.model.entity.Status;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Integer sharedcount;
    @Column(nullable = false)
    private Integer imageid;
    @Column(nullable = false)
    private Integer regionId;
    @Column(nullable = false)
    private Integer categoryId;
    @Column(nullable = false)
    private Integer moderatorId;
    @Column(nullable = false)
    private Integer publisherId;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreatedDate()
    private LocalDate createDate;
    @CreatedDate()
    private LocalDate publishedDate;
    private boolean visible;
    @Column(nullable = false)
    private Integer viewCount;

    public void setRegionId(List<Region> region) {
    }

    public void setCategoryId(List<Category> category) {


    }
}
