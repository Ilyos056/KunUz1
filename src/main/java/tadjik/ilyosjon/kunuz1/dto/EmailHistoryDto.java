package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailHistoryDto {

    private String message;
    @Column(nullable = false, unique = true)
    private String email;
    @CreatedDate
    private LocalDateTime createdDate;
}
