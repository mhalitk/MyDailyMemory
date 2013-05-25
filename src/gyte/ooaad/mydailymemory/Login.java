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
	public void onResume()
	{
		super.onResume();
		
		if(Session.user.getUserId() > -1)
		{			
			startActivity(new Intent(Login.this, MainActivity.class));
		}// successful user login
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
		TextView password = (TextView) findViewById(R.id.login_password);
		
		int userId = -1;
		Session.user.setName(username.getText().toString());
		Session.user.setPassword(password.getText().toString());
				
		UserDatabaseHelper userDBHelp = new UserDatabaseHelper(Login.this);
		userId = userDBHelp.getUserId(Session.user);
		Session.user.setId(userId);
		
		if(userId > -1)
		{
			Session.user.setId(userId);
			startActivity(new Intent(Login.this, MainActivity.class));
		}// successful user login
		else
		{
			Toast.makeText(Login.this, "Hata: Kullanýcý adý ya da þifre hatalý!", Toast.LENGTH_LONG).show();
			
		}// error! Wrong username or password						
	}

	/**
	 * Giriþ ekranýndaki kayýt ol tuþuna basýldýðýnda bu fonksiyon çaðýrýlýr
	 */
	public void register(View view) {
		// TODO Kayýt Ol tuþuna basýldýðýnda yapýlacaklar
		startActivity(new Intent(Login.this, Register.class));
	}
}
