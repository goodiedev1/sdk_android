package com.goodie.sdk.android.data.response;

import com.google.gson.annotations.SerializedName;

public class MemberProfileResponse extends AbstractResponse {

    @SerializedName("memberId")
    private String memberId;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("userName")
    private String userName;

    @SerializedName("memberPicture")
    private String memberPicture;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private String city;

    @SerializedName("province")
    private String province;

    @SerializedName("country")
    private String country;

    @SerializedName("postalCode")
    private String postalCode;

    @SerializedName("placeOfBirth")
    private String placeOfBirth;

    @SerializedName("birthDate")
    private String birthDate;

    @SerializedName("gender")
    private String gender;

    @SerializedName("mobilePhone")
    private String mobilePhone;

    @SerializedName("email")
    private String email;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMemberPicture() {
        return memberPicture;
    }

    public void setMemberPicture(String memberPicture) {
        this.memberPicture = memberPicture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
