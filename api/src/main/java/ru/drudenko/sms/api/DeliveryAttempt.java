package ru.drudenko.sms.api;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class DeliveryAttempt {
    private final AttemptId id;
    private final SmsId smsId;
    private final AttemptStatus status;

    private DeliveryAttempt(AttemptId id, SmsId smsId, AttemptStatus status) {
        this.id = id;
        this.smsId = smsId;
        this.status = status;
    }

    public AttemptId getId() {
        return id;
    }

    public AttemptStatus getStatus() {
        return status;
    }

    public SmsId getSmsId() {
        return smsId;
    }


    public static final class DeliveryAttemptBuilder {
        private AttemptId id;
        private SmsId smsId;
        private AttemptStatus status;

        private DeliveryAttemptBuilder() {
        }

        public static DeliveryAttemptBuilder aDeliveryAttempt() {
            return new DeliveryAttemptBuilder();
        }

        public DeliveryAttemptBuilder withId(AttemptId id) {
            this.id = id;
            return this;
        }

        public DeliveryAttemptBuilder withSmsId(SmsId smsId) {
            this.smsId = smsId;
            return this;
        }

        public DeliveryAttemptBuilder withStatus(AttemptStatus status) {
            this.status = status;
            return this;
        }

        public DeliveryAttempt build() {
            return new DeliveryAttempt(id, smsId, status);
        }
    }
}
