package edu.easternct.csc231.ch4;

import edu.easternct.csc231.ch4.Song;

public class SongTest {

	/**
	 * Unit Test
	 * <p>
	 * demonstrates use of class also
	 */
	public static void main(String[] argv) {

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
		// since call has a comma it will fail
		// with no action taken
		song.insertSuggestedSong(",fhjyhtgfTEST");

		// .toString() uses getters, 
		// so getters are defacto tested
		System.out.printf("%s\n", song);

		// shows that unset vars
		// won't break toString()
		Song song2 = new Song();

		// formatter will write out null 
		// for unset values
		System.out.printf("%s\n", song2);

		// not an empty constructor
		Song song3 = new Song(
				"SONG4tgvfID", 
				"The Politics of Dancing",
				"Re-Flex", "New Wave",
				"455gfsG,HjkvD3");

		System.out.printf("%s\n", song3);

		// shows possibility for derived instance variables
		// generates a songId using title + artist
		// and "finds" genre by artist name
		Song song4 = new Song();
		song4.setTitle("Bright Lights");
		song4.setArtist("Spyro Gyra");
		song4.generateSongId();
		song4.findGenres();

		System.out.printf("%s\n", song4);

		//exact copy of above object
		Song song5 = new Song(song4);

		// test .equals()
		if (song4.equals(song5)) {
			
			System.out.printf("Song 4 and Song 5 are the same\n");
		}
	}
}
