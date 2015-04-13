import java.util.*;

public class MusicRunner
{
  // Get rid of double quotes and trim it
  public static String clean (String input)
  {
    return input.substring(1,input.length()-1);
  }
 
  public static void main (String[] args)
  {
    int count = 0;
    MusicReader mr = new MusicReader();
    MusicLibrary playlist = new MusicLibrary();
    mr.open("musiclist.csv");
   
    String[] data = mr.getSongData();
   
    // First line contains all the fields - We don't want to save this anywhere but we can
    // print it for now to see what information we have.
    System.out.println(Arrays.toString(data));
   
    data = mr.getSongData();  // Get next line of song data
   
    // if data is null then we were unable to read a line of song data, so
    // this loop will continue to read lines of song data as long as there
    // IS song data available
    while (data != null)
    {
      // You probably will comment this out but for now print out the line so you can see what is there
      //System.out.println(Arrays.toString(data));
      
      int year = Integer.parseInt(clean(data[3]));
      
      double score= Double.parseDouble(clean(data[4]));
     
      // Let's try to create a Song object
      Song song = new Song(clean(data[0]), clean(data[1]), year, score, clean(data[16]));  // data[0] is the artist and data[1] is the name
      
      String type = clean(data[2]);
      
      if (type.equals("song"))
      {   
        //songs.add(song);
        playlist.addSong(song);
        count++;
      }
            
                
                
      //System.out.println(song.artist);
      //System.out.println(clean(data[0]) + "," + (clean(data[1]) + "," + (clean(data
     
     
      if (count == 10)  // For now only read ONE song
        break;
     
      data = mr.getSongData();  // Get next line of song data
    }
    
    playlist.Sort();
    
    for( int i = playlist.count()-1; i >= 0; i--)
    {
      Song song = playlist.getSong(i);
      
      System.out.println("Artist: " + song.artist + ", Name: " + song.name + ", Year: " + song.year);
    }
    
    mr.close();
  }
}