package gyte.ooaad.mydailymemory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * Giri� ekran�ndaki giri� tu�una bas�ld���nda bu fonksiyon �a��r�l�r
	 */
	public void login(View view) {
		// TODO Giri� tu�una bas�ld���nda yap�lacaklar
	}

	/**
	 * Giri� ekran�ndaki kay�t ol tu�una bas�ld���nda bu fonksiyon �a��r�l�r
	 */
	public void register(View view) {
		// TODO Kay�t Ol tu�una bas�ld���nda yap�lacaklar
		startActivity(new Intent(Login.this, Register.class));
	}
}
