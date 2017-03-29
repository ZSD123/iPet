package com.ipet.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnScrollChangeListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;

import com.ipet.app.R;
public class MainActivity extends FragmentActivity {
    public  ViewPager viewPager;
    private ImageView chatPic;
    private ImageView dailyPic;
    private ImageView shoppingPic;
    private ImageView myPetPic;
	 private List<fragmentPart> fragList=new ArrayList<fragmentPart>();
    private String [] title=new String[]{
    		"communication","daily","shopping","myPet"
         };
	 private FragmentPagerAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		init();
		viewPager.setAdapter(mAdapter);
		chatPic=(ImageView)findViewById(R.id.chatPic);
		dailyPic=(ImageView)findViewById(R.id.dailyPic);
		shoppingPic=(ImageView)findViewById(R.id.shoppingPic);
		myPetPic=(ImageView)findViewById(R.id.myPetPic);
		chatPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewPager.setCurrentItem(0);
				
			}
		});
		dailyPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewPager.setCurrentItem(1);
				
			}
		});
		shoppingPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewPager.setCurrentItem(2);
				
			}
		});
		myPetPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		     viewPager.setCurrentItem(3);
				
			}
		});
	}
	public void init(){
		viewPager=(ViewPager)findViewById(R.id.id_viewpager);
		 for (int i=0;i<title.length;i++)                     //¼ÓÔØfragmentPart
	      {   
		      fragmentPart fragP=fragmentPart.getInstance(this);
		      Bundle bundle =new Bundle();
		      bundle.putString(fragmentPart.keyToGet,title[i]);
		      fragP.setArguments(bundle);
		      fragList.add(fragP);
	      }
		   mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
				
				@Override
				public int getCount() 
				{
					
					return fragList.size();
				}
				
				@Override
				public android.support.v4.app.Fragment getItem(int position) 
				{
					return fragList.get(position);
					
				}
			   };
	}
}
