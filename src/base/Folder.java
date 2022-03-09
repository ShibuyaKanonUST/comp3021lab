package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Folder implements Comparable<Folder>{
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
	
	public int compareTo(Folder obj) {
		if (this.getName().compareTo(obj.getName()) < 0) 
			return -1;
		else if (this.getName().compareTo(obj.getName()) == 0)
			return 0;
		else 
			return 1;
		
	}
	
	public void sortNotes() {
		Collections.sort(notes);
		
	}
	
	public List<Note> searchNotes(String keywords){
		List<Note> wantedNotes = new ArrayList<Note>();
		String[] tokens = keywords.split(" ",0);

		
		for (Note j : notes)
		{
	

			boolean flag = false;
			
			for (int i=0 ; i<tokens.length; i++) {
			
	
				if (i==tokens.length-1)
				{
				
					if (j instanceof TextNote)
					{
						if (   (j.getTitle().toLowerCase().contains(tokens[i].toLowerCase()))  ||   (((TextNote)j).content.toLowerCase().contains(tokens[i].toLowerCase()))  )
							flag = true;
						else
						{
							flag = false;
							break;
						}
						
					}
					else if (j instanceof ImageNote)
					{
						if (j.getTitle().toLowerCase().contains(tokens[i].toLowerCase()))
							flag = true;
						else
						{
							flag = false;
							break;
						}
					}
				}
				else if (tokens[i+1].toLowerCase().equals("or") )
				{
					
					
					if (j instanceof TextNote)
					{
						if ( 
								( (j.getTitle().toLowerCase().contains(tokens[i].toLowerCase())) || (j.getTitle().toLowerCase().contains(tokens[i+2].toLowerCase())) ) ||
								( ( ( (TextNote)j).content.toLowerCase().contains(tokens[i].toLowerCase()))  || ( ((TextNote)j).content.toLowerCase().contains(tokens[i+2].toLowerCase())) ) 
						   )
						{
							flag = true;
							
						}
						else
						{
							
							flag = false;						
							break;
						}
						
					}
					else if (j instanceof ImageNote)
					{
						if (j.getTitle().toLowerCase().contains(tokens[i].toLowerCase()) || j.getTitle().toLowerCase().contains(tokens[i+2].toLowerCase()))
						{
							flag = true;
							
						}
						else
						{
							flag = false;
							break;
						}
					}
					
					i++;
					i++;
					
				
				}
				else
				{

					if (j instanceof TextNote)
					{
						if (  (j.getTitle().toLowerCase().contains(tokens[i].toLowerCase()))   ||   (((TextNote)j).content.toLowerCase().contains(tokens[i].toLowerCase())) )
							flag = true;
						else
						{
							flag = false;
							break;
						}
						
					}
					else if (j instanceof ImageNote)
					{
						if (j.getTitle().toLowerCase().contains(tokens[i].toLowerCase()))
							flag = true;
						else
						{
							flag = false;
							break;
						}
					}
				}

			}
			
			
			if (flag == true)
				wantedNotes.add(j);
		}
		
		
		return wantedNotes;
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
