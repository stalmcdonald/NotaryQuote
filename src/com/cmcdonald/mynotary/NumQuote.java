/*
 * Crystal McDonald
 * Java II 1303
 * Week 1
 */
package com.cmcdonald.mynotary;

import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NumQuote extends Activity implements OnClickListener {
	EditText number;
	Button shareInfo;
	Button browse;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.numquote);
		number = (EditText)findViewById(R.id.editText1);
		shareInfo = (Button)findViewById(R.id.button1);
		// set listener for browse button
		browse = (Button) findViewById(R.id.browseBttn);
		shareInfo.setOnClickListener(this);
		 
        //IMPLICIT INTENT
        browse.setOnClickListener(new OnClickListener() {
		
        	@Override
    		public void onClick(View interwebs) {
        		// Sends user to Notary Service website when button is clicked
        Uri uriUrl = Uri.parse("http://www.123notary.com/mobilenotary.htm");

        Intent browse_intent = new Intent(Intent.ACTION_VIEW, uriUrl);

        startActivity(browse_intent);
        
    }
			
		

});
		    	
		    
	}
	//ACTIVITY2 TAKES IN A NUMBER TO DISPLAY IT ON ACIVITY1
	@Override
	public void onClick(View v) {
		// get info from edit text and send back
		String s = number.getText().toString();
		//get info from intent that opens numQuote class
		Intent i = getIntent ();
		//looking for i.putextras
		String msg = i.getStringExtra("numbers"); 
		if(msg.contentEquals("documents")){
			i.putExtra("documentsInfo", s);
			setResult(RESULT_OK, i);
			finish();
		}	
		//takes the results and closes the page and appends to MainActivity in its button
		if(msg.contentEquals("costPerPage")){
			i.putExtra("costPerPageInfo", s);
			setResult(RESULT_OK, i);
			finish();
				
		}
		
		
	}
}
