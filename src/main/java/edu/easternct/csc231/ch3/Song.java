package edu.easternct.csc231.ch3;

/**
 * Song object used to describe a track 
 * for sale on a website
 * <p>
 * Also includes links to other songs
 *
 * @author Anthony DeDominic
 */
public class Song {

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
	 */
	public Song() {
	}

	/**
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
	 * string representation of object
	 */
	public String toString()
	{
		return String.format(
				"Song ID: %s\nTitle: %s\nArtist: %s\nGenre: %s\nSuggested Songs: %s\n",
				songId, title, 
				artist, genre,
				suggestedSongs);
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

		System.out.printf("%s", song3);
	}
}
