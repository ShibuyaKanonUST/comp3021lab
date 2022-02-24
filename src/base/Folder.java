package base;

import java.util.ArrayList;
import java.util.Objects;

public class Folder {
	// Data Member
	private ArrayList<Note> notes;
	private String name;
	
	// Member function
	public Folder(String name) {
		this.name = name;
		notes = new ArrayList<Note>();
	}
	
	public void addNote(Note note) {
		notes.add(note);
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Note> getNotes(){
		return this.notes;
	}
	
	public String toString() {
		int numberOfTextNote = 0;
		int numberOfImageNote = 0;
		
		for (Note i : this.getNotes() ) {
			if (i instanceof TextNote) {
				numberOfTextNote++;
			}
			if (i instanceof ImageNote)
				numberOfImageNote++;
		}
		
		return name + ":" + numberOfTextNote + ":" + numberOfImageNote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		return Objects.equals(name, other.name);
	}
	
	
	
}
