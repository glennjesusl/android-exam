package com.glim.upraxisexam.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListingModel {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public ListingModel withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("profileImage")
        @Expose
        private String profileImage;
        @SerializedName("urlDetails")
        @Expose
        private String urlDetails;
        @SerializedName("phoneNumber")
        @Expose
        private String phoneNumber;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Datum withId(Integer id) {
            this.id = id;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Datum withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Datum withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Datum withEmail(String email) {
            this.email = email;
            return this;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public Datum withProfileImage(String profileImage) {
            this.profileImage = profileImage;
            return this;
        }

        public String getUrlDetails() {
            return urlDetails;
        }

        public void setUrlDetails(String urlDetails) {
            this.urlDetails = urlDetails;
        }

        public Datum withUrlDetails(String urlDetails) {
            this.urlDetails = urlDetails;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Datum withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

    }

}