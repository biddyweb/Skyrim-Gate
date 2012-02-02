package project01.skyrim;


import android.app.Activity;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;





public class MoreActivity extends Activity implements OnClickListener, OnErrorListener{
	
	 VideoView videoView;
	 MediaController mController;
	 MediaPlayer mediaPlayer;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);


	        setContentView(R.layout.tabmore);
	        
	        VideoView videoView = (VideoView) findViewById(R.id.videoView1);  
	        
	        
			videoView.setVideoURI(Uri.parse("android.resource://project01.skyrim/" + R.raw.video)); 
			
			videoView.setBackgroundColor(BIND_AUTO_CREATE);
			
			       ////magic background, finally get rid of black devil flyer!!!
			
			videoView.setOnClickListener(this);
			videoView.setOnErrorListener(this);
			
			
			//videoView.setVideoURI(Uri.parse("rtsp://rtsp.youtube.com/youtube/videos/S2eoCqwBCQI/video.3gp")); 
			mController = new MediaController(this);
			
		
			videoView.setMediaController(mController); 
//			 
//			videoView.setOnClickListener(this);
			
			//videoView.seekTo(5000);
			videoView.requestFocus();
			videoView.start();
			
			
	        
	        
//	        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
//	        SurfaceHolder surfaceHolder = surfaceView.getHolder();
//	        surfaceHolder.setFixedSize(100, 100);
//	        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//
//	        mediaPlayer = new MediaPlayer();
//	        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//	        mediaPlayer.setDisplay(surfaceHolder);
//	        try
//	        {
//	            mediaPlayer.setDataSource("sdcard/test.3gp");
//	            mediaPlayer.prepare();
//	            mediaPlayer.start();
//	        }
//	        catch (Exception e)
//	        {
//	        }
	        
	        
	        
	    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//videoView.start();
		//videoView.setBackgroundColor(BIND_AUTO_CREATE);
		//videoView.setBackgroundResource(BIND_AUTO_CREATE);
		
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		
		
	}
	
	
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		//videoView.stopPlayback();
		//videoView.seekTo(5000);
		//if(videoView != null)
		{
			//if(videoView.isPlaying())
				//videoView.pause();
			//videoView.st
		}
		
	}
	
	@Override
	public void onStop(){
		// TODO Auto-generated method stub
		super.onStop();
//		if(videoView != null)
//		{
//			if(videoView.isPlaying())
//				videoView.pause();
//			
//		}
//		videoView.stopPlayback();
		//videoView.seekTo(5000);
		
		
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		//videoView.stopPlayback();
	}


	@Override
	public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Toast toast=Toast.makeText(getApplicationContext(), "cannot play on current mobile system, please try the redirect URL link", Toast.LENGTH_SHORT);     
        toast.show(); 
		return false;
	}
	
	
}