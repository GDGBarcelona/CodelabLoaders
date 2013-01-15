package org.gdg.barcelona.codelabloaders.golden;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;

public class GoldenFragment extends ListFragment 
{
	private static final int		LOADER_ID		= 0;
	
	private SimpleCursorAdapter		mAdapter		= null;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		
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
