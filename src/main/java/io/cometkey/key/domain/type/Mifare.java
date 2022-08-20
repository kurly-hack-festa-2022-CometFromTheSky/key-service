package io.cometkey.key.domain.type;

import lombok.AccessLevel;
import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mifare {
    
    //TODO: emulator 완성시 수정
    private String mifare;

    @Builder
    public Mifare(String mifare) {
        this.mifare = mifare;
    }
}
