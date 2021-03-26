package tn.esprit.spring.websocket;

public class ChatMessage {
	
		private String text;
	    private String username;
	    private String avatar;
	    
	  
	    
	    public ChatMessage(String text, String username, String avatar) {
			
			this.text = text;
			this.username = username;
			this.avatar = avatar;
		}

		public  ChatMessage() {
	    	
	    }
	    
	    
	    
	    
	    
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
	    


}
