package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTypeDto {


    private Long order_num;
    private String nameuz;
    private String nameru;
    private String nameeng;
    private LocalDateTime createdDate;
}
