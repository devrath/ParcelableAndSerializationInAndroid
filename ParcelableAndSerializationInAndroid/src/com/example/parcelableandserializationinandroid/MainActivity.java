package com.example.parcelableandserializationinandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
 
    EditText mEtSName, mEtSAge, mEtSAddress, mEtSCourse;
    Button mBtnOk, btn_ok1;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        mEtSName = (EditText)findViewById(R.id.et_sname);
        mEtSAge = (EditText)findViewById(R.id.et_sage);
        mEtSAddress = (EditText)findViewById(R.id.et_saddress);
        mEtSCourse = (EditText)findViewById(R.id.et_scource);
        mBtnOk = (Button)findViewById(R.id.btn_ok);
        btn_ok1 = (Button)findViewById(R.id.btn_ok1);

        // Setting onClick event listener for the "OK" button
        mBtnOk.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
 
                // Creating an instance of Student class with user input data
            	//Constructor gets invoked here
                StudentParcelable student = new StudentParcelable(
						                		mEtSName.getText().toString(),
						                		Integer.parseInt(mEtSAge.getText().toString()),
						                		mEtSAddress.getText().toString(),
						                		mEtSCourse.getText().toString()
						                	 );
 
                // Creating an intent to open the activity StudentViewActivity
                Intent intent = new Intent(getBaseContext(), StudentViewActivity.class);
 
                // Passing data as a parecelable object to StudentViewActivity
                // NOTE: Notice We are not passing Primitive variables instead we are passing Java-Object(student) 
                intent.putExtra("student",student);
 
                //NOTE: Before opening the Next activity Here the writeToParcel(of parcelable interface is invoked here)
                // Opening the activity
                startActivity(intent);
            }
        });
        
        
        btn_ok1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
				StudentSerializable mStudent = new StudentSerializable();  
				mStudent.setName(mEtSName.getText().toString());  
				mStudent.setAge(Integer.parseInt(mEtSAge.getText().toString())); 
				mStudent.setAddress(mEtSAddress.getText().toString());  
				mStudent.setCourse(mEtSCourse.getText().toString());  

		        Intent mIntent = new Intent(getBaseContext(),StudentViewActivity.class);  
		        Bundle mBundle = new Bundle();  
		        mBundle.putSerializable("Key",mStudent);  
		        mIntent.putExtras(mBundle);  

		        startActivity(mIntent); 
				
				
			}
		});
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}