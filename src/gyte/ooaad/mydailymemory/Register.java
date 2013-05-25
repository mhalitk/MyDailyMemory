package gyte.ooaad.mydailymemory;

import gyte.ooaad.database.UserDatabaseHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
		onBackPressed();
	}

	/**
	 * Kayýt ol ekranýndaki kayýt ol tuþuna basýldýðýnda bu fonksiyon çaðýrýlýr
	 */
	public void register(View view) {
		// TODO Kayýt ol tuþuna basýldðýnda yapýlacaklar
		
		TextView username = (TextView) findViewById(R.id.register_username);
		TextView password1 = (TextView) findViewById(R.id.register_password);
		TextView password2 = (TextView) findViewById(R.id.register_passwordAgain);
				
		//record as new user
		UserDatabaseHelper userDBHelp = new UserDatabaseHelper(Register.this);

		//if all required input is not entered
		if(username.getText().toString().isEmpty() || password1.getText().toString().isEmpty() 
				|| password2.getText().toString().isEmpty())
		{
			Toast.makeText(Register.this, "Hata: Girilen bilgiler eksik", Toast.LENGTH_LONG).show();
			return;			
		}
		
		//if password is wrong
		if( !password1.getText().toString().equals(password2.getText().toString()) )
		{
			password1.setText("");
			password2.setText("");
			
			Toast.makeText(Register.this, "Hata: Girilen þifreler eþleþmedi", Toast.LENGTH_LONG).show();
			return;
		}
		
		Session.user.setName(username.getText().toString());
		Session.user.setPassword(password1.getText().toString());
		
		//if user name exists
		if(userDBHelp.checkUsername(Session.user))
		{
			password1.setText("");
						
			Toast.makeText(Register.this, "Hata: Girilen kullanýcý adý mevcut", Toast.LENGTH_LONG).show();
			return;
		}
				
		//register user
		userDBHelp.registerUser(Session.user);
		Session.user.setId(userDBHelp.getUserId(Session.user));
		
		//return to login screen
		onBackPressed();
	}

}
