package com.goodie.sdk.android.data.bean;

import com.google.gson.annotations.SerializedName;

public class UpdateMemberProfileResp{

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("gender")
	private String gender;

	@SerializedName("birthDate")
	private String birthDate;

	@SerializedName("memberId")
	private String memberId;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}

	public String getBirthDate(){
		return birthDate;
	}

	public void setMemberId(String memberId){
		this.memberId = memberId;
	}

	public String getMemberId(){
		return memberId;
	}

	@Override
 	public String toString(){
		return 
			"UpdateMemberProfileResp{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",gender = '" + gender + '\'' + 
			",birthDate = '" + birthDate + '\'' + 
			",memberId = '" + memberId + '\'' + 
			"}";
		}
}