package project01.skyrim;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Project01Activity extends TabActivity implements OnClickListener, OnTabChangeListener {
	/** Called when the activity is first created. */

	Menu menu;
	MediaPlayer bgm;
	ImageButton poster;
	boolean playing;
	boolean mute;
	boolean fixposition = false;
	TabHost tabHost;	
	TextView link;	
	String myLastTabId;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		
		// Reset elements' layout, adopting fluid design
		
		
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
		
		// Never-stopping Epic Music, so annoying
		// bgm = MediaPlayer.create(getApplicationContext(),
		// R.drawable.mus_combat_boss_02);
		// bgm.setLooping(true);
		// bgm.start();
		playing = false;
		mute = false;
		// imageButton = (ImageButton) findViewById(R.id.imageButton1);
		poster = (ImageButton) findViewById(R.id.button1);
		poster.setOnClickListener(this);
		

		// poster.setLayoutParams (new LayoutParams(50,
		// LayoutParams.WRAP_CONTENT));
		
		/*tab layout*/
		Resources res = getResources(); // Resource object to get Drawables
		tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, GamePlayActivity.class);
		
		
		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost
				.newTabSpec("gamePlay")
				.setIndicator("GamePlay") //,res.getDrawable(R.drawable.topbuttonbasic)
				.setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setBackgroundColor(BIND_AUTO_CREATE);
		// Do the same for the other tabs
		intent = new Intent().setClass(this, WorldActivity.class);
		spec = tabHost
				.newTabSpec("world")
				.setIndicator("World")
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, MoreActivity.class);
		spec = tabHost
				.newTabSpec("more")
				.setIndicator("More")
				.setContent(intent);
		tabHost.addTab(spec);

		//slect the ID = 0 tab
		//tabHost.setCurrentTab(0);
		//this.setDefaultTab(2);
		myLastTabId = null;
		
		tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.topbuttonbasic);
		tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.topbuttonbasic);
		tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.topbuttonbasic);
		//tabHost.getCurrentTabView().setBackgroundResource(R.drawable.dragonwall);
		
		tabHost.setOnTabChangedListener(this);
		
		/*a link which is clickable*/
		link = (TextView) findViewById(R.id.textView1);
        //link.setText(Html.fromHtml("<a href=\"http://google.com\">HTML Hyperlink Test</a>"));
		link.setOnClickListener(this);
        
		
        
		/*Gallery*/
		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		gallery.setAdapter(new ImageAdapter(this));

		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position,
					long id) {
				Toast.makeText(Project01Activity.this, "" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
		
		if (!fixposition) {
			ScrollView s = (ScrollView) findViewById(R.id.scroller);
			s.smoothScrollTo(0,0);
			fixposition = true;
		}
		
		
	}

	// Begin hacking for Gallery *********************
	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Context mContext;

		private Integer[] mImageIds = { R.drawable.gallerytest,
				R.drawable.gallerytest, R.drawable.gallerytest,
				R.drawable.gallerytest, R.drawable.gallerytest,
				R.drawable.gallerytest, R.drawable.gallerytest };

		public ImageAdapter(Context c) {
			mContext = c;
			TypedArray attr = mContext
					.obtainStyledAttributes(R.styleable.HelloGallery);
			// mGalleryItemBackground =
			// attr.getResourceId(R.styleable.HelloGallery_android_galleryItemBackground,
			// 0);
			attr.recycle();
		}

		public int getCount() {
			return mImageIds.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(mContext);

			imageView.setImageResource(mImageIds[position]);
			imageView.setLayoutParams(new Gallery.LayoutParams(600, 330));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setBackgroundResource(mGalleryItemBackground);

			return imageView;
		}

	}

	// Finish hacking for Gallery *********************

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		if(arg0 == poster)
		{
			if (playing == false) {
				playing = true;
				LayoutParams lp = (LayoutParams) poster.getLayoutParams();
				lp.height = (int) (getWindowManager().getDefaultDisplay().getHeight() * 0.15);
				
				poster.setLayoutParams(lp);
				poster.setBackgroundResource(R.drawable.topsmall_1x);

				bgm = MediaPlayer.create(getApplicationContext(),
						R.raw.mus_combat_boss_02);
				bgm.setLooping(true);
				bgm.start();
			}else
			{
				mute = !mute;
				
				if(mute)
				{
					bgm.pause();
					poster.setBackgroundResource(R.drawable.topsmall_2x);
				}
					
				else
				{
//					if(bgm == null)
//					{
//						bgm = MediaPlayer.create(getApplicationContext(),
//							R.raw.mus_combat_boss_02);
//						bgm.setLooping(true);
//					}
					bgm.start();
					poster.setBackgroundResource(R.drawable.topsmall_1x);
				}
					
				
			}
		}else if(arg0 == link)    /* link example*/
		{
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=PjqsYzBrP-M"));
			startActivity(browserIntent);
			
		}

	}
	
	
	@Override
	public void onStart()
	{
		super.onStart();
		if(playing == true)
		{
			if(!mute)
			{
				bgm.setLooping(true);
				bgm.start();
			}
		}
		
		
	}
	
	

	
	
	@Override
	public void onPause()
	{
		super.onPause();
		if(playing == true)
			bgm.pause();
		
		
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		if(playing == true)
		{
			if(!mute)
			{
					bgm.setLooping(true);
					bgm.start();
			}
			
			
			
		}
		
		
	}
	
	
	@Override
	public void onStop()
	{
		super.onStop();
		if(playing == true)
		{
			bgm.pause();
			
		}	

	}
	
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		if(playing == true)
		{
			bgm.stop();
		}	

	}
	


	@Override
    public void onTabChanged(String tabId) {
		if(myLastTabId == null)
			myLastTabId = tabId;
		
		Toast toast=Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT);     
        toast.show();   
        
        
		
	}


	public Animation outToLeftAnimation() {
	    Animation outtoLeft = new TranslateAnimation(
	            Animation.RELATIVE_TO_PARENT, 0.0f,
	            Animation.RELATIVE_TO_PARENT, -1.0f,
	            Animation.RELATIVE_TO_PARENT, 0.0f,
	            Animation.RELATIVE_TO_PARENT, 0.0f);
	    //outtoLeft.setDuration(ConstandsUsed.ANIMATIION_DURATION);
	    outtoLeft.setInterpolator(new AccelerateInterpolator());
	    return outtoLeft;
	}
	
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// getMenuInflater().inflate(R.menu.menu, menu);
	// return true;
	// }
	//
	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// switch (item.getItemId()) {
	// case R.id.icon01: Toast.makeText(this, "You pressed the icon!",
	// Toast.LENGTH_LONG).show();
	// break;
	// case R.id.text: Toast.makeText(this, "You pressed the text!",
	// Toast.LENGTH_LONG).show();
	// break;
	// case R.id.icon02: Toast.makeText(this, "You pressed the icon and text!",
	// Toast.LENGTH_LONG).show();
	// break;
	// }
	// return true;
	// }

}
