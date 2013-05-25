package gyte.ooaad.mydailymemory;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NewMemory extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newmemory);

		TextView username = (TextView) findViewById(R.id.top_username);
		username.setText(Session.username);

		Button leftButton = (Button) findViewById(R.id.top_leftButton);
		leftButton.setText("Ýptal");
		leftButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		leftButton.setVisibility(View.VISIBLE);

		Button rightButton = (Button) findViewById(R.id.top_rightButton);
		rightButton.setText("Kaydet");
		rightButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
			}
		});
		rightButton.setVisibility(View.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.newmemory, menu);
		return true;
	}

	private void save() {
		// TODO Kayýt için yapýlacaklar
		onBackPressed();
	}

}
