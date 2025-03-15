package tadjik.ilyosjon.kunuz1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Article_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Long ordernumber;
    @Column(nullable = false)
    private String nameuz;
    @Column(nullable = false)
    private String nameru;
    @Column(nullable = false)
    private String nameeng;
    private boolean visible;
    @CreatedDate
    private LocalDateTime createdDate;
}
