package com.example.android.discoverourense;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cristina on 22/06/2017.
 * This class represents a location of the city (place, restaurant or hotel).
 * It contains information about the location, such as the name, address, image and description.
 * This class implements parcelable in order to allow transfer data between activities.
 */

public class Location implements Parcelable {

    private String mTitle, mAddress, mShortDescription, mLongDescription, mPhone, mMail, mWeb,
            mTimetable;
    private String mType = NO_BUSINESS;
    private String mStars = NO_BUSINESS;
    private int mImageResourceId;

    /** Constant value that represents that the location is not a business (nor restaurant,
     * nor hotel) */
    private static final String NO_BUSINESS = "";

    /**
     * Constructor to rebuild object from the Parcel
     * @param source is a parcel data
     */
    public Location(Parcel source) {
        mTitle = source.readString();
        mAddress = source.readString();
        mShortDescription = source.readString();
        mLongDescription = source.readString();
        mPhone = source.readString();
        mMail = source.readString();
        mWeb = source.readString();
        mTimetable = source.readString();
        mType = source.readString();
        mStars = source.readString();
        mImageResourceId = source.readInt();
    }

    /**
     * Create a new Location object, suitable for a Things to do location.
     * @param title is the location name
     * @param shortDescription is a short description of the location
     * @param longDescription is a detailed description of the location
     * @param imageResourceId is the drawable resource ID for the image associated with the location
     */
    public Location (String title, String shortDescription, String longDescription,
                     int imageResourceId) {
        mTitle = title;
        mShortDescription = shortDescription;
        mLongDescription = longDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Location object, suitable for a Places to see location.
     * @param title is the location name
     * @param address is the location address
     * @param shortDescription is a short description of the location
     * @param longDescription is a detailed description of the location
     * @param imageResourceId is the drawable resource ID for the image associated with the location
     */
    public Location (String title, String address, String shortDescription, String longDescription,
                     int imageResourceId) {
        mTitle = title;
        mAddress = address;
        mShortDescription = shortDescription;
        mLongDescription = longDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Location object, suitable for a Where to eat location.
     * @param title is the location name
     * @param address is the location address
     * @param shortDescription is a short description of the location
     * @param phone is the restaurant phone number
     * @param web is the restaurant website
     * @param timetable is the restaurant timetable
     * @param type is the type of restaurant(Bar|Restaurant|Tapas|Galician|Japanese|Grill|Mexican|
     *             Wine|Fast-Food|Italian|Turkish|American)
     * @param imageResourceId is the drawable resource ID for the image associated with the location
     */
    public Location (String title, String address, String shortDescription, String phone,
                     String web, String timetable, String type, int imageResourceId) {
        mTitle = title;
        mAddress = address;
        mShortDescription = shortDescription;
        mPhone = phone;
        mWeb = web;
        mTimetable = timetable;
        mType = type;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Location object, suitable for a Where to sleep location.
     * @param title is the location name
     * @param address is the location address
     * @param shortDescription is a short description of the location
     * @param longDescription is a detailed description of the location
     * @param phone is the hotel phone number
     * @param mail is the hotel mail
     * @param web is the hotel website
     * @param stars is the number of stars of the hotel(1 to 5)
     * @param imageResourceId is the drawable resource ID for the image associated with the location
     */
    public Location (String title, String address, String shortDescription, String longDescription,
                     String phone, String mail, String web, String stars, int imageResourceId) {
        mTitle = title;
        mAddress = address;
        mShortDescription = shortDescription;
        mLongDescription = longDescription;
        mPhone = phone;
        mMail = mail;
        mWeb = web;
        mStars = stars;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the location
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the address of the location
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Get the short description of the location
     */
    public String getShortDescription() {
        return mShortDescription;
    }

    /**
     * Get the long description of the location
     */
    public String getLongDescription() {
        return mLongDescription;
    }

    /**
     * Get the phone number of the location
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * Get the mail of the location
     */
    public String getMail() {
        return mMail;
    }

    /**
     * Get the website of the location
     */
    public String getWeb() {
        return mWeb;
    }

    /**
     * Get the timetable of the location
     */
    public String getTimetable() {
        return mTimetable;
    }

    /**
     * Get the type of restaurant
     */
    public String getType() {
        return mType;
    }

    /**
     * Get the number of stars of the hotel
     */
    public String getStars() {
        return mStars;
    }

    /**
     * Get the image resource ID of the location.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not the location is a restaurant (has type assigned).
     */
    public boolean hasType() {
        return !mType.equals(NO_BUSINESS);
    }

    /**
     * Returns whether or not the location is a hotel (has stars assigned).
     */
    public boolean hasStars() {
        return !mStars.equals(NO_BUSINESS);
    }


    @Override
    public String toString() {
        return "Location{" +
                "mTitle='" + mTitle + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mShortDescription='" + mShortDescription + '\'' +
                ", mLongDescription='" + mLongDescription + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", mMail='" + mMail + '\'' +
                ", mWeb='" + mWeb + '\'' +
                ", mTimetable='" + mTimetable + '\'' +
                ", mType='" + mType + '\'' +
                ", mStars='" + mStars + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }

    /**
     * Describe the kind of special object
     */
    @Override
    public int describeContents() {
        // hashCode() of this class
        return hashCode();
    }

    /**
     * Write this object into a Parcel
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mAddress);
        dest.writeString(mShortDescription);
        dest.writeString(mLongDescription);
        dest.writeString(mPhone);
        dest.writeString(mMail);
        dest.writeString(mWeb);
        dest.writeString(mTimetable);
        dest.writeString(mType);
        dest.writeString(mStars);
        dest.writeInt(mImageResourceId);
    }

    // Parcelable creator
    public static final Parcelable.Creator CREATOR  = new Parcelable.Creator() {
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
