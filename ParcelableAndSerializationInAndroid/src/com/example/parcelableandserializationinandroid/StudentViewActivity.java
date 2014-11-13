package com.example.parcelableandserializationinandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

public class StudentViewActivity extends Activity{

	TextView mTvSName;
	TextView mTvSAge;
	TextView mTvSAddress;
	TextView mTvSCourse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student);

		StudentParcelable student = null;
		StudentSerializable student1 = null;
		// Fetching data from a parcelable object passed from MainActivity
		//NOTE: Here the createFromParcel method of the "Parcelable.Creator<Student>" is invoked here
		if(getIntent().getParcelableExtra("student")!=null){
			student = getIntent().getParcelableExtra("student");
		}else{
			student1 = (StudentSerializable)getIntent().getSerializableExtra("Key"); 

		}
		// Getting reference to TextView tv_sname of the layout file activity_student
		mTvSName = (TextView)findViewById(R.id.tv_sname);

		// Getting reference to TextView tv_sage of the layout file activity_student
		mTvSAge = (TextView) findViewById(R.id.tv_sage);

		// Getting reference to TextView tv_saddress of the layout file activity_student
		mTvSAddress = (TextView) findViewById(R.id.tv_saddress);

		// Getting reference to TextView tv_scourse of the layout file activity_student
		mTvSCourse = (TextView) findViewById(R.id.tv_scourse);

		if(student!=null){
			mTvSName.setText("Name:"+student.mSName);
			mTvSAge.setText("Age:"+Integer.toString(student.mSAge));
			mTvSAddress.setText("Address:"+student.mSAddress);
			mTvSCourse.setText("Course:"+student.mSCourse);
		}else{
			mTvSName.setText("Name:"+student1.getName());
			mTvSAge.setText("Age:"+student1.getAge());
			mTvSAddress.setText("Address:"+student1.getAddress());
			mTvSCourse.setText("Course:"+student1.getCourse());
		}
	}
}
