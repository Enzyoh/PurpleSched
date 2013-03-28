package com.purpleSched.purplesched;

public class Record {
	String event_type;
	String event_time;
	String event_name;
	public Record(String name,String time,String type){
		event_type = type;
		event_time = time;
		event_name = name;
	}
	public String getName(){
		return event_name;
	}
	public String getTime(){
		return event_time;
	}
	public String getType(){
		return event_type;
	}
	public String toString(){
		return event_name+","+event_type+","+event_time;
	}
}
