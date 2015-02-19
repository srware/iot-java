package com.ibm.iotf.client.app;

import java.io.UnsupportedEncodingException;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.ibm.iotf.client.Message;


/**
 * @deprecated This would be eventually replaced by com.ibm.iotf.client.device.Command <br>
 * However, currently it is retained for command subscription by application
 * This class has only accessors and no mutators and later on might be made final
 * 
 */

@Deprecated
public class Command extends Message{

	private String type, id, command, format;
	
	/**
	 * Note that this class does not have a default constructor
	 * However, currently it is retained for command subscription by application
	 * This class has only accessors and no mutators and later on might be made final
	 * 
	 */	
	public Command(String type, String id, String command, String format, MqttMessage msg) throws UnsupportedEncodingException{
		super(msg, format);
		this.type = type;
		this.id = id;
		this.command = command;
		this.format = format;
	}
	
	public String getDeviceType() {
		return type;
	}

	public String getDeviceId() {
		return id;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getFormat() {
		return format;
	}
	
	/**
	 * 
	 * Provides a human readable String representation of this Command, including the timestamp, command type, command id and payload passed.
	 */
	public String toString() {
		if(format.equalsIgnoreCase("json")) {
			return "Command [" + timestamp.toString() + "] " + type + ":" + id + " - " + command + ": " + data.toString();
			
			//This else condition has been added to handle the commands which do not have json format
		} else {
			return "Command [" + timestamp.toString() + "] " + type + ":" + id + " - " + command + ": " + payload.toString();			
		}
 
	}
}
