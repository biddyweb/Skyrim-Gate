package project01.skyrim;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class GamePlayActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tabgame);
	        
	        
			/*Gallery*/
			Gallery gallery = (Gallery) findViewById(R.id.gallery_race);
			gallery.setAdapter(new ImageAdapter(this));

			gallery.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView parent, View v, int position,
						long id) {
					Toast.makeText(GamePlayActivity.this, "" + position,
							Toast.LENGTH_SHORT).show();
				}
			});	        	        
	 }
	
	// Begin hacking for Gallery *********************
	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Context mContext;

		private Integer[] mImageIds = { R.drawable.race00,
				R.drawable.race01, R.drawable.race02,
				R.drawable.race03, R.drawable.race04,
				R.drawable.race05 };

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


