package com.tesobe.obp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

@NoArgsConstructor @AllArgsConstructor
@Data
public class TransactionRequest {

    private DestAccount to;

    @JsonDeserialize(using = MoneyJson.MoneyDeserializer.class)
    @JsonSerialize(using = MoneyJson.MoneySerializer.class)
    private Money value;

    private String description;

    public DestAccount getTo() {
        return to;
    }

    public void setTo(DestAccount to) {
        this.to = to;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Data
    @NoArgsConstructor @AllArgsConstructor
    public static class DestAccount {
        @JsonProperty("bank_id")
        private String bankId;

        @JsonProperty("account_id")
        private String accountId;

        public String getBankId() {
            return bankId;
        }

        public void setBankId(String bankId) {
            this.bankId = bankId;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
    }

}
