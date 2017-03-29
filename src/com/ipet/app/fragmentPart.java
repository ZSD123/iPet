package com.ipet.app;

import java.util.ArrayList;
import java.util.List;

import myCustomView.circleImageView;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class fragmentPart extends Fragment {
	private Context context;
    private String theKey;
    private View view;
    private ListView listView;
    private TextView listviewItem;
    private circleImageView circleView;
    private List<String> listitem=new ArrayList<String>();
    private BaseAdapter adapter;
    private View theView;
	 public static String keyToGet="begin";
	public fragmentPart(){
		
	}
	public static fragmentPart getInstance(Context context){
		fragmentPart fragmentPart=new fragmentPart();
		fragmentPart.context=context;
		return fragmentPart;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
    {   
		if(getArguments()!=null)
		{
			theKey=getArguments().getString(keyToGet);
			
		}
		if(theKey.equals("communication"))
		{   
			view=inflater.inflate(R.layout.communication,null);
		}else if(theKey.equals("daily")){
			view=inflater.inflate(R.layout.daily, null);
		}else if(theKey.equals("shopping")){
			view=inflater.inflate(R.layout.shopping, null);
		}else if(theKey.equals("myPet")){
			view=inflater.inflate(R.layout.mypet, null);
			circleView=(circleImageView)view.findViewById(R.id.circleImageView);
			circleView.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.hua));
			listView=(ListView)view.findViewById(R.id.listview);
			listitem.add(0, "溜宠");
			listitem.add(1, "宠物的日常");
			listitem.add(2, "宠物医疗");

			adapter=new BaseAdapter() {
				
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					if(convertView==null){
					    LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					    theView=layoutInflater.inflate(R.layout.listview_item, null);
						listviewItem=(TextView) theView.findViewById(R.id.listItemText);
						listviewItem.setText(listitem.get(position));
					     
					}
					return theView;
				}
				
				@Override
				public long getItemId(int position) {
					
					return position;
				}
				
				@Override
				public Object getItem(int position) {
					
					return listitem.get(position);
				}
				
				@Override
				public int getCount() {
					
					return listitem.size();
				}
			};
			listView.setAdapter(adapter);
		}
		return view;
    }
}