package com.stonex.bean;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "currencycode")
public class CurrencyDetails {
    @MongoId
    @Field(name = "_id")
    private String id;
    @Field(name = "modification_flag")
    private String modificationFlag;
    @Field(name = "currency_code")
    private String currencyCode;
    @Field(name = "currency_name")
    private String currencyName;
    @Field(name = "fractional_digit")
    private String fractionalDigit;
    @Field(name = "country_code")
    private String countryCode;
    @Field(name = "country_name")
    private String countryName;

    public CurrencyDetails(String id, String modificationFlag, String currencyCode, String currencyName, String fractionalDigit, String countryCode, String countryName) {
        this.id = id;
        this.modificationFlag = modificationFlag;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.fractionalDigit = fractionalDigit;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModificationFlag() {
        return modificationFlag;
    }

    public void setModificationFlag(String modificationFlag) {
        this.modificationFlag = modificationFlag;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getFractionalDigit() {
        return fractionalDigit;
    }

    public void setFractionalDigit(String fractionalDigit) {
        this.fractionalDigit = fractionalDigit;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "CurrencyDetails{" +
                "id='" + id + '\'' +
                ", modificationFlag='" + modificationFlag + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", fractionalDigit='" + fractionalDigit + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}