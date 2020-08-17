package com.glim.upraxisexam.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailModel {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public DetailModel withData(List<Datum> data) {
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
        @SerializedName("birthDate")
        @Expose
        private String birthDate;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("profileImage")
        @Expose
        private String profileImage;
        @SerializedName("address")
        @Expose
        private Address address;
        @SerializedName("phoneNumber")
        @Expose
        private String phoneNumber;
        @SerializedName("contactsName")
        @Expose
        private String contactsName;
        @SerializedName("contactsNumber")
        @Expose
        private String contactsNumber;

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

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public Datum withBirthDate(String birthDate) {
            this.birthDate = birthDate;
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

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Datum withAddress(Address address) {
            this.address = address;
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

        public String getContactsName() {
            return contactsName;
        }

        public void setContactsName(String contactsName) {
            this.contactsName = contactsName;
        }

        public Datum withContactsName(String contactsName) {
            this.contactsName = contactsName;
            return this;
        }

        public String getContactsNumber() {
            return contactsNumber;
        }

        public void setContactsNumber(String contactsNumber) {
            this.contactsNumber = contactsNumber;
        }

        public Datum withContactsNumber(String contactsNumber) {
            this.contactsNumber = contactsNumber;
            return this;
        }

    }

    public class Address {

        @SerializedName("street")
        @Expose
        private String street;
        @SerializedName("suite")
        @Expose
        private String suite;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("zipcode")
        @Expose
        private String zipcode;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public Address withStreet(String street) {
            this.street = street;
            return this;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public Address withSuite(String suite) {
            this.suite = suite;
            return this;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Address withCity(String city) {
            this.city = city;
            return this;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Address withZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

    }
}