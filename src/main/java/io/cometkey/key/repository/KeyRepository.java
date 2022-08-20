package io.cometkey.key.repository;

import io.cometkey.key.domain.Key;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeyRepository extends JpaRepository<Key, Long> {

    Optional<Key> findByOrderId(Long orderId);
}
