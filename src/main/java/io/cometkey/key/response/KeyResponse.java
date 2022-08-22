package io.cometkey.key.response;

import lombok.AccessLevel;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeyResponse {

    private List<UsageResponse> usageResponseList;

    @Builder
    public KeyResponse(List<UsageResponse> usageResponseList) {
        this.usageResponseList = usageResponseList;
    }
}
