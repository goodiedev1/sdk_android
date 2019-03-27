package com.goodie.sdk.android.data.bean;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class VoucherBalanceResp {

    @SerializedName("voucherBalanceId")
    private String voucherBalanceId;

    @SerializedName("productName")
    private String productName;

    @SerializedName("productImage")
    private String productImage;

    @SerializedName("voucherId")
    private String voucherId;

    @SerializedName("voucherCode")
    private String voucherCode;

    @SerializedName("amountValue")
    private BigDecimal amountValue;

    @SerializedName("percentageValue")
    private Integer percentageValue;

    @SerializedName("expiredDate")
    private String expiredDate;

    @SerializedName("redeemDate")
    private String redeemDate;

    @SerializedName("redeemStore")
    private String redeemStore;

    @SerializedName("status")
    private String status;


    public String getVoucherBalanceId() {
        return voucherBalanceId;
    }

    public void setVoucherBalanceId(String voucherBalanceId) {
        this.voucherBalanceId = voucherBalanceId;
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

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
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

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(String redeemDate) {
        this.redeemDate = redeemDate;
    }

    public String getRedeemStore() {
        return redeemStore;
    }

    public void setRedeemStore(String redeemStore) {
        this.redeemStore = redeemStore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
