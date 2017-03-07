package org.archit.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.archit.messenger.database.Database;
import org.archit.messenger.model.Message;
import org.archit.messenger.model.Profile;

public class ProfileService {
	
	//private static Map<Long, Message> messages = Database.getMessages();
	private static Map<String, Profile> profiles = Database.getProfiles();
	
	public ProfileService(){
		profiles.put("Archit", new Profile(1L, "Archit", "Archit", "Vaidya"));
		profiles.put("Sachin", new Profile(2L, "Sachin", "Sachin", "Tendulkar"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfileByName(String profileName){
		if(profiles.containsKey(profileName)){
			return profiles.get(profileName);
		}
		else{
			return null;
		}
	}
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profiles.get(profile);
	}
	
	public void  removeProfile(String profileName){
		profiles.remove(profileName);
	}

}
