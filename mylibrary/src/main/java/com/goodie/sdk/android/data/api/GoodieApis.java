package com.goodie.sdk.android.data.api;
import android.content.Context;
import com.goodie.sdk.android.data.bean.BasicRulesReq;
import com.goodie.sdk.android.data.bean.CustomRulesReq;
import com.goodie.sdk.android.data.bean.RewardsReq;
import com.goodie.sdk.android.data.request.ChangePasswordRequest;
import com.goodie.sdk.android.data.request.LoginRequest;
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
import com.goodie.sdk.android.data.response.ChangePasswordResponse;
import com.goodie.sdk.android.data.response.ListPointTransactionResponse;
import com.goodie.sdk.android.data.response.LoginResponse;
import com.goodie.sdk.android.data.response.MemberPointResponse;
import com.goodie.sdk.android.data.response.MemberProfileResponse;
import com.goodie.sdk.android.data.response.PromoInqBasicResponse;
import com.goodie.sdk.android.data.response.PromotionInquiryResponse;
import com.goodie.sdk.android.data.response.PromotionPostingResponse;
import com.goodie.sdk.android.data.response.RegisterResponse;
import com.goodie.sdk.android.data.response.RewardListResponse;
import com.goodie.sdk.android.data.response.RewardRedemptionResponse;
import com.goodie.sdk.android.data.response.UpdateMemberProfileResponse;
import com.goodie.sdk.android.data.response.VerificationResponse;
import com.goodie.sdk.android.data.response.VoucherBalanceResponse;
import com.goodie.sdk.android.data.response.VoucherUsageResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by asep.surahman on 14/01/2019.
 */

public enum GoodieApis {

    INSTANCE;
    private final Apis api;
    private String baseUrl;

    GoodieApis(){
        baseUrl = "https://dev.goodie.id/api-rest/"; //URL GOODIE
        api = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getCustomClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(Apis.class);
    }

    public static GoodieApis getInstance(){
        return INSTANCE;
    }

