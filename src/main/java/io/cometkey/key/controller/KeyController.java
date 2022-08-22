package io.cometkey.key.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cometkey.key.domain.Key;
import io.cometkey.key.request.KeyList;
import io.cometkey.key.request.NewKey;
import io.cometkey.key.response.KeyIdResponse;
import io.cometkey.key.response.KeyResponse;
import io.cometkey.key.response.UsageResponse;
import io.cometkey.key.service.KeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class KeyController {

    private final KeyService keyService;

    @GetMapping("/v1/key")
    public KeyResponse GetKeyInfo(@Valid @RequestBody KeyList keyList) throws JsonProcessingException {

        return KeyResponse.builder()
                .usageResponseList(this.keyService.getKey(keyList.getIdList()))
                .build();
    }

    @PutMapping("/v1/key")
    public KeyIdResponse PutKeyInfo(@Valid @RequestBody NewKey newKey) {

        return KeyIdResponse.builder()
                .keyId(this.keyService.addNewKey(Key.builder()
                                .encryptedKey(newKey.getEncryptedKey())
                                .provider(newKey.getProvider())
                                .isUsed(newKey.getIsUsed())
                                .build()
                        )
                )
                .build();
    }
}
