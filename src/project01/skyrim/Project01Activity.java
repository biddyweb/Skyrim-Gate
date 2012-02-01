package project01.skyrim;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class Project01Activity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */

	Menu menu;
	MediaPlayer bgm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Never-stopping Epic Music, so annoying
//        bgm = MediaPlayer.create(getApplicationContext(), R.drawable.mus_combat_boss_02);
//        bgm.setLooping(true);
//        bgm.start();
        
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));

        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(Project01Activity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });        
    }
    
    // Begin hacking for Gallery *********************
    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;

        private Integer[] mImageIds = {
                R.drawable.gallerytest,
                R.drawable.gallerytest,
                R.drawable.gallerytest,
                R.drawable.gallerytest,
                R.drawable.gallerytest,
                R.drawable.gallerytest,
                R.drawable.gallerytest
        };

        public ImageAdapter(Context c) {
            mContext = c;
            TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
            //mGalleryItemBackground = attr.getResourceId(R.styleable.HelloGallery_android_galleryItemBackground, 0);
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
		
	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.menu, menu);
//	    return true;
//	}
//	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//	    switch (item.getItemId()) {
//	        case R.id.icon01:     Toast.makeText(this, "You pressed the icon!", Toast.LENGTH_LONG).show();
//	                            break;
//	        case R.id.text:     Toast.makeText(this, "You pressed the text!", Toast.LENGTH_LONG).show();
//	                            break;
//	        case R.id.icon02: Toast.makeText(this, "You pressed the icon and text!", Toast.LENGTH_LONG).show();
//	                            break;
//	    }
//	    return true;
//	}
	
}

