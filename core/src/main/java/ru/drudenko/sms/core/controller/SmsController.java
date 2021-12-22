package ru.drudenko.sms.core.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.drudenko.sms.api.Sms;
import ru.drudenko.sms.api.SmsId;
import ru.drudenko.sms.api.SmsService;
import ru.drudenko.sms.dto.DeliveryAttemptResponse;
import ru.drudenko.sms.dto.SendSmsRequest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
@RestController
@RequestMapping(value = "/sms", produces = MediaType.APPLICATION_JSON_VALUE)
public class SmsController {
    private final SmsService service;


    public SmsController(SmsService service) {
        this.service = service;
    }

    @GetMapping("/{smsId}/attempts")
    List<DeliveryAttemptResponse> getAttempts(@PathVariable("smsId") Long smsId) {
        return service.getAttempts(SmsId.valueLong(smsId))
                .stream()
                .map(DeliveryAttemptResponse::fromApi)
                .collect(Collectors.toList());
    }


    @PostMapping
    Sms send(SendSmsRequest request) {
        return service.send(request.getSmsInfo(), request.getDeliveryPolicy());
    }
}
