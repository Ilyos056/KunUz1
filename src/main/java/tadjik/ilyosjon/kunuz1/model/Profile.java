package tadjik.ilyosjon.kunuz1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import tadjik.ilyosjon.kunuz1.model.entity.RolePermission;
import tadjik.ilyosjon.kunuz1.model.entity.Status;

import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private String password;
    //status
    @Enumerated(EnumType.STRING)
    private Status status=Status.ACTIVE;
    //role
    @Enumerated(EnumType.STRING)
    private RolePermission rolePermission;
    private boolean visible;
    @CreatedDate
    private LocalDateTime created_date;
    @Column(nullable = false)
    private Long photo_Id;
}
