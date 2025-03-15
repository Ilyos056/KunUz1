package tadjik.ilyosjon.kunuz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.model.EmailHistory;

public interface EmailHistoryRepo extends JpaRepository<EmailHistory, Integer> {
}
