package ru.drudenko.sms.api;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
public class SmsInfo {
    private final String to;
    private final String from;
    private final String text;

    private SmsInfo(String to, String from, String text) {
        this.to = to;
        this.from = from;
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }


    public static final class SmsInfoBuilder {
        private String to;
        private String from;
        private String text;

        private SmsInfoBuilder() {
        }

        public static SmsInfoBuilder aSmsInfo() {
            return new SmsInfoBuilder();
        }

        public SmsInfoBuilder withTo(String to) {
            this.to = to;
            return this;
        }

        public SmsInfoBuilder withFrom(String from) {
            this.from = from;
            return this;
        }

        public SmsInfoBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public SmsInfo build() {
            return new SmsInfo(to, from, text);
        }
    }
}
