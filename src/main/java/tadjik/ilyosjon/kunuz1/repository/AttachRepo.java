package tadjik.ilyosjon.kunuz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.model.Attach;

import java.util.Optional;
import java.util.UUID;

public interface AttachRepo extends JpaRepository<Attach, UUID> {
    Optional<Attach> findById(UUID uuid);
    void deleteById(UUID uuid);
}
