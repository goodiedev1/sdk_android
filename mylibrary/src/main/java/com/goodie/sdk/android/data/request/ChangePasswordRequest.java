package com.goodie.sdk.android.data.request;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordRequest{

	@SerializedName("password")
	private String password;

	@SerializedName("merchantId")
	private String merchantId;

	@SerializedName("passwordOld")
	private String passwordOld;

	@SerializedName("confirmPassword")
	private String confirmPassword;

	@SerializedName("memberId")
	private String memberId;

	@SerializedName("username")
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public void setPasswordOld(String passwordOld){
		this.passwordOld = passwordOld;
	}

	public String getPasswordOld(){
		return passwordOld;
	}

	public void setConfirmPassword(String confirmPassword){
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword(){
		return confirmPassword;
	}

	public void setMemberId(String memberId){
		this.memberId = memberId;
	}

	public String getMemberId(){
		return memberId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"ChangePasswordRequest{" + 
			"password = '" + password + '\'' + 
			",merchantId = '" + merchantId + '\'' + 
			",passwordOld = '" + passwordOld + '\'' + 
			",confirmPassword = '" + confirmPassword + '\'' + 
			",memberId = '" + memberId + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}