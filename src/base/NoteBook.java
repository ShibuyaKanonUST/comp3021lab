package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class NoteBook {
	// Data member
	private ArrayList<Folder> folders;
	
	// Member function
	public NoteBook() {
		folders = new ArrayList<Folder>();
		
	}
	
	public boolean createTextNote(String folderName, String title) {
		TextNote note = new TextNote(title);
		return insertNote(folderName,note);
	}
	
	public boolean createTextNote(String folderName, String title, String content) {
		TextNote note = new TextNote(title, content);
		return insertNote(folderName, note);
	}

		
	public boolean createImageNote(String folderName, String title) {
		ImageNote note = new ImageNote(title);
		return insertNote(folderName,note);
	}
		
	public ArrayList<Folder> getFolders(){
		return this.folders;
	}
		
	public boolean insertNote(String folderName, Note note) {
		Folder f = null;

		for (Folder f1 : folders) {
			if (f1.getName()==folderName) {
				f = f1;
			}
		}
			
		if (f == null) {
			Folder newFolder = new Folder(folderName);
			folders.add(newFolder);
			f = newFolder;
		}
			
		for (Note n : f.getNotes()) {
			if (n.equals(note)) {
				System.out.println("Creating note " + note.getTitle() + " under folder "+ folderName + " failed");
				return false;
			}
		}
		
		f.addNote(note);
		return true;
	}
	
	public void sortFolders() {
		for (Folder j : folders)
			j.sortNotes();
		
		Collections.sort(folders);
		
	
	}
	
	public List<Note> searchNotes(String keywords){
		List<Note> wantedNotes = new ArrayList<Note>();
		for (Folder i : folders) {
			List<Note> aa = i.searchNotes(keywords);
			wantedNotes.addAll(aa);
		}
		
		return wantedNotes;
	}
}
