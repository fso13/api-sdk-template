package ru.drudenko.sms.core.impl;

import org.springframework.stereotype.Service;
import ru.drudenko.sms.api.AttemptId;
import ru.drudenko.sms.api.AttemptStatus;
import ru.drudenko.sms.api.DeliveryAttempt;
import ru.drudenko.sms.api.DeliveryPolicy;
import ru.drudenko.sms.api.Sms;
import ru.drudenko.sms.api.SmsId;
import ru.drudenko.sms.api.SmsInfo;
import ru.drudenko.sms.api.SmsService;
import ru.drudenko.sms.api.SmsStatus;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public Sms send(SmsInfo smsInfo, DeliveryPolicy deliveryPolicy) {
        return Sms.SmsBuilder.aSms()
                .withId(SmsId.valueLong(1L))
                .withInfo(SmsInfo.SmsInfoBuilder.aSmsInfo()
                        .withFrom("+79275087073")
                        .withTo("+79275087074")
                        .withText("Test text")
                        .build())
                .withPolicy(DeliveryPolicy.DeliveryPolicyBuilder.aDeliveryPolicy()
                        .withMaxAttemptCount((short) -1)
                        .withPeriod(Period.between(LocalDate.MIN, LocalDate.MAX))
                        .build())
                .withStatus(SmsStatus.SENT)
                .build();
    }

    @Override
    public List<DeliveryAttempt> getAttempts(SmsId smsId) {
        return Collections.singletonList(DeliveryAttempt.DeliveryAttemptBuilder.aDeliveryAttempt()
                .withId(AttemptId.valueLong(2L))
                .withSmsId(SmsId.valueLong(1L))
                .withStatus(AttemptStatus.SENT)
                .build());
    }
}
