package com.goodie.sdk.android;
import android.app.Application;
import android.support.annotation.RestrictTo;
import com.goodie.sdk.android.Util.Constant;
import com.goodie.sdk.android.data.bean.BasicRulesReq;
import com.goodie.sdk.android.data.bean.CustomRulesReq;
import com.goodie.sdk.android.data.bean.RewardsReq;
import com.goodie.sdk.android.data.builder.ChangePasswordBuilder;
import com.goodie.sdk.android.data.builder.ListPointTransactionBuilder;
import com.goodie.sdk.android.data.builder.LoginBuilder;
import com.goodie.sdk.android.data.builder.MemberPointBuilder;
import com.goodie.sdk.android.data.builder.MemberProfileBuilder;
import com.goodie.sdk.android.data.builder.PromotionInquiryBasicBuilder;
import com.goodie.sdk.android.data.builder.PromotionInquiryBuilder;
import com.goodie.sdk.android.data.builder.PromotionInquiryCustomByAmountBuilder;
import com.goodie.sdk.android.data.builder.PromotionInquiryCustomIssuingBuilder;
import com.goodie.sdk.android.data.builder.PromotionPostingBasicBuilder;
import com.goodie.sdk.android.data.builder.PromotionPostingBuilder;
import com.goodie.sdk.android.data.builder.PromotionPostingCustomByAmountBuilder;
import com.goodie.sdk.android.data.builder.PromotionPostingCustomIssuingBuilder;
import com.goodie.sdk.android.data.builder.RegisterBuilder;
import com.goodie.sdk.android.data.builder.RewardListBuilder;
import com.goodie.sdk.android.data.builder.RewardRedeemptionBuilder;
import com.goodie.sdk.android.data.builder.UpdateMemberProfileBuilder;
import com.goodie.sdk.android.data.builder.VerificationBuilder;
import com.goodie.sdk.android.data.builder.VoucherBalanceBuilder;
import com.goodie.sdk.android.data.builder.VoucherUsageBuilder;
import com.goodie.sdk.android.data.config.GoodieConfig;
import com.goodie.sdk.android.data.response.VoucherBalanceResponse;

import java.util.List;

/**
 * Created by asep.surahman on 07/01/2019.
 */

public class Goodie{

    private static GoodieConfig goodieConfig;
    private Goodie(){
    }

    public static void init(Application application, String qiscusAppId){
        initWithCustomServer(application, qiscusAppId, "");
    }

    //login goodie
    public static LoginBuilder setLogin(String deviceUniqId, String userEmail, String password, String merchantCode){
        return GoodieCore.setLoginUser(deviceUniqId, userEmail, password, merchantCode);
    }

    //register goodie
    public static RegisterBuilder setRegister(String username, String merchantId, String phoneNumber,
                                              String password, String firstName, String lastName,
                                              String deviceUniqId,
                                              String birthDate, String referralCode){
        return GoodieCore.setRegisterUser(username, merchantId, phoneNumber, password, firstName, lastName, deviceUniqId, birthDate, referralCode);
    }

    //verification goodie
    public static VerificationBuilder setVerification(String username, String merchantId, String verificationCode){
        return GoodieCore.setVerificationUser(username, merchantId, verificationCode);
    }

    //memberpoint goodie
    public static MemberPointBuilder setMemberPoint(String authToken, String deviceUniqId, String memberId, String merchantId){
        return GoodieCore.setMemberPointBuilder(authToken, deviceUniqId, memberId, merchantId);
    }

