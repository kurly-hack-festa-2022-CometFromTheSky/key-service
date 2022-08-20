package io.cometkey.key.service;

import io.cometkey.key.domain.Key;
import io.cometkey.key.repository.KeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeyService {

    private final KeyRepository keyRepository;

    public Key getKey(Long orderId) { return this.keyRepository.findByOrderId(orderId).get(); }
}