    private OkHttpClient getCustomClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor(){
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder requestBuilder = chain.request().newBuilder();
                        //requestBuilder.header("Content-Type", "application/json");
                        return chain.proceed(requestBuilder.build());
                    }
                }
        ).addInterceptor(logging)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        return httpClient;
    }


    public Observable<LoginResponse> doLogin(String deviceUniqId, String username, String password, String merchantCode, Context context){
        return api.login(GoodieModel.setLoginRequest(deviceUniqId, username, password, merchantCode, context));
    }

    public Observable<RegisterResponse> doRegister(String username, String merchantId, String phoneNumber,
                                                   String password, String firstName, String lastName, String deviceUniqId,
                                                   String birthDate, String referralCode, Context context){
        return api.register(GoodieModel.setRegisterRequest(username, merchantId, phoneNumber, password,
                                                    firstName, lastName, deviceUniqId, birthDate, referralCode, context));
    }

    public Observable<VerificationResponse> doVerifation(String username, String code, String merchantId, Context context){
        return api.verification(GoodieModel.setVerificationRequest(username, code, merchantId, context));
    }

    public Observable<MemberPointResponse> doMemberPoint(String authToken, String deviceUniqId, String memberId, String merchantId, Context context) {
        return api.memberPoint(authToken, deviceUniqId, memberId, merchantId);
    }


    //promotion inquiry
    public Observable<PromotionInquiryResponse> doPromotionInquiry(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                   BasicRulesReq basicRulesReq, List<CustomRulesReq> customRulesReq, Context context) {
        return api.promotionInquiry(authToken, deviceUniqId, GoodieModel.setPromotionInquiryRequest(memberId, merchantId, storeId, basicRulesReq, customRulesReq, context));
    }



    public Observable<PromoInqBasicResponse> doPromoInquiryBasic(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                 String productCode, String refNumber, Double totalTrxAmount, Context context) {
        return api.promoInquiryBasic(authToken, deviceUniqId, GoodieModel.setPromoInqBasicRequest(memberId, merchantId, storeId,
                                                                 productCode, refNumber, totalTrxAmount, context));
    }


    public Observable<PromoInqBasicResponse> doPromoPostingCustomIssuing(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                         String roleName, int issuing, int amount, String refNumber, Context context) {
        return api.promoPostingCustomIssuing(authToken, deviceUniqId, GoodieModel.setPromoInqCustomIssuingRequest(memberId, merchantId, storeId,
                roleName, issuing, amount, refNumber, context));
    }


    public Observable<PromoInqBasicResponse> doPromoInquiryCustomByAmount(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                         String roleName, int issuing, int amount, String refNumber, Context context) {
        return api.promoInquiryCustomByAmount(authToken, deviceUniqId, GoodieModel.setPromoInqCustomByAmountRequest(memberId, merchantId, storeId,
                roleName, issuing, amount, refNumber, context));
    }

    //promotion posting
    public Observable<PromoInqBasicResponse> doPromoPostingBasic(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                 String productCode, String refNumber, Double totalTrxAmount, Context context) {
        return api.promoPostingBasic(authToken, deviceUniqId, GoodieModel.setPromoInqBasicRequest(memberId, merchantId, storeId,
                productCode, refNumber, totalTrxAmount, context));
    }

    public Observable<PromoInqBasicResponse> doPromoInquiryCustomIssuing(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                         String roleName, int issuing, int amount, String refNumber, Context context) {
        return api.promoInquiryCustomIssuing(authToken, deviceUniqId, GoodieModel.setPromoInqCustomIssuingRequest(memberId, merchantId, storeId,
                roleName, issuing, amount, refNumber, context));
    }


    public Observable<PromoInqBasicResponse> doPromoPostingCustomByAmount(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                          String roleName, int issuing, int amount, String refNumber, Context context) {
        return api.promoPostingCustomByAmount(authToken, deviceUniqId, GoodieModel.setPromoInqCustomByAmountRequest(memberId, merchantId, storeId,
                roleName, issuing, amount, refNumber, context));
    }

    public Observable<PromotionPostingResponse> doPromotionPosting(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                   BasicRulesReq basicRulesReq, List<CustomRulesReq> customRulesReq, Context context) {
        return api.promotionPosting(authToken, deviceUniqId, GoodieModel.setPromotionPostingRequest(memberId, merchantId, storeId, basicRulesReq, customRulesReq, context));
    }



    public Observable<VoucherUsageResponse> doVoucherUsage(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                   String voucherBalanceId, Context context){
        return api.voucherUsage(authToken, deviceUniqId, GoodieModel.setVoucherUsageRequest(memberId, merchantId, storeId, voucherBalanceId, context));
    }


    public Observable<RewardRedemptionResponse> doRewardRedemtion(String authToken, String deviceUniqId, String memberId, String merchantId, List<RewardsReq> rewardsReqList, Context context) {
        return api.rewardReedem(authToken, deviceUniqId, GoodieModel.setRewardRedeemRequest(memberId, merchantId, rewardsReqList, context));
    }


    public Observable<RewardListResponse> doRewardList(String authToken, String deviceUniqId, String keyword, String rewardId,
                                                       String memberId, String merchantId, int orderBy, int orderType, int nRecords,
                                                       int page, Context context) {
        return api.rewardList(authToken, deviceUniqId, keyword, rewardId, memberId, merchantId, orderBy, orderType, nRecords, page);
    }


    public Observable<MemberProfileResponse> doMemberProfile(String authToken, String deviceUniqId, String memberId, String merchantId, Context context) {
        return api.memberProfile(authToken, deviceUniqId, memberId, merchantId);
    }


    public Observable<VoucherBalanceResponse> doVoucherBalance(String authToken, String deviceUniqId, String voucherBalanceId,
                                                       String memberId, String merchantId, int orderBy, int orderType, int nRecords,
                                                       int page, Context context) {
        return api.voucherBalance(authToken, deviceUniqId, voucherBalanceId, memberId, merchantId, orderBy, orderType, nRecords, page);
    }


    // POINT TRANSACTION HISTORY
    public Observable<ListPointTransactionResponse> getListPointHistory(String authToken, String deviceUniqueId, String memberId, String merchantId,
                                                                        int trxType, int orderBy, int orderType, int nRecords, int page, Context context) {

        return api.listHistory(authToken, deviceUniqueId, memberId, merchantId, trxType, orderBy, orderType, nRecords, page);

    }


    // UPDATE MEMBER PROFILE
    public Observable<UpdateMemberProfileResponse> doUpdateMemberProfile(String authToken, String deviceUniqueId, String memberId, String merchantId,
                                                                         String birthDate, String firstName, String lastName, String gender, String phoneNumber, Context context) {

        return api.updateProfile(authToken, deviceUniqueId, GoodieModel.setUpdateMemberProfileRequest(memberId, merchantId, birthDate,
                                                                                                    firstName, lastName, gender, phoneNumber, context));
    }

    // CHANGE PASSWORD MEMBER
    public Observable<ChangePasswordResponse> doChangePassword(String authToken, String deviceUniqueId, String memberId, String merchantId, String password,
                                                               String confirmPassword, String passwordOld, String username, Context context) {

        return api.changePassword(authToken, deviceUniqueId, GoodieModel.setChangePassword(memberId, merchantId, password,
                                                                                           confirmPassword, passwordOld, username, context));
    }



    public interface Apis {


        @POST("authentication/create")
        Observable<LoginResponse> login(@Body LoginRequest request);

        @POST("member/profile/registration")
        Observable<RegisterResponse> register(@Body RegisterRequest request);


        @POST("member/registration/verification")
        Observable<VerificationResponse> verification(@Body VerificationRequest request);


        @Headers("Content-Type:application/json")
        @POST("promotion/inquiry")
        Observable<PromotionInquiryResponse> promotionInquiry(@Header("authToken")  String authToken,
                                                              @Header("deviceUniqueId")  String deviceUniqId,
                                                              @Body PromotionInquiryRequest request);

        @Headers("Content-Type:application/json")
        @POST("promotion/inquiry")
        Observable<PromoInqBasicResponse> promoInquiryBasic(@Header("authToken")  String authToken,
                                                            @Header("deviceUniqueId")  String deviceUniqId,
                                                            @Body PromoInqBasicRequest request);

        @Headers("Content-Type:application/json")
        @POST("promotion/inquiry")
        Observable<PromoInqBasicResponse> promoInquiryCustomIssuing(@Header("authToken")  String authToken,
                                                                    @Header("deviceUniqueId")  String deviceUniqId,
                                                                    @Body PromoInqCustomIssuingRequest request);

        @Headers("Content-Type:application/json")
        @POST("promotion/inquiry")
        Observable<PromoInqBasicResponse> promoInquiryCustomByAmount(@Header("authToken")  String authToken,
                                                                     @Header("deviceUniqueId")  String deviceUniqId,
                                                                     @Body PromoInqCustomByAmountRequest request);

        @Headers("Content-Type:application/json")
        @POST("promotion/posting")
        Observable<PromoInqBasicResponse> promoPostingBasic(@Header("authToken")  String authToken,
                                                            @Header("deviceUniqueId")  String deviceUniqId,
                                                            @Body PromoInqBasicRequest request);

        @Headers("Content-Type:application/json")
        @POST("promotion/posting")
        Observable<PromoInqBasicResponse> promoPostingCustomIssuing(@Header("authToken")  String authToken,
                                                                    @Header("deviceUniqueId")  String deviceUniqId,
                                                                    @Body PromoInqCustomIssuingRequest request);

        @Headers("Content-Type:application/json")
        @POST("promotion/posting")
        Observable<PromoInqBasicResponse> promoPostingCustomByAmount(@Header("authToken")  String authToken,
                                                                     @Header("deviceUniqueId")  String deviceUniqId,
                                                                     @Body PromoInqCustomByAmountRequest request);
        @Headers("Content-Type:application/json")
        @POST("promotion/posting")
        Observable<PromotionPostingResponse> promotionPosting(@Header("authToken")  String authToken,
                                                              @Header("deviceUniqueId")  String deviceUniqId,
                                                              @Body PromotionPostingRequest request);

        @Headers("Content-Type:application/json")
        @POST("point-transaction/redemption/voucher/redeem")
        Observable<VoucherUsageResponse> voucherUsage(@Header("authToken")  String authToken,
                                                      @Header("deviceUniqueId")  String deviceUniqId,
                                                      @Body VoucherUsageRequest request);


        @Headers("Content-Type:application/json")
        @POST("point-transaction/redemption/reward/redeem")
        Observable<RewardRedemptionResponse> rewardReedem(@Header("authToken")  String authToken,
                                                          @Header("deviceUniqueId")  String deviceUniqId,
                                                          @Body RewardRedeemRequest request);



        @Headers("Content-Type:application/x-www-form-urlencoded")
        @GET("member/points")
        Observable<MemberPointResponse> memberPoint(@Header("authToken")  String authToken,
                                                    @Header("deviceUniqueId")  String deviceUniqId,
                                                    @Query("memberId") String memberId,
                                                    @Query("merchantId") String merchantId
        );

        @Headers("Content-Type:application/x-www-form-urlencoded")
        @GET("point-transaction/redemption/reward")
        Observable<RewardListResponse> rewardList(@Header("authToken")  String authToken,
                                                  @Header("deviceUniqueId")  String deviceUniqId,
                                                  @Query("keyword") String keyword,
                                                  @Query("rewardId") String rewardId,
                                                  @Query("memberId") String memberId,
                                                  @Query("merchantId") String merchantId,
                                                  @Query("orderBy") Integer orderBy,
                                                  @Query("orderType") Integer orderType,
                                                  @Query("nRecords") Integer nRecords,
                                                  @Query("page") Integer page

        );


        @Headers("Content-Type:application/x-www-form-urlencoded")
        @GET("member/profile")
        Observable<MemberProfileResponse> memberProfile(@Header("authToken")  String authToken,
                                                        @Header("deviceUniqueId")  String deviceUniqId,
                                                        @Query("memberId") String memberId,
                                                        @Query("merchantId") String merchantId
        );


        @Headers("Content-Type:application/x-www-form-urlencoded")
        @GET("point-transaction/redemption/voucher")
        Observable<VoucherBalanceResponse> voucherBalance(@Header("authToken")  String authToken,
                                                          @Header("deviceUniqueId")  String deviceUniqId,
                                                          @Query("voucherBalanceId") String rewardId,
                                                          @Query("memberId") String memberId,
                                                          @Query("merchantId") String merchantId,
                                                          @Query("orderBy") Integer orderBy,
                                                          @Query("orderType") Integer orderType,
                                                          @Query("nRecords") Integer nRecords,
                                                          @Query("page") Integer page
        );

        // LIST HISTORY
        @Headers("Content-Type:application/x-www-form-urlencoded")
        @GET("point-transaction/history")
        Observable<ListPointTransactionResponse> listHistory(@Header("authToken")  String authToken,
                                                             @Header("deviceUniqueId")  String deviceUniqId,
                                                             @Query("memberId") String memberId,
                                                             @Query("merchantId") String merchantId,
                                                             @Query("trxType") Integer trxType,
                                                             @Query("orderBy") Integer orderBy,
                                                             @Query("orderType") Integer orderType,
                                                             @Query("nRecords") Integer nRecords,
                                                             @Query("page") Integer page
        );

        //UPDATE MEMBER PROFILE
        @Headers("Content-Type:application/json")
        @POST("member/update/profile")
        Observable<UpdateMemberProfileResponse> updateProfile(@Header("authToken")  String authToken,
                                                             @Header("deviceUniqueId")  String deviceUniqId,
                                                             @Body UpdateMemberProfileRequest request);

        // CHANGE PASSWORD MEMBER
        @Headers("Content-Type:application/json")
        @POST("member/change/password")
        Observable<ChangePasswordResponse> changePassword(@Header("authToken")  String authToken,
                                                              @Header("deviceUniqueId")  String deviceUniqId,
                                                              @Body ChangePasswordRequest request);


    }


}
