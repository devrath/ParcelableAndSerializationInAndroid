package com.example.parcelableandserializationinandroid;

import android.os.Parcel;
import android.os.Parcelable;


public class StudentParcelable implements Parcelable {

	String mSName;
	int mSAge;
	String mSAddress;
	String mSCourse;

	/**
	 * A constructor that initializes the Student object
	 **/
	public StudentParcelable(String sName, int sAge, String sAddress, String sCourse){
		this.mSName = sName;
		this.mSAge = sAge;
		this.mSAddress = sAddress;
		this.mSCourse = sCourse;
	}

	@Override
	public int describeContents() {
		//Default Method over-ridden from Parcelable interface class
		return 0;
	}

	/**
	 * Storing the Student data to Parcel object
	 **/
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		//Default Method over-ridden from Parcelable interface class
		//Writing the data to Parcel is performed here 
		dest.writeString(mSName);
		dest.writeInt(mSAge);
		dest.writeString(mSAddress);
		dest.writeString(mSCourse);
	}

	/**
	 * Retrieving Student data from Parcel object
	 * This constructor is invoked by the method createFromParcel(Parcel source) of
	 * the object CREATOR
	 **/
	private StudentParcelable(Parcel in){
		//NOTE: This constructor is invoked for reading the data from the parcel
		this.mSName = in.readString();
		this.mSAge = in.readInt();
		this.mSAddress = in.readString();
		this.mSCourse = in.readString();
	}
	
	public static final Parcelable.Creator<StudentParcelable> CREATOR = new Parcelable.Creator<StudentParcelable>() {
		 
        @Override
        public StudentParcelable createFromParcel(Parcel source) {
        	//NOTE: Before returning the parcel constructor Student is invoked that takes the parcel object that it has received 
            return new StudentParcelable(source);
        }
 
        @Override
        public StudentParcelable[] newArray(int size) {
            return new StudentParcelable[size];
        }
    };

}
