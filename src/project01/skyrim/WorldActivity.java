package project01.skyrim;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.TextView;

public class WorldActivity extends Activity implements OnClickListener {	
	 TextView link_t;	
	 TextView link_t2;	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setContentView(R.layout.tabworld);
	        
			/*a link which is clickable*/
			link_t = (TextView) findViewById(R.id.trailer);
			link_t.setOnClickListener(this);
			/*a link which is clickable*/
			link_t2 = (TextView) findViewById(R.id.gotomore);
			link_t2.setOnClickListener(this);
			
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
		}
	}
}
