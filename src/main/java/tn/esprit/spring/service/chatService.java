package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.BlockUserEntity;
import tn.esprit.spring.entity.Chat;
import tn.esprit.spring.entity.UserC;
import tn.esprit.spring.repository.BlockUserRepository;
import tn.esprit.spring.repository.ChatReposiroty;
import tn.esprit.spring.repository.UserRepository;

@Service
public class chatService implements IChatService {
	@Autowired
	ChatReposiroty chatRepository;
	@Autowired
	UserRepository userRepo;
	@Autowired
	BlockUserRepository blockedUserRepo;
	
	//add chat
	@Override
	public Chat addChat(Chat chat) {
		return chatRepository.save(chat);
	}

	
//	//display all chat
//	@Override
//	public List<Chat> displayAll(){
//		 List<Chat> chats = chatRepository.displayAll();
//		 return chats;
//	}
	
	//display chat by id
	@Override
	public Chat displayChatById(int idC) {
		Chat chat = chatRepository.findById(idC);
		return chat;
	}
	
	
	@Override
	public Boolean block(String angryName, String blockedName) {
		UserC angry = userRepo.findByUserName(angryName);
		UserC blocked = userRepo.findByUserName(blockedName);
		if(angry.getId() != 0 && blocked.getId() != 0) {
			BlockUserEntity blockEntity = new BlockUserEntity();
			blockEntity.setAngryId(angry.getId());
			blockEntity.setBlockedId(blocked.getId());
			blockedUserRepo.save(blockEntity);
			return true;
		}	
		return false;
	}
	
	@Override
	public Boolean unblock(String angryName, String blockedName) {
		UserC angry = userRepo.findByUserName(angryName);
		UserC blocked = userRepo.findByUserName(blockedName);
		
		if(angry.getId() != 0 && blocked.getId()!= 0) {
			try {
				blockedUserRepo.unblock(angry.getId(), blocked.getId());
			} 
			catch(Exception e){
				return false;
			}
		}
		
		return true;
	}
	
	

	@Override
	public Boolean blockControl(String angryName, String blockedName) {
		UserC angry = userRepo.findByUserName(angryName);
		UserC blocked = userRepo.findByUserName(blockedName);
		List<BlockUserEntity> listOfBlock = blockedUserRepo.findAllByAngryId(angry.getId());
		ArrayList<Long> blockedIds = new ArrayList<Long>();
		int loop = listOfBlock.size();
		for(int flag = 0; flag<loop;flag++) {
			blockedIds.add(listOfBlock.get(flag).getBlockedId());
		}
		if(blockedIds.contains(blocked.getId())) {
			return true;
		}
		return false;
	}


	
	
	
	
	
	
}
