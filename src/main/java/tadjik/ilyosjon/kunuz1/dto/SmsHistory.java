package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import tadjik.ilyosjon.kunuz1.model.entity.Status;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsHistory {
    private String phone;
    @Column(nullable = false)
    private String message;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String type;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime uded_date;
}
