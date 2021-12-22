package ru.drudenko.sms.dto;

import ru.drudenko.sms.api.DeliveryPolicy;
import ru.drudenko.sms.api.SmsInfo;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class SendSmsRequest {
    private SmsInfo smsInfo;
    private DeliveryPolicy deliveryPolicy;

    public SendSmsRequest() {
    }

    public SendSmsRequest(SmsInfo smsInfo, DeliveryPolicy deliveryPolicy) {
        this.smsInfo = smsInfo;
        this.deliveryPolicy = deliveryPolicy;
    }

    public SmsInfo getSmsInfo() {
        return smsInfo;
    }

    public void setSmsInfo(SmsInfo smsInfo) {
        this.smsInfo = smsInfo;
    }

    public DeliveryPolicy getDeliveryPolicy() {
        return deliveryPolicy;
    }

    public void setDeliveryPolicy(DeliveryPolicy deliveryPolicy) {
        this.deliveryPolicy = deliveryPolicy;
    }
}
