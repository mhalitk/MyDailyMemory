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
		username.setText(Session.user.getName());

		Button leftButton = (Button) findViewById(R.id.top_leftButton);
		leftButton.setText("Çýkýþ");
		leftButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Çýkýþ tuþuna basýldýðýnda yapýlacaklar
				startActivity(new Intent(MainActivity.this, Login.class));
			}
		});
		leftButton.setVisibility(View.VISIBLE);

		Button rightButton = (Button) findViewById(R.id.top_rightButton);
		rightButton.setText("Yeni");
		rightButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Yeni tuþuna basýldýðýnda yapýlacaklar
				startActivity(new Intent(MainActivity.this, NewMemory.class));
			}
		});
		rightButton.setVisibility(View.VISIBLE);

		setMemoryAdapter();
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

	private void setMemoryAdapter() {
		// listView.setAdapter(new ArrayAdapter<Student>(this,
		// R.layout.memlistitem, memories) {
		// @Override
		// public View getView(int position, View convertView, ViewGroup parent)
		// {
		// View row;
		//
		// if (convertView == null) {
		// LayoutInflater inflater = (LayoutInflater) MainActivity.this
		// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// convertView = inflater.inflate(R.layout.memlistitem,
		// null);
		// }
		// row = convertView;
		//
		// TextView header = (TextView)
		// row.findViewById(R.id.memlistitem_header);
		// TextView text = (TextView) row
		// .findViewById(R.id.memlistitem_text);
		// header.setText("");
		// text.setText("");
		//
		// return row;
		//
		// }
		// });
	}

}
