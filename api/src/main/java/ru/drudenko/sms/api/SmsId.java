package ru.drudenko.sms.api;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class SmsId {
    private final Long id;

    private SmsId(Long id) {
        this.id = id;
    }

    public static SmsId valueLong(Long value){
        return new SmsId(value);
    }

    public Long getId() {
        return id;
    }
}
