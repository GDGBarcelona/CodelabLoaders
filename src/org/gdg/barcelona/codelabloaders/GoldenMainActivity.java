package org.gdg.barcelona.codelabloaders;

import org.gdg.barcelona.codelabloaders.golden.GoldenFragment;

import android.os.Bundle;

public class GoldenMainActivity extends BaseActivity
{
	@Override
	protected void onCreate(Bundle _savedInstanceState) 
	{
		super.onCreate(_savedInstanceState);
		addFragment(new GoldenFragment());
	}
}
