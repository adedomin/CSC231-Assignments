package edu.easternct.csc231.ch7;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTester {

	public static void main(String args[]) {

		List<Song> songs = new ArrayList<Song>();
		
		Song song = new Song();
		
		song.setSongId("s57Fhbv35G");
		song.setTitle("Dayvan Cowboy");
		song.setArtist("Boards of Canada");
		// will call setGenre("IDM")
		// internally since genre unset
		song.insertGenre("IDM");
		// adds comma separated string
		song.insertGenre("downtempo");
		song.insertGenre("electronic");
		song.insertSuggestedSong("tu8jFhjk");
		song.insertSuggestedSong("dghH256");
		// removes ONLY downtempo
		song.removeGenre("downtempo");
		// removes only specified id
		song.removeSuggestedSong("tu8jFhjk");
		// shows that unset vars
		// won't break toString()
		Song song2 = new Song();

		// not an empty constructor
		Song song3 = new Song(
				"SONG4tgvfID", 
				"The Politics of Dancing",
				"Re-Flex", "New Wave",
				"455gfsG,HjkvD3");

		// shows possibility for derived instance variables
		// generates a songId using title + artist
		// and "finds" genre by artist name
		Song song4 = new Song();
		song4.setTitle("Bright Lights");
		song4.setArtist("Spyro Gyra");
		song4.generateSongId();
		song4.findGenres();

		songs.add(song);
		songs.add(song2);
		songs.add(song3);
		songs.add(song4);

		for (int i=0; i<songs.size(); ++i) {

			System.out.printf("%s\n", songs.get(i));
		}

		System.out.printf("The List is of size: %d\n", songs.size());
		System.out.printf("remove, a song\n\n");

		songs.remove(song2);

		for (int i=0; i<songs.size(); ++i) {

			System.out.printf("%s\n", songs.get(i));
		}

		System.out.printf("The List is of size: %d\n", songs.size());
	}
}
