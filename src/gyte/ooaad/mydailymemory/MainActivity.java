package gyte.ooaad.mydailymemory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView username = (TextView) findViewById(R.id.top_username);
		username.setText(Session.username);

		Button leftButton = (Button) findViewById(R.id.top_leftButton);
		leftButton.setText("��k��");
		leftButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO ��k�� tu�una bas�ld���nda yap�lacaklar
				startActivity(new Intent(MainActivity.this, Login.class));
			}
		});
		leftButton.setVisibility(View.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {

	}

}
