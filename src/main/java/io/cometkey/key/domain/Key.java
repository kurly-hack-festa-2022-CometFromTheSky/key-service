package io.cometkey.key.domain;

import io.cometkey.key.domain.type.Mifare;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "KEY")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Key {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull
    private Long orderId;

    @Embedded
    @NotNull
    private Mifare mifare;

    @LastModifiedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime modifiedAt;
    @CreatedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    @Builder
    public Key(Long orderId, Mifare mifare) {
        this.orderId = orderId;
        this.mifare = mifare;
    }
}
