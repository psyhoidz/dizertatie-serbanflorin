package com.android1.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class android1 extends Activity {
    /** Called when the activity is first created. */
    
    long m_dwSplashTime = 9000;
    boolean m_bPaused = false;
    boolean m_bSplashActive = true;
    
    
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);
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
    protected void onPause()
    {
    	super.onPause();
    	m_bPaused = true;
    }
    protected void onResume()
    {
    	super.onResume();
    	m_bPaused = false;
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
    	super.onKeyDown(keyCode, event);
    	m_bSplashActive = false;
    	return true;
    }
    protected void onStop()
    {
    	super.onStop();
    }
    protected void onDestroy()
    {
    	super.onDestroy();
    }
}
    
