package com.goodie.sdk.android.data.bean;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by goodiemac1 on 26/04/19.
 */
public class IssuingResp {

    @SerializedName("date")
    private String date;

    @SerializedName("promotionName")
    private String promotionName;

    @SerializedName("ruleType")
    private String ruleType;

    @SerializedName("ruleName")
    private String ruleName;

    @SerializedName("description")
    private String description;

    @SerializedName("reff")
    private String reff;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("point")
    private Integer point;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReff() {
        return reff;
    }

    public void setReff(String reff) {
        this.reff = reff;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
