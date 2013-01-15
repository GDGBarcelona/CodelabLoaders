package org.gdg.barcelona.codelabloaders;

import org.gdg.barcelona.codelabloaders.silver.SilverFragment;

import android.os.Bundle;

public class SilverMainActivity extends BaseActivity
{
	@Override
	protected void onCreate(Bundle _savedInstanceState) 
	{
		super.onCreate(_savedInstanceState);
		addFragment(new SilverFragment());
	}
}
