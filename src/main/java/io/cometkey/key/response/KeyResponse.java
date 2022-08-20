package io.cometkey.key.response;

import lombok.AccessLevel;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeyResponse {

    private MifareResponse key;

    @Builder
    public KeyResponse(MifareResponse key) {
        this.key = key;
    }
}
