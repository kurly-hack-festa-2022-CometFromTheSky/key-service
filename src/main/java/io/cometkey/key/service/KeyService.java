package io.cometkey.key.service;

import io.cometkey.key.domain.Key;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyService {

    public List<Key> getKey(List<Long> idList) {
        //TODO: worker에 해당 id들 GET 요청
        return null;
    }

    public Long addNewKey(Key key) {
        //TODO: worker에 해당 key POST 요청 후 등록된 id 받아서 반환
        return null;
    }
}
