package com.example.parcelableandserializationinandroid;

import java.io.Serializable;

public class StudentSerializable implements Serializable{

	private String mSName;
	private int mSAge;
	private String mSAddress;
	private String mSCourse;

	public String getName() {  
		return mSName;  
	}  
	
	public int getAge() {  
		return mSAge;  
	} 
	
	public String getAddress() {  
		return mSAddress;  
	} 
	
	public String getCourse() {  
		return mSCourse;  
	} 
	
	public void setName(String _mSName) {  
		this.mSName = _mSName;  
	}  
	 
	public void setAge(int _mSAge) {  
		this.mSAge = _mSAge;  
	}  
	
	public void setAddress(String _mSAddress) {  
		this.mSAddress = _mSAddress;  
	}  
	
	public void setCourse(String _mSCourse) {  
		this.mSCourse = _mSCourse;  
	} 

}