    //promotion inquiry goodie all type (MIX)
    public static PromotionInquiryBuilder setPromotionMixInquiry(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                              BasicRulesReq basicRulesReq,
                                                              List<CustomRulesReq> customRulesReqs){
        return GoodieCore.setPromotionInquiryBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, basicRulesReq, customRulesReqs);
    }

    //promotion inquiry basic goodie
    public static PromotionInquiryBasicBuilder setPromotionInquiryBasic(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                        String productCode, String refNumber, Double totalTrxAmount){
        return GoodieCore.setPromotionInqBasicBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, productCode, refNumber, totalTrxAmount);
    }


    //promotion inquiry custom Issuing
    public static PromotionInquiryCustomIssuingBuilder setPromotionInquiryIssuing(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                                String ruleName, String ref){
        return GoodieCore.setPromotionInqCustomIssuingBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, ruleName, Constant.ISSUING_TYPE, 0, ref);
    }


    //promotion inquiry custom by Amount
    public static PromotionInquiryCustomByAmountBuilder setPromotionInquiryByAmount(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                                   String ruleName, int amount, String ref){
        return GoodieCore.setPromotionInqCustomByAmountBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, ruleName, Constant.AMOUNT_TYPE, amount, ref);
    }



    //promotion posting basic goodie
    public static PromotionPostingBasicBuilder setPromotionPostingBasic(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                        String productCode, String refNumber, Double totalTrxAmount){
        return GoodieCore.setPromotionPostBasicBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, productCode, refNumber, totalTrxAmount);
    }


    //promotion posting custom Issuing
    public static PromotionPostingCustomIssuingBuilder setPromotionPostingIssuing(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                                  String ruleName, String ref){
        return GoodieCore.setPromotionPostCustomIssuingBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, ruleName, Constant.ISSUING_TYPE, 0, ref);
    }

    //promotion posting custom by Amount
    public static PromotionPostingCustomByAmountBuilder setPromotionPostingByAmount(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                                    String ruleName, int amount, String ref){
        return GoodieCore.setPromotionPostCustomByAmountBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, ruleName, Constant.AMOUNT_TYPE, amount, ref);
    }


    //promotion posting goodie all type
    public static PromotionPostingBuilder setPromotionPosting(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                              BasicRulesReq basicRulesReq,
                                                              List<CustomRulesReq> customRulesReqs){
        return GoodieCore.setPromotionPostingBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, basicRulesReq, customRulesReqs);
    }


    //voucher usage
    public static VoucherUsageBuilder setVoucherRedeem(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                          String voucherBalanceId){
        return GoodieCore.setVoucherUsageBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, voucherBalanceId);
    }


    //redeem reward
    public static RewardRedeemptionBuilder setRewardRedeem(String authToken, String deviceUniqId, String memberId, String merchantId, List<RewardsReq> listReward){
        return GoodieCore.setRewardRedeemptionBuilder(authToken, deviceUniqId, memberId, merchantId, listReward);
    }


    //redeem reward
    public static RewardListBuilder setRewardList(String authToken, String deviceUniqId, String keyword, String rewardId,
                                                  String memberId, String merchantId, int orderBy, int orderType, int nRecords, int page){
        return GoodieCore.setRewardListBuilder(authToken, deviceUniqId, keyword, rewardId, memberId, merchantId, orderBy, orderType, nRecords, page);
    }


    //memberprofile goodie
    public static MemberProfileBuilder setMemberProfile(String authToken, String deviceUniqId, String memberId, String merchantId){
        return GoodieCore.setMemberProfileBuilder(authToken, deviceUniqId, memberId, merchantId);
    }


    //voucher balance
    public static VoucherBalanceBuilder setVoucherBalance(String authToken, String deviceUniqId, String voucherbalanceId, String memberId, String merchantId, int orderBy, int orderType, int nRecords, int page){
        return GoodieCore.setVoucherBalanceBuilder(authToken, deviceUniqId, voucherbalanceId, memberId, merchantId, orderBy, orderType, nRecords, page);
    }

    //LIST POINT TRANSACTION
    public static ListPointTransactionBuilder setListPointTransaction(String authToken, String deviceUniqueId, String memberId, String merchantId,
                                                                      int trxType, int orderBy, int orderType, int nRecords, int page) {
        return GoodieCore.setListPointTransactionBuilder(authToken, deviceUniqueId, memberId, merchantId, trxType, orderBy, orderType, nRecords, page);
    }

    // UPDATE MEMBER PROFILE
    public static UpdateMemberProfileBuilder setUpdateMemberProfile(String authToken, String deviceUniqueId, String memberId, String merchantId,
                                                                    String birthDate, String firstName, String lastName, String gender, String phoneNumber) {
        return GoodieCore.setUpdateMemberProfileBuilder(authToken, deviceUniqueId, memberId, merchantId, birthDate, firstName, lastName, gender, phoneNumber);
    }

    //CHANGE PASSWORD
    public static ChangePasswordBuilder setChangePassword(String authToken, String deviceUniqueId, String memberId, String merchantId, String password,
                                                          String confirmPassword, String passwordOld, String username) {

        return GoodieCore.setChangePasswordBuilder(authToken, deviceUniqueId, memberId, merchantId, password, confirmPassword, passwordOld, username);
    }

    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    public static void initWithCustomServer(Application application, String qiscusAppId, String serverBaseUrl){
        GoodieCore.initWithCustomServer(application, qiscusAppId, serverBaseUrl);
        goodieConfig = new GoodieConfig();
    }

    public static GoodieConfig getConfig(){
        return goodieConfig;
    }

}
