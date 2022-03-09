package base;

import java.util.Objects;


public class Note implements Comparable<Note>{
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
	
	public int compareTo(Note obj) {
		if (this.date.compareTo(obj.date) == 0)
			return 0;
		else if (this.date.compareTo(obj.date) > 0)
			return -1;
		else
			return 1;
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
	
	public String toString() {
		return date.toString() + "\t" + title;
	}
	
	
}






