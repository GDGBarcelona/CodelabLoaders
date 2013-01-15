package org.gdg.barcelona.codelabloaders.silver;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.widget.ArrayAdapter;

public class SilverFragment extends ListFragment 
{
	private static final int		LOADER_ID	= 0;
	
	private ArrayAdapter<String>	mAdapter	= null;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
		setListAdapter(mAdapter);
		
		getLoaderManager().initLoader(LOADER_ID, null, new WebLoaderCallback());
	}
	
	private class WebLoaderCallback implements LoaderCallbacks<ArrayList<String>>
	{
		@Override
		public Loader<ArrayList<String>> onCreateLoader(int _id, Bundle _args)
		{
			return new WebServiceLoader(getActivity());
		}

		@Override
		public void onLoadFinished(Loader<ArrayList<String>> _loader, ArrayList<String> _list)
		{
			mAdapter.clear();
			for(String name : _list)
			{
				mAdapter.add(name);
			}
			mAdapter.notifyDataSetChanged();
		}

		@Override
		public void onLoaderReset(Loader<ArrayList<String>> _loader)
		{
			mAdapter.clear();
			mAdapter.notifyDataSetChanged();
		}
	}
}
