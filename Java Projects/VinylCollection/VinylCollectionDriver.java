
/**
 * VinylCollectionDriver.java - A class that demonstrates the class VinylCollection
 *
 * @author Roni Kulkarni
 * @version 1.0.0
 */
public class VinylCollectionDriver
{
 
   public static void main(String[] args)
   {
       VinylCollection myVinylCollection = new VinylCollection();

       //Test collection that is empty by calling methods on it
       myVinylCollection.displayEntireCollection();
       myVinylCollection.removeRandomRecord();
       myVinylCollection.getArtistWithMostRecords();
       
       //add vinylRecords to using a VinylRecord() helper method
       addVinylRecord(new VinylRecord("Abbey Road", "The Beatles", "Rock"), myVinylCollection);
       addVinylRecord(new VinylRecord("Let It Be", "The Beatles", "Rock"), myVinylCollection);
       addVinylRecord(new VinylRecord("Help!", "The Beatles", "Rock"), myVinylCollection);
       addVinylRecord(new VinylRecord("Yellow Submarine", "The Beatles", "Rock"), myVinylCollection);
       addVinylRecord(new VinylRecord("A Hard Day's Night", "The Beatles", "Rock"), myVinylCollection);
       addVinylRecord(new VinylRecord("Four", "One Direction", "Pop"), myVinylCollection);
       addVinylRecord(new VinylRecord("Midnights", "Taylor Swift", "Country"), myVinylCollection, 3); // add multiple copies
       addVinylRecord(new VinylRecord("Elevate", "Big Time Rush", "Pop"), myVinylCollection, 4); // add multiple copies
       
       // Print all the album details
       myVinylCollection.displayEntireCollection();

       // Get Artist with most albums
       myVinylCollection.getArtistWithMostRecords();

       // Remove a specific record
       VinylRecord removeRecord = new VinylRecord("Elevate", "Big Time Rush", "Pop");
       myVinylCollection.removeSpecificRecord(removeRecord);

       // Print all the album details after removing specific record
       myVinylCollection.displayEntireCollection();
  
       // Remove a random record
       myVinylCollection.removeRandomRecord();

       // Print all the album details after removing random record
       myVinylCollection.displayEntireCollection();

   }

   // addVinylRecord -- add a VinylRecord to the collection
   // Accept vinylrecord and vinylrecord collection as input parameters
   public static void addVinylRecord(VinylRecord aVinylRecord, VinylCollection aVinylRecordCollection)
   {
       if(aVinylRecordCollection.add(aVinylRecord))
           System.out.println("Added " + aVinylRecord.getAlbumTitle() + " to the collection.");
       else
           System.out.println("Tried to add a " + aVinylRecord.getAlbumTitle() + ", but couldn't");
    }

   // addVinylRecord -- overloaded method to add multiple copies of a VinylRecord to the collection
   // Accept vinylrecord, vinylrecord collection, and copies as input parameters
   public static void addVinylRecord(VinylRecord aVinylRecord, VinylCollection aVinylRecordCollection, int copies)
   {
       if (copies <= 1)
       {
            System.out.println("Copies has to be greater than 1");
            return;
       }     
       if(aVinylRecordCollection.addMultiple(aVinylRecord, copies))
           System.out.println("Added " + copies + " copies of" + aVinylRecord.getAlbumTitle() + ".");
       else
           System.out.println("Tried to add copies of " + aVinylRecord.getAlbumTitle() + ", but could not.");
    }

}
