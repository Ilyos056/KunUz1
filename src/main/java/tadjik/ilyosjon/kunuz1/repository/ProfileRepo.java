package tadjik.ilyosjon.kunuz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.model.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {

    boolean existsByEmailAndPhone(String email, String phone);


    Optional<Profile> findById(List<Profile> profileId);
}


