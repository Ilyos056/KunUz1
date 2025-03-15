package tadjik.ilyosjon.kunuz1.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
}
