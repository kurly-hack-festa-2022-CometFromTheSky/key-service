package io.cometkey.key.response;

import lombok.AccessLevel;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MifareResponse {

    private String mifare;

    @Builder
    public MifareResponse(String mifare) {
        this.mifare = mifare;
    }
}
