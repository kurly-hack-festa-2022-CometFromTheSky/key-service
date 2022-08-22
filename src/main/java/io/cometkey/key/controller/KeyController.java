package io.cometkey.key.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cometkey.key.domain.Key;
import io.cometkey.key.request.NewKey;
import io.cometkey.key.request.TokenList;
import io.cometkey.key.response.KeyResponse;
import io.cometkey.key.service.KeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class KeyController {

    private final KeyService keyService;

    @GetMapping("/v1/key")
    public KeyResponse GetKeyInfo(@Valid @RequestBody TokenList tokenList) throws JsonProcessingException {

        return KeyResponse.builder()
                .usageResponseList(this.keyService.getKey(tokenList.getTokenList()))
                .build();
    }

    @PutMapping("/v1/key")
    public String PutKeyInfo(@Valid @RequestBody NewKey newKey) throws JsonProcessingException {

        String token = UUID.randomUUID().toString();
        this.keyService.addNewKey(Key.builder()
                .token(token)
                .encryptedKey(newKey.getEncryptedKey())
                .provider(newKey.getProvider())
                .build()
        );

        return token;
    }
}
