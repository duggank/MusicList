public class Song implements Comparable <Song> {
  
  public String artist;
  public String name;
  public int year;
  public Double score;
  public String notes;
  // More fields here
  
  // Default constructor.. you'll need to modify this
  public Song(String artist, String name, int year, Double score, String notes) { 
    this.artist = artist;
    this.name = name;
    this.year = year;
    this.score = score;
    this.notes = notes;
    
  }
  
  /* ADD YOUR CODE HERE */
  
  public int compareTo (Song other)
  {
    // -1 is if this song comes before the other song
    // 0 if they are equal
    // 1 if this song comes after the other song
    // compare this.name to other.name
    return other.name.compareTo(this.name);
  }
  
}
