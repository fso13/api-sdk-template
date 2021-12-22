package ru.drudenko.sms.dto;

import ru.drudenko.sms.api.AttemptId;
import ru.drudenko.sms.api.AttemptStatus;
import ru.drudenko.sms.api.DeliveryAttempt;
import ru.drudenko.sms.api.SmsId;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class DeliveryAttemptResponse {
    private Long id;
    private Long smsId;
    private AttemptStatus status;

    public static DeliveryAttemptResponse fromApi(DeliveryAttempt deliveryAttempt) {
        DeliveryAttemptResponse response = new DeliveryAttemptResponse();
        response.setId(deliveryAttempt.getId().getId());
        response.setSmsId(deliveryAttempt.getSmsId().getId());
        response.setStatus(deliveryAttempt.getStatus());
        return response;
    }

    public DeliveryAttempt fromDto() {
        return DeliveryAttempt.DeliveryAttemptBuilder.aDeliveryAttempt()
                .withStatus(status)
                .withSmsId(SmsId.valueLong(smsId))
                .withId(AttemptId.valueLong(id))
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public AttemptStatus getStatus() {
        return status;
    }

    public void setStatus(AttemptStatus status) {
        this.status = status;
    }
}
