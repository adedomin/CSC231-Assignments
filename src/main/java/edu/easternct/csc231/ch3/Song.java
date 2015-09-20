package edu.easternct.csc231.ch3;

import java.io.Serializable;
import java.util.List;

/**
 * Song object used to describe a track 
 * for sale on a website
 * <p>
 * Also includes links to other songs
 *
 * @author Anthony DeDominic
 */
public class Song implements Serializable {

	static final long serialVersionUID;

	// database ID of song
	private String songId;
	// title of song
	private String title;
	// artist of song
	private String artist;
	// genre of song
	private String genre;
	// User's who liked this song
	// liked these other songs
	// collection of db ids
	// points to other Song objects
	private List<String> suggestedSongs;
	
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
			List<String> suggestedSongs) {
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
				"Song ID: %s\nTitle: %s\nArtist: %s\nGenre: %s",
				songId, title, artist, genre);
	}

	/**
	 * insert song into suggested list
	 *
	 * @param songId the id to insert
	 */
	public void insertSuggestedSong(String songId)
	{
		suggestedSongs.add(songId);
	}

	/**
	 * remove first occurance of songId
	 * from suggested list
	 * 
	 * @param songId the id to remove
	 */
	public void removeSuggestedSong(String songId)
	{
		suggestedSongs.remove(songId);
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
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the suggestedSongs
	 */
	public List<String> getSuggestedSongs() {
		return suggestedSongs;
	}

	/**
	 * @param suggestedSongs the suggestedSongs to set
	 */
	public void setSuggestedSongs(List<String> suggestedSongs) {
		this.suggestedSongs = suggestedSongs;
	}
}
