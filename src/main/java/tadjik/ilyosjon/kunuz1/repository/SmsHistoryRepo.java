package tadjik.ilyosjon.kunuz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.dto.SmsHistory;

public interface SmsHistoryRepo extends JpaRepository<SmsHistory, Integer> {
}
