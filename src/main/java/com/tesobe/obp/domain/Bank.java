package com.tesobe.obp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tesobe.obp.clientapi.ObpBankMetaApiClient;
import lombok.Data;

import java.util.List;

@Data
public class Bank {

    private String id;

    @JsonProperty("short_name")
    private String shortName;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("logo_URL")
    private String logoUrl;

    private String website;

    private List<Branch> branches;

    private List<ObpBankMetaApiClient.ATMs> atms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<ObpBankMetaApiClient.ATMs> getAtms() {
        return atms;
    }

    public void setAtms(List<ObpBankMetaApiClient.ATMs> atms) {
        this.atms = atms;
    }
}
