package gyte.ooaad.mydailymemory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

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

	@Override
	public void onBackPressed() {

	}

	/**
	 * Giriþ ekranýndaki giriþ tuþuna basýldýðýnda bu fonksiyon çaðýrýlýr
	 */
	public void login(View view) {
		// TODO Giriþ tuþuna basýldýðýnda yapýlacaklar
		TextView username = (TextView) findViewById(R.id.login_username);
		Session.username = username.getText().toString();
		startActivity(new Intent(Login.this, MainActivity.class));
	}

	/**
	 * Giriþ ekranýndaki kayýt ol tuþuna basýldýðýnda bu fonksiyon çaðýrýlýr
	 */
	public void register(View view) {
		// TODO Kayýt Ol tuþuna basýldýðýnda yapýlacaklar
		startActivity(new Intent(Login.this, Register.class));
	}
}
