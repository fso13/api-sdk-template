package ru.drudenko.sms.testclient;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.drudenko.sms.api.DeliveryAttempt;
import ru.drudenko.sms.api.Sms;
import ru.drudenko.sms.api.SmsId;
import ru.drudenko.sms.api.SmsService;
import ru.drudenko.sms.dto.SendSmsRequest;
import ru.drudenko.sms.sdk.SmsServiceFacade;

import java.util.List;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {
    private final SmsServiceFacade service;


    public TestController(SmsServiceFacade service) {
        this.service = service;
    }

    @GetMapping("/{smsId}/attempts")
    List<DeliveryAttempt> getAttempts(@PathVariable("smsId") Long smsId) {
        return service.getAttempts(SmsId.valueLong(smsId));
    }


    @PostMapping
    Sms send(SendSmsRequest request) {
        return service.send(request.getSmsInfo(), request.getDeliveryPolicy());
    }
}
