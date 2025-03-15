package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionDto {

    private Long order_num;
    private String name_uz;
    private String name_ru;
    private String name_eng;

}
