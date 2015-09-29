package edu.easternct.csc231.ch4;

import java.util.Base64;

/**
 * Song object used to describe a track 
 * for sale on a website
 * <p>
 * Also includes links to other songs
 *
 * @author Anthony DeDominic
 */
public class Song {

	// emulate how a db can be used to
	// look up artist and their genre
	private void databaseEmulator()
	{
		if (this.artist.equals("Boards of Canada"))
		{
			insertGenre("Electronic");
			insertGenre("IDM");
		}
		else if (this.artist.equals("Spyro Gyra"))
		{
			insertGenre("Jazz");
			insertGenre("Jazz Fusion");
			insertGenre("Smooth Jazz");
		}
		else
		{
			insertGenre("UNKN");
		}
	}

	// database ID of song
	private String songId;
	// title of song
	private String title;
	// artist of song
	private String artist;
	// comma separated list
	// genre of song
	private String genre;
	// comma separated list
	// User's who liked this song
	// liked these other songs
	// collection of db ids
	// points to other Song objects
	private String suggestedSongs;

	/**
	 * empty constructor
	 * <p>
	 * sets strings to empty to prevent
	 * null dereference in .equals()
	 */
	public Song() {
		this.songId = "";
		this.title = "";
		this.artist = "";
		this.genre = "";
		this.suggestedSongs = "";
	}

	/**
	 * Full Constructor
	 *
	 * @param songId
	 * @param title
	 * @param artist
	 * @param genre
	 * @param suggestedSongs
	 */
	public Song(
			String songId, String title, 
			String artist, String genre, 
			String suggestedSongs) {
		this.songId = songId;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.suggestedSongs = suggestedSongs;
	}

	/**
	 * Copy Constructor
	 */
	public Song(Song song)
	{
		// note strings are immutable
		// so even though this is copy by ref
		// it's safe.
		this.songId = song.getSongId();
		this.title  = song.getTitle();
		this.artist = song.getArtist();
		this.genre  = song.getGenre();
		this.suggestedSongs = song.getSuggestedSongs();
	}

	/**
	 * string representation of object
	 */
	public String toString()
	{
		// getters tested now...
		return String.format(
				"Song ID: %s\nTitle: %s\nArtist: %s\nGenre: %s\nSuggested Songs: %s\n",
				this.getSongId(), this.getTitle(), 
				this.getArtist(), this.getGenre(),
				this.getSuggestedSongs());
	}

	/**
	 * checks if object is an exact clone
	 *
	 * @param rh object being compared
	 * @return true if objects have the same data
	 */
	public boolean equals(Song rh)
	{
		return (this.songId.equals(rh.getSongId()) &&
				this.title.equals(rh.getTitle()) &&
				this.artist.equals(rh.getArtist()) &&
				this.genre.equals(rh.getGenre()) &&
				this.suggestedSongs.equals(rh.getSuggestedSongs()));
	}

	/**
	 * inserts a genre to the song
	 *
	 * @param genre a genre to insert
	 */
	public void insertGenre(String genre) {

		// if genre is unset
		if (this.genre == null || 
			this.genre.isEmpty())
		{
			setGenre(genre);
			return;
		}
		// commas are the separator
		// prevent user from breaking 
		// stuff
		if (genre.contains(","))
		{
			return;
		}
		this.genre += ","+genre;
	}

	/**
	 * remove genre from genre list
	 *
	 * @param genre the genre to remove
	 */
	public void removeGenre(String genre) {
		
		// if genre unset, nothing to do
		if (this.genre == null ||
			this.genre.isEmpty())
		{ 
			return;
		}
		this.genre = this.genre.replaceAll(",?"+genre, "");
		// if removed element was the first one, then
		// leading comma will exist
		this.genre = this.genre.replaceAll("^,", "");
	}

	/**
	 * insert song id into suggested list
	 *
	 * @param songId the id to insert
	 */
	public void insertSuggestedSong(String songId) {

		// if SuggestedSongs unset, set it
		if (this.suggestedSongs == null ||
			this.suggestedSongs.isEmpty())
		{
			setSuggestedSongs(songId);
			return;
		}
		// commas are the separator
		// prevent user from breaking 
		// stuff
		if (songId.contains(","))
		{
			return;
		}
		this.suggestedSongs += ","+songId;
	}

	/**
	 * remove song id from suggested list
	 *
	 * @param songId song id to remove
	 */
	public void removeSuggestedSong(String songId) {
		
		// if unset, nothing to remove
		if (this.suggestedSongs == null ||
			this.suggestedSongs.isEmpty())
		{
			return;
		}
		this.suggestedSongs = 
			this.suggestedSongs.replaceAll(",?"+songId, "");
		// leading comma if first removed
		this.suggestedSongs = 
			this.suggestedSongs.replaceAll("^,", "");
	}

	/**
	 * @return the songId
	 */
	public String getSongId() {
		return songId;
	}

	/**
	 * @param songId the songId to set
	 */
	public void setSongId(String songId) {
		this.songId = songId;
	}

	/**
	 * generate a songId using artist:title
	 * <p>
	 * creates it using base64
	 */
	public void generateSongId() {

		this.songId = 
			Base64.getEncoder().encodeToString(
			this.artist
			.concat(":")
			.concat(this.title)
			.getBytes());
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * use insertGenre() instead
	 *
	 * @param genre the genre to set
	 */
	private void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the suggestedSongs
	 */
	public String getSuggestedSongs() {
		return suggestedSongs;
	}

	/**
	 * use insertSuggestedSong() instead
	 *
	 * @param suggestedSongs the suggestedSongs to set
	 */
	private void setSuggestedSongs(String suggestedSongs) {
		this.suggestedSongs = suggestedSongs;
	}

	/**
	 * find genres by using artist name
	 */
	public void findGenres() {

		if (this.artist == null ||
			this.artist.isEmpty())
		{
			return;
		}
		else
		{
			databaseEmulator();
		}
	}

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
