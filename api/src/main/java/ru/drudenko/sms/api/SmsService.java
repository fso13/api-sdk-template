package ru.drudenko.sms.api;

import java.util.List;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public interface SmsService {

    Sms send(SmsInfo smsInfo, DeliveryPolicy deliveryPolicy);

    List<DeliveryAttempt> getAttempts(SmsId smsId);
}
