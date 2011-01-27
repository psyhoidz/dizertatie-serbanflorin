package com.android4.classes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

public class android4ex4 extends Activity {
    /** Called when the activity is first created. */
    
	OnFocusChangeListener focusListener = new OnFocusChangeListener()
	{
		public void onFocusChange(View v, boolean hasFocus)
		{
			adjustTextColor(v, hasFocus);
		}
	};
	public void adjustTextColor(View v, boolean hasFocus)
	{
		TextView t = (TextView) v;
		if(hasFocus)
			t.setTextColor(Color.RED);
		else
			t.setTextColor(Color.WHITE);
	}
	OnClickListener clickListener = new OnClickListener()
	{
		public void onClick(View v)
		{
			String text = "You selected Item: ";
			switch(v.getId())
			{
			case 1:
				text+="one";
				startActivity(new Intent(android4ex4.this, android4ex4.class));
				break;
			case 2:
				text+="two";
				startActivity(new Intent("com.android4.classes.CUSTOM_VIEW"));
				break;
			case 3:
				text+="three";
				break;
			}
			//status.setText(text);
		}
	};
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(R.drawable.general_bg);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
        setContentView(layout);
        
        TextView title = new TextView(this);
        title.setText(R.string.man_menu_title);
        title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        title.setGravity(Gravity.CENTER);
        
        layout.addView(title);
        
        TextView ItemOne = new TextView(this);
        ItemOne.setFocusable(true);
        ItemOne.setText("Login Screen");
        ItemOne.setTextColor(Color.WHITE);
        ItemOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        ItemOne.setId(1);
        ItemOne.setOnFocusChangeListener(focusListener);
        ItemOne.setOnClickListener(clickListener);
        
        layout.addView(ItemOne);
        
        TextView ItemOne2 = new TextView(this);
        ItemOne2.setFocusable(true);
        ItemOne2.setText("Login Screen2");
        ItemOne2.setTextColor(Color.WHITE);
        ItemOne2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        ItemOne2.setId(2);
        ItemOne2.setOnFocusChangeListener(focusListener);
        ItemOne2.setOnClickListener(clickListener);
        
        layout.addView(ItemOne2);
        
        TextView ItemOne3 = new TextView(this);
        ItemOne3.setFocusable(true);
        ItemOne3.setText("Login Screen3");
        ItemOne3.setTextColor(Color.WHITE);
        ItemOne3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        ItemOne3.setId(3);
        ItemOne3.setOnFocusChangeListener(focusListener);
        ItemOne3.setOnClickListener(clickListener);
        
        layout.addView(ItemOne3);
        
      
        
        }
}