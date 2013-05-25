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
	 * Kayýt ol ekranýndaki geri tuþuna basýldýðýnda bu fonksiyon çaðýrýlýr
	 */
	public void back(View view) {
		// TODO Geri tuþuna basýldýðýnda yapýlacaklar
		onBackPressed();
	}

	/**
	 * Kayýt ol ekranýndaki kayýt ol tuþuna basýldýðýnda bu fonksiyon çaðýrýlýr
	 */
	public void register(View view) {
		// TODO Kayýt ol tuþuna basýldðýnda yapýlacaklar
	}

}
