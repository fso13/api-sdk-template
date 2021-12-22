package ru.drudenko.sms.api;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class Sms {
    private final SmsId id;
    private final SmsInfo info;
    private final DeliveryPolicy policy;
    private final SmsStatus status;

    private Sms(SmsId id, SmsInfo info, DeliveryPolicy policy, SmsStatus status) {
        this.id = id;
        this.info = info;
        this.policy = policy;
        this.status = status;
    }

    public SmsId getId() {
        return id;
    }

    public SmsInfo getInfo() {
        return info;
    }

    public DeliveryPolicy getPolicy() {
        return policy;
    }

    public SmsStatus getStatus() {
        return status;
    }


    public static final class SmsBuilder {
        private SmsId id;
        private SmsInfo info;
        private DeliveryPolicy policy;
        private SmsStatus status;

        private SmsBuilder() {
        }

        public static SmsBuilder aSms() {
            return new SmsBuilder();
        }

        public SmsBuilder withId(SmsId id) {
            this.id = id;
            return this;
        }

        public SmsBuilder withInfo(SmsInfo info) {
            this.info = info;
            return this;
        }

        public SmsBuilder withPolicy(DeliveryPolicy policy) {
            this.policy = policy;
            return this;
        }

        public SmsBuilder withStatus(SmsStatus status) {
            this.status = status;
            return this;
        }

        public Sms build() {
            return new Sms(id, info, policy, status);
        }
    }
}
