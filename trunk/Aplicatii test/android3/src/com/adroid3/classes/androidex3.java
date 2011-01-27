package com.adroid3.classes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class androidex3 extends Activity {
    /** Called when the activity is first created. */
    Button btn = null;
    private OnClickListener buttonListener = new OnClickListener()
    {
 
    	public void grabEnteredText()
    	{
    		TextView status = (TextView) findViewById(R.id.status);
    		EditText username = (EditText) findViewById(R.id.username);
    		EditText pwd = (EditText) findViewById(R.id.password);
    		
    		String usrTxt = username.getText().toString();
    		String pwdTxt = pwd.getText().toString();
    		
    		status.setText("Login " + usrTxt + " : " + pwdTxt);
    		//this.showAlert("Login Data", 0 , "Login" + usrTxt + " : " + pwdTxt, "ok!", false);
    	}
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			grabEnteredText();
		}
    };
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (Button) findViewById(R.id.loginbutton);
        btn.setOnClickListener(buttonListener);
    }
}