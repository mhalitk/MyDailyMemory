package gyte.ooaad.mydailymemory;

import gyte.ooaad.database.UserDatabaseHelper;
import android.app.Activity;
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
	 * Kay�t ol ekran�ndaki geri tu�una bas�ld���nda bu fonksiyon �a��r�l�r
	 */
	public void back(View view) {
		onBackPressed();
	}

	/**
	 * Kay�t ol ekran�ndaki kay�t ol tu�una bas�ld���nda bu fonksiyon �a��r�l�r
	 */
	public void register(View view) {
		// TODO Kay�t ol tu�una bas�ld��nda yap�lacaklar
		
		TextView username = (TextView) findViewById(R.id.register_username);
		TextView password1 = (TextView) findViewById(R.id.register_password);
		TextView password2 = (TextView) findViewById(R.id.register_passwordAgain);
				
		//record as new user
		UserDatabaseHelper userDBHelp = new UserDatabaseHelper(Register.this);

		//if password is wrong
		if( !password1.toString().equals(password2.toString()) )
		{
			password1.setText("");
			password2.setText("");
			
			Toast.makeText(Register.this, "Hata: Girilen �ifreler E�le�medi", Toast.LENGTH_LONG).show();
			return;
		}
		
		Session.user.setName(username.toString());
		Session.user.setPassword(password1.toString());
		
		//if user name exists
		if(userDBHelp.checkUsername(Session.user))
		{
			password1.setText("");
						
			Toast.makeText(Register.this, "Hata: Girilen Kullan�c� Ad� Mevcut", Toast.LENGTH_LONG).show();
			return;
		}

		userDBHelp.registerUser(Session.user);		
	}

}
