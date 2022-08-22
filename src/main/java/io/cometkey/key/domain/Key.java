package io.cometkey.key.domain;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Key {

    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull
    private String token;

    @NotNull
    private String encryptedKey;

    @NotNull
    private String provider;    // 제공회사

    @Builder
    public Key(String token, String encryptedKey, String provider) {
        this.token = token;
        this.encryptedKey = encryptedKey;
        this.provider = provider;
    }
}
