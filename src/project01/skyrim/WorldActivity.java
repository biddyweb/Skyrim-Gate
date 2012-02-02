package project01.skyrim;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class WorldActivity extends Activity implements OnClickListener {	
	TextView link_t;	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setContentView(R.layout.tabworld);
	        
			/*a link which is clickable*/
			link_t = (TextView) findViewById(R.id.trailer);
			link_t.setOnClickListener(this);
			
	    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=PjqsYzBrP-M"));
			startActivity(browserIntent);
		
	}
}
