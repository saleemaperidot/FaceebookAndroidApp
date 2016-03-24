package com.baabtra.faceebookapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.ansar.evoting.votter.NewVottingPannelActivity;
import com.ansar.evoting.votter.VotterLoginActivity;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity {
	
	HttpClient httpclient;
    HttpPost httppost;
    String reading;
	EditText myEtUserName,myEtPassword;
	Button myBtLogin,myBtSignUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		
		myEtUserName=(EditText)findViewById(R.id.editTextusr);
		myEtPassword=(EditText)findViewById(R.id.editTextpwd);
		
		myBtLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String mStrVotterUserName=myEtUserName.getText().toString();
				String mStrVotterPassword=myEtPassword.getText().toString();
			
			doLogin(mStrVotterUserName,mStrVotterPassword);
				
				
				
			}
		});
		
	}
	public void doLogin(final String mArgStrVotterUserName,final String mArgStrVotterPassword)
	{
//Toast.makeText(getApplicationContext(), "username : "+ArgStudentUserName+"  password : "+ArgStudentPassword, Toast.LENGTH_LONG).show();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					
					//Toast.makeText(JustMainActivity.this , "try", Toast.LENGTH_LONG).show();
					httpclient=new DefaultHttpClient();

String url="http://api.baabtra.com/phpservice/loginnew.php";
//					String url="http://192.168.1.100/phpservice/loginnew.php";
	              //  Toast.makeText(getApplicationContext(), "api ", Toast.LENGTH_LONG).show();
	                //String url="http://192.168.1.35:80/web-services/service_login.php//";
	                httppost=new HttpPost(url);
	                
	                List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>();
	                nameValuePairs.add(new BasicNameValuePair("email",mArgStrVotterUserName));
	                nameValuePairs.add(new BasicNameValuePair("password",mArgStrVotterPassword));
	                
	                
	                System.out.println("nameVlauePairs"+nameValuePairs);

	                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                
	                System.out.println("httpPOst");

	                final HttpResponse str_response=httpclient.execute(httppost);
	                
	                System.out.println("httpResponse");

	                HttpEntity entity = str_response.getEntity();
	                InputStream is = entity.getContent();
	                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"), 8);
	                StringBuilder sb = new StringBuilder();
	                String line = null;
	                while ((line = reader.readLine()) != null) {
	                    sb.append(line + "\n");
	                }
	                is.close();
	                reading = sb.toString();
	                System.out.println("this"+reading);
	               
	                //                Context context = getApplicationContext();
//	                CharSequence text = "efwe";
//	                int duration = Toast.LENGTH_SHORT;
	//
//	                Toast toast = Toast.makeText(context, text, duration);
//	                toast.show();
					
	    runOnUiThread(new Runnable() {

	        @Override
	        public void run() {

	            try {


              JSONObject obj = new JSONObject(reading);
              
              obj.getString("status");
              System.out.println("status code"+obj.getString("status"));
	              //JSONArray obj = new JSONArray(reading);

	                //JSONObject obj1 =obj.getJSONObject(0);
	                
	                System.out.println("json");
	                
	                //obj.getString(0);
	                Integer.parseInt(obj.getString("status"));
	                if(Integer.parseInt(obj.getString("status"))!=200)
	                {
	                    Toast.makeText(getApplicationContext(),obj.getString("msg"), Toast.LENGTH_LONG).show();
	                    System.out.println();
	                }
	                else
	                {
//	                               
	                    Toast.makeText(getApplicationContext(),"Login Success !", Toast.LENGTH_LONG).show();
//	                               final Intent intent=new Intent(VotterLoginActivity.this,VotterVottingSuccessActivity.class);
               				
//	                               Intent intent=new Intent(VotterLoginActivity.this,NewVottingPannelActivity.class);
//	               				startActivity(intent);
               				
               				 
//	                              
	                }


	            } 
	            
	            catch (Exception e) {    //try 2
	                System.out.println(e);
	            }

	        }
	        
	        
	    });
	   
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}).start();	


	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
