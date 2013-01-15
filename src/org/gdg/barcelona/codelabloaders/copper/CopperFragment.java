package org.gdg.barcelona.codelabloaders.copper;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;

public class CopperFragment extends ListFragment 
{
	private static final String[]	COLUMNS_FROM	= {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
													   ContactsContract.CommonDataKinds.Phone.NUMBER};
	private static final int[]		VIEWS_TO		= {android.R.id.text1, android.R.id.text2};
	private static final int		LOADER_ID		= 0;
	
	private SimpleCursorAdapter		mAdapter		= null;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		mAdapter = new SimpleCursorAdapter(getActivity(), 
										   android.R.layout.simple_list_item_2, 
										   null, 
										   COLUMNS_FROM, 
										   VIEWS_TO, 
										   0);
		
		setListAdapter(mAdapter);
		
		getLoaderManager().initLoader(LOADER_ID, null, new CursorLoaderCallback());
	}
	
	private class CursorLoaderCallback implements LoaderCallbacks<Cursor>
	{
		@Override
		public Loader<Cursor> onCreateLoader(int _id, Bundle _args)
		{
			return new CursorLoader(getActivity(), ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
		}

		@Override
		public void onLoadFinished(Loader<Cursor> _loader, Cursor _cursor)
		{
			mAdapter.swapCursor(_cursor);
		}

		@Override
		public void onLoaderReset(Loader<Cursor> arg0)
		{
			mAdapter.swapCursor(null);
		}
	}
}
