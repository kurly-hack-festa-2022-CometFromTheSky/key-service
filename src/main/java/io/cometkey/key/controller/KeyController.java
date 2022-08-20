package io.cometkey.key.controller;

import io.cometkey.key.domain.Key;
import io.cometkey.key.response.KeyResponse;
import io.cometkey.key.response.MifareResponse;
import io.cometkey.key.service.KeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class KeyController {

    private final KeyService keyService;

    @GetMapping("/v1/key/{order_id}")
    public KeyResponse GetKeyInfo(@Valid @PathVariable String order_id) {
        Key key = this.keyService.getKey(Long.valueOf(order_id));

        //TODO: emulator 완성시 수정
        return KeyResponse.builder()
                .key(MifareResponse.builder().
                        mifare(key.getMifare().getMifare())
                        .build())
                .build();
    }
}
