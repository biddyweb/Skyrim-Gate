package project01.skyrim;

import project01.skyrim.GamePlayActivity.ImageAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class WorldActivity extends Activity implements OnClickListener {	
	 TextView link_t;	
	 TextView link_t2;	
	 TextView link_gallery;	
		
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setContentView(R.layout.tabworld);
	        
			/*a link which is clickable*/
			link_t = (TextView) findViewById(R.id.trailer);
			link_t.setOnClickListener(this);
			/*a link which is clickable*/
			link_t2 = (TextView) findViewById(R.id.gotomore);
			link_t2.setOnClickListener(this);
			/*a link which is clickable*/
			link_gallery = (TextView) findViewById(R.id.worldg_intro);
			link_gallery.setOnClickListener(this);
			
			/*Gallery*/
			Gallery gallery = (Gallery) findViewById(R.id.gallery_world);
			gallery.setAdapter(new ImageAdapter(this));
			gallery.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView parent, View v, int position,
						long id) {
					Toast.makeText(WorldActivity.this, "" + position,
							Toast.LENGTH_SHORT).show();
				}
			});	  
	    }
	@Override
	public void onClick(View v) {
		if (v == link_t) {
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, 
					Uri.parse("http://www.youtube.com/watch?v=PjqsYzBrP-M"));
			startActivity(browserIntent);
		}	else if (v == link_t2) {
			Project01Activity ParentActivity;
            ParentActivity = (Project01Activity) this.getParent();
            ParentActivity.switchTab(2);	
		} else if (v == link_gallery) {
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, 
					Uri.parse("http://www.elderscrolls.com/skyrim/media/"));
			startActivity(browserIntent);
		}
	}
	
	
	
	// Begin hacking for Gallery *********************
	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Context mContext;

		private Integer[] mImageIds = { 
				R.drawable.w3,  
				R.drawable.w2, 
				R.drawable.w0, 
				R.drawable.w1, 
				R.drawable.w4,
				R.drawable.w5 };

		public ImageAdapter(Context c) {
			mContext = c;
			TypedArray attr = mContext
					.obtainStyledAttributes(R.styleable.HelloGallery);
			attr.recycle();
		}

		public int getCount() {	return mImageIds.length;}
		public Object getItem(int position) { return position;}
		public long getItemId(int position) { return position;}
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(mContext);
			imageView.setImageResource(mImageIds[position]);
			imageView.setLayoutParams(new Gallery.LayoutParams(600, 330));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setBackgroundResource(mGalleryItemBackground);

			return imageView;
		}
	}	
	
	
}
