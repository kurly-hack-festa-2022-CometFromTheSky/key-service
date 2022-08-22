package io.cometkey.key.response;

import lombok.AccessLevel;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeyIdResponse {

    private Long keyId;

    @Builder
    public KeyIdResponse(Long keyId) {
        this.keyId = keyId;
    }
}
