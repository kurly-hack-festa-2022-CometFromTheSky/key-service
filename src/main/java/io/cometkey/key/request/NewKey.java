package io.cometkey.key.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class NewKey {

    @NotNull
    private String encryptedKey;

    @NotNull
    private String provider;    // 제공회사

    @Builder
    public NewKey(String encryptedKey, String provider) {
        this.encryptedKey = encryptedKey;
        this.provider = provider;
    }
}
