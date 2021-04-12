package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Chat;
import tn.esprit.spring.entity.UserC;



public interface IChatService {

	 Chat addChat(Chat chat);
	 Chat displayChatById(int idC);
	 //List<Chat> displayAll();
	 Boolean block(String angryName, String blockedName);
	 Boolean unblock(String angryName, String blockedName);
	 Boolean blockControl(String angryName, String blockedName);

}
