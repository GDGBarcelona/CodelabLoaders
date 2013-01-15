package org.gdg.barcelona.codelabloaders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity 
{
	@Override
	protected void onCreate(Bundle _savedInstanceState) 
	{
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	protected void addFragment(Fragment _fragment)
	{
		getSupportFragmentManager().
			beginTransaction().
				add(R.id.activity_main_framelayout, _fragment).
				commit();
	}
}
