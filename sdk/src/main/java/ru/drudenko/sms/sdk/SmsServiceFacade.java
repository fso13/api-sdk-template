package ru.drudenko.sms.sdk;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.drudenko.sms.api.DeliveryAttempt;
import ru.drudenko.sms.api.DeliveryPolicy;
import ru.drudenko.sms.api.Sms;
import ru.drudenko.sms.api.SmsId;
import ru.drudenko.sms.api.SmsInfo;
import ru.drudenko.sms.api.SmsService;
import ru.drudenko.sms.dto.DeliveryAttemptResponse;
import ru.drudenko.sms.dto.SendSmsRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class SmsServiceFacade implements SmsService {

    private final RestTemplate restTemplate;

    public SmsServiceFacade(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Sms send(SmsInfo smsInfo, DeliveryPolicy deliveryPolicy) {
        return restTemplate.postForObject("", new SendSmsRequest(smsInfo, deliveryPolicy), Sms.class);
    }

    @Override
    public List<DeliveryAttempt> getAttempts(SmsId smsId) {
        List<DeliveryAttemptResponse> deliveryAttemptResponses = Arrays.asList(restTemplate.getForObject(String.format("/%s/attempts", smsId.getId()), DeliveryAttemptResponse[].class));
        return deliveryAttemptResponses
                .stream()
                .map(DeliveryAttemptResponse::fromDto)
                .collect(Collectors.toList());

    }
}
