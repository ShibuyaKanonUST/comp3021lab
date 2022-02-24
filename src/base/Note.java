package base;

import java.util.Objects;


public class Note {
	//Data member
	private java.util.Date date;
	private String title;
	
	// Member Function
	public Note(String title) {
		this.title = title;
		date = new java.util.Date(System.currentTimeMillis());
	}
	
	public String getTitle() {
		return this.title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Note == false)
			return false;
		Note other = (Note) obj;
		return Objects.equals(title, other.title);
	}
	
	
}






