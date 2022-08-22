package io.cometkey.key.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cometkey.key.domain.Key;
import io.cometkey.key.response.UsageResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KeyService {

    private ObjectMapper objectMapper;

    public List<UsageResponse> getKey(List<Long> idList) throws JsonProcessingException {

        //TODO: worker에 해당 id들 key list GET 요청
        //TODO: workerUrl 배포 후 수정
        String workerUrl = "http://localhost:8080";
        String getKeyUrl = "/v1/worker/key";
        String url = workerUrl + getKeyUrl;

        //Header
        HttpHeaders httpHeaders = new HttpHeaders();

        //Body
        Map<String, List<Long>> body = new LinkedHashMap<>();
        body.put("idList", idList);
        String param = objectMapper.writeValueAsString(body);
        HttpEntity entity = new HttpEntity(param, httpHeaders);

        //Request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UsageResponseList> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, UsageResponseList.class);

        //Response
        return responseEntity.getBody().getUsageResponses();
    }

    public Long addNewKey(Key key) {

        //TODO: Kafka produce -> 해당 key POST 요청 후 등록된 id 받아서 반환
        return null;
    }
}

@Getter
class UsageResponseList {

    private final List<UsageResponse> usageResponses;

    public UsageResponseList() {
        this.usageResponses = new ArrayList<>();
    }
}
