package com.tesobe.obp.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.joda.money.Money;

@Data
public class TransactionRequestType {
    private String value;
    private Charge charge;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    @Data
    class Charge {
        private String summary;
        private ChargeValue value;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public ChargeValue getValue() {
            return value;
        }

        public void setValue(ChargeValue value) {
            this.value = value;
        }
    }

    @Data
    static class ChargeValue {
        private String currency;

        @JsonDeserialize(using = MoneyJson.MoneyDeserializer.class)
        private Money value;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Money getValue() {
            return value;
        }

        public void setValue(Money value) {
            this.value = value;
        }
    }
}
