package com.goodie.sdk.android.data.api;
import android.content.Context;
import android.provider.Settings;
import com.goodie.sdk.android.data.bean.BasicRulesReq;
import com.goodie.sdk.android.data.bean.CustomRulesReq;
import com.goodie.sdk.android.data.bean.RewardsReq;
import com.goodie.sdk.android.data.request.ChangePasswordRequest;
import com.goodie.sdk.android.data.request.LoginRequest;
import com.goodie.sdk.android.data.request.MemberPointRequest;
import com.goodie.sdk.android.data.request.PromoInqBasicRequest;
import com.goodie.sdk.android.data.request.PromoInqCustomByAmountRequest;
import com.goodie.sdk.android.data.request.PromoInqCustomIssuingRequest;
import com.goodie.sdk.android.data.request.PromotionInquiryRequest;
import com.goodie.sdk.android.data.request.PromotionPostingRequest;
import com.goodie.sdk.android.data.request.RegisterRequest;
import com.goodie.sdk.android.data.request.RewardRedeemRequest;
import com.goodie.sdk.android.data.request.UpdateMemberProfileRequest;
import com.goodie.sdk.android.data.request.VerificationRequest;
import com.goodie.sdk.android.data.request.VoucherUsageRequest;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goodie on 13/02/2019.
 */

public class GoodieModel {

    //get deviceid
    public static String getDeviceId(Context context){
        String result = "";
        result = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return result;
    }

