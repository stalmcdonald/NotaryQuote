/*
 * Crystal McDonald
 * Java II 1303
 * Week 1
 */
package com.cmcdonald.mynotary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	Button documents, costPerPage, calc;
	TextView myQuote;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		documents = (Button) findViewById(R.id.button1);
		costPerPage = (Button) findViewById(R.id.button2);
		calc = (Button) findViewById(R.id.button3);
		myQuote = (TextView) findViewById(R.id.textView1);
		
		//setup onclick listener
		documents.setOnClickListener(this);
		costPerPage.setOnClickListener(this);
		calc.setOnClickListener(this);
		
	}

    //EXPLICIT INTENT
	@Override
	public void onClick(View v) {
		// if button 1-2 are pressed go to new activity
		Intent i = new Intent(this, NumQuote.class);
		switch (v.getId()){
		
		//buttons
		case R.id.button1:
		
        //Docs
		i.putExtra("numbers", "documents");
		startActivityForResult(i, 1);
			break;
		case R.id.button2:
		
            //costPerPage
			i.putExtra("numbers", "costPerPage");
			startActivityForResult(i, 1);
			break;
		case R.id.button3:
		
                //calculate
			     //converting integer to string
		int a = Integer.valueOf(documents.getText().toString());
		int b = Integer.valueOf(costPerPage.getText().toString());
		//displays the sum in a string replacing "Quote"
		myQuote.setText(" Client Quote: $" + a*b);
		break;
		
		default:
			break;
		}
	}
    //GETS NUMBERS BACK FROM ACTIVITY2 TO BE CALCULATED
	//capture info being sent back
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(data.getExtras().containsKey("documentsInfo")){
				documents.setText(data.getStringExtra("documentsInfo"));
		}
		if(data.getExtras().containsKey("costPerPageInfo")){
			costPerPage.setText(data.getStringExtra("costPerPageInfo"));
		}
	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}

}
