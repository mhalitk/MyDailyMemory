package gyte.ooaad.mydailymemory;

import gyte.ooaad.database.UserDatabaseHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
	 * Giri� ekran�ndaki giri� tu�una bas�ld���nda bu fonksiyon �a��r�l�r
	 */
	public void login(View view) {
		// TODO Giri� tu�una bas�ld���nda yap�lacaklar
		TextView username = (TextView) findViewById(R.id.login_username);
		TextView password = (TextView) findViewById(R.id.login_password);
		int userId = -1;
		Session.user.setName(username.getText().toString());
		Session.user.setPassword(password.getText().toString());
		
		UserDatabaseHelper userDBHelp = new UserDatabaseHelper(Login.this);
		userId = userDBHelp.getUserId(Session.user);
		
		if(userId > -1)
		{
			Session.user.setId(userId);
			startActivity(new Intent(Login.this, MainActivity.class));
		}// successful user login
		else
		{
			Toast.makeText(Login.this, "Username or password is incorrect!", Toast.LENGTH_LONG).show();
			
		}// error! Wrong username or password						
	}

	/**
	 * Giri� ekran�ndaki kay�t ol tu�una bas�ld���nda bu fonksiyon �a��r�l�r
	 */
	public void register(View view) {
		// TODO Kay�t Ol tu�una bas�ld���nda yap�lacaklar
		startActivity(new Intent(Login.this, Register.class));
	}
}
