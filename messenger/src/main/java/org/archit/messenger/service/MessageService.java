package org.archit.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.archit.messenger.database.Database;
import org.archit.messenger.exception.DataNotFoundException;
import org.archit.messenger.model.Message;
import org.archit.messenger.model.Profile;

public class MessageService {
	
	private static Map<Long, Message> messages = Database.getMessages();
	
	
	public MessageService(){
		messages.put(1L, new Message(1,"Hello Archit", "Archit"));
		messages.put(2L, new Message(2,"Hello abc2", "abc"));
		messages.put(3L, new Message(3,"Hello abc3", "abc"));
		messages.put(4L, new Message(4,"Hello abc4", "abc"));
		messages.put(5L, new Message(5,"Hello abc5", "abc"));
		messages.put(6L, new Message(6,"Hello abc6", "abc"));
		messages.put(7L, new Message(7,"Hello abc7", "abc"));
		messages.put(8L, new Message(8,"Hello abc8", "abc"));
	}
	
	public List<Message> getAllMessages(){
		System.out.println(messages.size());
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> list = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				list.add(message);
			}
		}
		return list;
	}
	
	public List<Message> getAllMessagesPaginated(int offset, int size){
		List<Message> list = new ArrayList<Message>(messages.values());
		if(offset+size > list.size()){return new ArrayList<Message>();}
		return list.subList(offset, offset + size);
	}
	
	
	
	public Message getMessage(Long id){
		Message message = messages.get(id);
		if(message == null){
			throw new DataNotFoundException("Message with id: "+id+" not found");
		}
		return message;		
		
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		for(Long m : messages.keySet()){
			System.out.println(messages.get(m).getMessage());
		}
		return message;
	}
	
	public Message removeMessage(Long id){
		return messages.remove(id);
	}
	

}
