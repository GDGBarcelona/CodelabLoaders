package org.gdg.barcelona.codelabloaders;

import org.gdg.barcelona.codelabloaders.copper.CopperFragment;

import android.os.Bundle;

public class CopperMainActivity extends BaseActivity 
{
	@Override
	protected void onCreate(Bundle _savedInstanceState) 
	{
		super.onCreate(_savedInstanceState);
		addFragment(new CopperFragment());
	}
}