    //get data login request
    public static LoginRequest setLoginRequest(String deviceUniqId, String username, String password, String merchantId, Context context){
        final String idDevice = getDeviceId(context);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);
        loginRequest.setMerchantId(merchantId);
        loginRequest.setDeviceUniqueId(deviceUniqId);
        return  loginRequest;
    }

    //get data register request
    public static RegisterRequest setRegisterRequest(String username, String merchantId,
                                                     String phoneNumber, String password,
                                                     String firstName, String lastName, String deviceUniqId,
                                                     String birthDate, String referralCode, Context context){
        final String idDevice = getDeviceId(context);
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername(username);
        registerRequest.setMerchantId(merchantId);
        registerRequest.setPhoneNumber(phoneNumber);
        registerRequest.setPassword(password);
        registerRequest.setFirstName(firstName);
        registerRequest.setLastName(lastName);
        registerRequest.setBirthDate(birthDate);
        registerRequest.setReferralCode(referralCode);
        registerRequest.setDeviceUniqueId(deviceUniqId);
        return registerRequest;
    }

    //get data verification request
    public static VerificationRequest setVerificationRequest(String username, String code, String merchantId, Context context){
        VerificationRequest verificationRequest = new VerificationRequest();
        verificationRequest.setUsername(username);
        verificationRequest.setCode(code);
        verificationRequest.setMerchantId(merchantId);
        return  verificationRequest;
    }

    //get data member request
    public static MemberPointRequest setMemberPointRequest(String memberId, String merchantId, Context context){
        MemberPointRequest memberPointRequest = new MemberPointRequest();
        memberPointRequest.setMemberId(memberId);
        memberPointRequest.setMerchantId(merchantId);
        return  memberPointRequest;
    }

    //get data basiq role
    public static BasicRulesReq getBasicRoles(String productCode, String refNumber, Double totalTrxAmount){
        BasicRulesReq basicRulesReq = new BasicRulesReq();
        basicRulesReq.setProductCode(productCode);
        basicRulesReq.setRefNumber(refNumber);
        basicRulesReq.setTotalTrxAmount(totalTrxAmount);
        return  basicRulesReq;
    }

    //get custom Roles
    public static CustomRulesReq getCustomRoles(String ruleName, int issuing, int amount, String refNumber){
        CustomRulesReq customRulesReq = new CustomRulesReq();
        customRulesReq.setRuleName(ruleName);
        customRulesReq.setIssuing(issuing);
        customRulesReq.setAmount(amount);
        customRulesReq.setRefNumber(refNumber);
        return  customRulesReq;
    }


    //promotion inquiry basic
    public static PromoInqBasicRequest setPromoInqBasicRequest(String memberId, String merchantId, String storeId,
                                                               String productCode, String refNumber, Double totalTrxAmount, Context context){
        PromoInqBasicRequest promoInqBasicRequest = new PromoInqBasicRequest();
        promoInqBasicRequest.setMemberId(memberId);
        promoInqBasicRequest.setMerchantId(merchantId);
        promoInqBasicRequest.setStoreId(storeId);
        promoInqBasicRequest.setBasicRulesReq(getBasicRoles(productCode, refNumber, totalTrxAmount));
        return  promoInqBasicRequest;
    }

    //promotion inquiry custom issuing
    public static PromoInqCustomIssuingRequest setPromoInqCustomIssuingRequest(String memberId, String merchantId, String storeId,
                                                                       String roleName, int issuing, int amount, String refNumber, Context context){

        List<CustomRulesReq> customRulesReq = new ArrayList<>();
        CustomRulesReq customRulesReq1 = new CustomRulesReq();
        customRulesReq1.setRuleName(roleName);
        customRulesReq1.setRefNumber(refNumber);
        customRulesReq1.setIssuing(issuing);
        customRulesReq1.setAmount(amount);
        customRulesReq.add(customRulesReq1);

        PromoInqCustomIssuingRequest promoInqCustomIssuingRequest = new PromoInqCustomIssuingRequest();
        promoInqCustomIssuingRequest.setMemberId(memberId);
        promoInqCustomIssuingRequest.setMerchantId(merchantId);
        promoInqCustomIssuingRequest.setStoreId(storeId);
        promoInqCustomIssuingRequest.setCustomRulesReq(customRulesReq);
        return  promoInqCustomIssuingRequest;
    }

    //promotion inquiry custom issuing
    public static PromoInqCustomByAmountRequest setPromoInqCustomByAmountRequest(String memberId, String merchantId, String storeId,
                                                                                String roleName, int issuing, int amount, String refNumber, Context context){

        List<CustomRulesReq> customRulesReq = new ArrayList<>();
        CustomRulesReq customRulesReq1 = new CustomRulesReq();
        customRulesReq1.setRuleName(roleName);
        customRulesReq1.setRefNumber(refNumber);
        customRulesReq1.setIssuing(issuing);
        customRulesReq1.setAmount(amount);
        customRulesReq.add(customRulesReq1);

        PromoInqCustomByAmountRequest promoInqCustomByAmountRequest = new PromoInqCustomByAmountRequest();
        promoInqCustomByAmountRequest.setMemberId(memberId);
        promoInqCustomByAmountRequest.setMerchantId(merchantId);
        promoInqCustomByAmountRequest.setStoreId(storeId);
        promoInqCustomByAmountRequest.setCustomRulesReq(customRulesReq);
        return  promoInqCustomByAmountRequest;
    }


    //promotion inquiry model
    public static PromotionInquiryRequest setPromotionInquiryRequest(String memberId, String merchantId, String storeId,
                                                                  BasicRulesReq basicRulesReq,
                                                                  List<CustomRulesReq> customRulesReq,
                                                                  Context context){
        PromotionInquiryRequest promotionInquiryRequest = new PromotionInquiryRequest();
        promotionInquiryRequest.setMemberId(memberId);
        promotionInquiryRequest.setMerchantId(merchantId);
        promotionInquiryRequest.setStoreId(storeId);
        promotionInquiryRequest.setBasicRulesReq(basicRulesReq);
        promotionInquiryRequest.setCustomRulesReqs(customRulesReq);
        return  promotionInquiryRequest;
    }


    //promotion posting model
    public static PromotionPostingRequest setPromotionPostingRequest(String memberId, String merchantId, String storeId,
                                                                     BasicRulesReq basicRulesReq,
                                                                     List<CustomRulesReq> customRulesReq,
                                                                     Context context){
        PromotionPostingRequest promotionPostingRequest = new PromotionPostingRequest();
        promotionPostingRequest.setMemberId(memberId);
        promotionPostingRequest.setMerchantId(merchantId);
        promotionPostingRequest.setStoreId(storeId);
        promotionPostingRequest.setBasicRulesReq(basicRulesReq);
        promotionPostingRequest.setCustomRulesReqs(customRulesReq);
        return  promotionPostingRequest;
    }



    //voucher usage model
    public static VoucherUsageRequest setVoucherUsageRequest(String memberId, String merchantId, String storeId,
                                                                 String voucherBalanceId,
                                                                 Context context){
        VoucherUsageRequest voucherUsageRequest = new VoucherUsageRequest();
        voucherUsageRequest.setMemberId(memberId);
        voucherUsageRequest.setMerchantId(merchantId);
        voucherUsageRequest.setStoreId(storeId);
        voucherUsageRequest.setVoucherBalanceId(voucherBalanceId);
        return  voucherUsageRequest;
    }




    //reward redeem model
    public static RewardRedeemRequest setRewardRedeemRequest(String memberId, String merchantId,
                                                                 List<RewardsReq> rewardsReqs,
                                                                 Context context){
        RewardRedeemRequest rewardRedeemRequest = new RewardRedeemRequest();
        rewardRedeemRequest.setMemberId(memberId);
        rewardRedeemRequest.setMerchantId(merchantId);
        rewardRedeemRequest.setRewards(rewardsReqs);
        return  rewardRedeemRequest;
    }

    // UPDATE MEMBER PROFILE
    public static UpdateMemberProfileRequest setUpdateMemberProfileRequest(String memberId, String merchantId,
                                                                           String birthDate, String firstName, String lastName,
                                                                           String gender, String phoneNumber, Context context) {
        UpdateMemberProfileRequest updateMemberProfileRequest = new UpdateMemberProfileRequest();
        updateMemberProfileRequest.setBirthDate(birthDate);
        updateMemberProfileRequest.setFirstName(firstName);
        updateMemberProfileRequest.setGender(gender);
        updateMemberProfileRequest.setLastName(lastName);
        updateMemberProfileRequest.setPhoneNumber(phoneNumber);
        updateMemberProfileRequest.setMemberId(memberId);
        updateMemberProfileRequest.setMerchantId(merchantId);

        return updateMemberProfileRequest;
    }

    // CHANGE PASSWORD MEMBER
    public static ChangePasswordRequest setChangePassword(String memberId, String merchantId, String password,
                                                          String confirmPassword, String passwordOld, String username, Context context) {

        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setConfirmPassword(confirmPassword);
        changePasswordRequest.setMemberId(memberId);
        changePasswordRequest.setMerchantId(merchantId);
        changePasswordRequest.setPassword(password);
        changePasswordRequest.setPasswordOld(passwordOld);
        changePasswordRequest.setUsername(username);

        return changePasswordRequest;
    }




}
