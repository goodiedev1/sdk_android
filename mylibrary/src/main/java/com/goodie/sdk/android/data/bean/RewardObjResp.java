package com.goodie.sdk.android.data.bean;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class RewardObjResp {

    @SerializedName("rewardId")
    private String rewardId;

    @SerializedName("rewardName")
    private String rewardName;

    @SerializedName("description")
    private String description;

    @SerializedName("termAndCondition")
    private String termAndCondition;

    @SerializedName("requiredPoint")
    private Integer requiredPoint;

    @SerializedName("expiredDate")
    private String expiredDate;

    @SerializedName("productName")
    private String productName;

    @SerializedName("productImage")
    private String productImage;

    @SerializedName("productType")
    private String productType;

    @SerializedName("amountValue")
    private BigDecimal amountValue;

    @SerializedName("percentageValue")
    private Integer percentageValue;

    @SerializedName("stock")
    private Integer stock;

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTermAndCondition() {
        return termAndCondition;
    }

    public void setTermAndCondition(String termAndCondition) {
        this.termAndCondition = termAndCondition;
    }

    public Integer getRequiredPoint() {
        return requiredPoint;
    }

    public void setRequiredPoint(Integer requiredPoint) {
        this.requiredPoint = requiredPoint;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(BigDecimal amountValue) {
        this.amountValue = amountValue;
    }

    public Integer getPercentageValue() {
        return percentageValue;
    }

    public void setPercentageValue(Integer percentageValue) {
        this.percentageValue = percentageValue;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
