package ru.drudenko.sms.api;

import java.time.Period;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class DeliveryPolicy {
    private final short maxAttemptCount;
    private final Period period;

    private DeliveryPolicy(short maxAttemptCount, Period period) {
        this.maxAttemptCount = maxAttemptCount;
        this.period = period;
    }

    public short getMaxAttemptCount() {
        return maxAttemptCount;
    }

    public Period getPeriod() {
        return period;
    }


    public static final class DeliveryPolicyBuilder {
        private short maxAttemptCount;
        private Period period;

        private DeliveryPolicyBuilder() {
        }

        public static DeliveryPolicyBuilder aDeliveryPolicy() {
            return new DeliveryPolicyBuilder();
        }

        public DeliveryPolicyBuilder withMaxAttemptCount(short maxAttemptCount) {
            this.maxAttemptCount = maxAttemptCount;
            return this;
        }

        public DeliveryPolicyBuilder withPeriod(Period period) {
            this.period = period;
            return this;
        }

        public DeliveryPolicy build() {
            return new DeliveryPolicy(maxAttemptCount, period);
        }
    }
}
