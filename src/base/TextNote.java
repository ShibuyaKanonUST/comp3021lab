package base;

public class TextNote extends Note{
	// Data Member
	String content;
		
	// Member Function
	public TextNote(String title) {
		super(title);
		
	}
	
	public TextNote(String title, String content) {
		super(title);
		this.content = content;
	}
	
	
}
