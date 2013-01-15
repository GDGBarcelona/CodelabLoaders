package org.gdg.barcelona.codelabloaders.silver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import android.content.Context;
import android.sax.Element;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Xml;

public class WebServiceLoader extends AsyncTaskLoader<ArrayList<String>> 
{
	private ArrayList<String>	mList			= null;
	
	public WebServiceLoader(Context _context) 
	{
		super(_context);
		mList = new ArrayList<String>();
	}
	
	@Override
	protected void onStartLoading() 
	{
		super.onStartLoading();
		forceLoad();
	}

	@Override
	public ArrayList<String> loadInBackground() 
	{
		mList.clear();
		CulturalParser.parse(mList);
		return mList;
	}
	
	@Override
	public void onCanceled(ArrayList<String> _data)
	{
		mList.clear();
		_data.clear();
		super.onCanceled(_data);
	}
	
	@Override
	protected void onReset() 
	{
		mList.clear();
		super.onReset();
	}
	
	private static class CulturalParser
	{
		private static final String	WEBSERVICE_URL	= "http://dadesobertes.gencat.cat/recursos/agenda/agenda_cultural_valles_occidental.xml";
		private static final String	ROOT_ELEMENT	= "AGENDA_CULTURAL";
		private static final String	NODE_ELEMENT	= "Activitats";
		private static final String	NAME_ELEMENT	= "denominacio_text";
				
		private static void parse(final ArrayList<String> _list)
		{
			try 
			{
				InputStream inputStream = (new URL(WEBSERVICE_URL)).openConnection().getInputStream();
				
				RootElement root = new RootElement(ROOT_ELEMENT);
				Element nameElement = root.getChild(NODE_ELEMENT).getChild(NAME_ELEMENT);
				
				nameElement.setEndTextElementListener(new EndTextElementListener() 
				{	
					@Override
					public void end(String _body) 
					{
						_list.add(_body);
					}
				});
				
				Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
			} 
			catch (MalformedURLException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			catch (SAXException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
