package com.android1.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class MainMenu extends Activity{
	 long m_dwSplashTime = 9000;
	 boolean m_bPaused = false;
	 boolean m_bSplashActive = true;
	 
	 public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	      
	        setContentView(R.layout.main);
	        Thread splashTimer = new Thread()
	        {
	        	public void run()
	        	{
	        		try
	        		{
	        			long ms = 0;
	        			while (m_bSplashActive && ms < m_dwSplashTime)
	        			{
	        				sleep(100);
	        				
	        				if(!m_bPaused)
	        					ms+=100;
	        			}
	        			startActivity(new Intent("com.google.splashy.CLEARSPLASH"));
	        		}
	        		catch(Exception e)
	        		{
	        			Log.e("Splash",e.toString());
	        		}
	        		finally
	        		{
	        			finish();
	        		}
	        		}
	        	};
	        	splashTimer.start();
	    }
}
