package base;

import java.io.File;

public class ImageNote extends Note implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Data Member
	File image;
	
	// Member Function
	public ImageNote(String title) {
		super(title);
			
	}
}
