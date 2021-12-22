package ru.drudenko.sms.api;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class AttemptId {
    private final Long id;

    private AttemptId(Long id) {
        this.id = id;
    }

    public static AttemptId valueLong(Long value){
        return new AttemptId(value);
    }

    public Long getId() {
        return id;
    }
}
