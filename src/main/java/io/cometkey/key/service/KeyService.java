package io.cometkey.key.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cometkey.key.domain.Key;
import io.cometkey.key.response.UsageResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KeyService {

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC_NAME = "newKey";


    public List<UsageResponse> getKey(List<String> tokenList) throws JsonProcessingException {

        //DONE: worker에 해당 id들 key list GET 요청
        //TODO: workerUrl 배포 후 수정
        String workerUrl = "http://localhost:8080";
        String getKeyUrl = "/v1/worker/key";
        String url = workerUrl + getKeyUrl;

        //Header
        HttpHeaders httpHeaders = new HttpHeaders();

        //Body
        Map<String, List<String>> body = new LinkedHashMap<>();
        body.put("tokenList", tokenList);
        String param = this.objectMapper.writeValueAsString(body);
        HttpEntity entity = new HttpEntity(param, httpHeaders);

        //Request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UsageResponseList> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, UsageResponseList.class);

        //Response
        return responseEntity.getBody().getUsageResponses();
    }

    public void addNewKey(Key key) throws JsonProcessingException {

        //DONE: Kafka produce -> 해당 key POST 요청
        String messageData = this.objectMapper.writeValueAsString(key);
        this.kafkaTemplate.send(new ProducerRecord<>(TOPIC_NAME, messageData));
    }
}

@Getter
class UsageResponseList {

    private final List<UsageResponse> usageResponses;

    public UsageResponseList() {
        this.usageResponses = new ArrayList<>();
    }
}
