package gyte.ooaad.mydailymemory;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Register extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	/**
	 * Kay�t ol ekran�ndaki geri tu�una bas�ld���nda bu fonksiyon �a��r�l�r
	 */
	public void back(View view) {
		// TODO Geri tu�una bas�ld���nda yap�lacaklar
		onBackPressed();
	}

	/**
	 * Kay�t ol ekran�ndaki kay�t ol tu�una bas�ld���nda bu fonksiyon �a��r�l�r
	 */
	public void register(View view) {
		// TODO Kay�t ol tu�una bas�ld��nda yap�lacaklar
	}

}
