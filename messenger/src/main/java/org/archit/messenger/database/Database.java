package org.archit.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.archit.messenger.model.Message;
import org.archit.messenger.model.Profile;

public class Database {
	
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Long, Message> messages) {
		Database.messages = messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<String, Profile> profiles) {
		Database.profiles = profiles;
	}
	
	

}
