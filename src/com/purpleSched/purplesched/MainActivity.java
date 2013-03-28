package com.purpleSched.purplesched;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	TimePicker tp;
	EditText event_name;
	RadioGroup event_type_buttons;
	Button done;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * Creating a scheduler
         * 
         */
        final Scheduler eScheduler = new Scheduler();
        AudioManager am= (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
        Sound x = new Sound(am);
        x.vibrate();
        
        /*
         * Retrieving buttons, time picker, etc
         * 
         */
        tp = (TimePicker)findViewById(R.id.timePicker1);
        tp.setIs24HourView(true);
        event_name = (EditText)findViewById(R.id.event_name_textbox);
        event_type_buttons = (RadioGroup)findViewById(R.id.radiogroup_buttons);
        done = (Button)findViewById(R.id.done);
        
        done.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*
				 * Getting the event 'specifications'
				 */
				String eName = event_name.getText().toString();
				String eType="";
				switch(event_type_buttons.getCheckedRadioButtonId()){
				case R.id.lecture:
					eType = "Lecture";
					break;
				case R.id.tutorial:
					eType =  "Tutorial";
					break;
				case R.id.other:
					eType = "Other";
					break;
				}
				String eTime = tp.getCurrentHour()+":"+tp.getCurrentMinute();
				//creating a record
				Record eRecord = new Record(eName,eTime,eType);
				eScheduler.schedule(eRecord);
			}
        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
