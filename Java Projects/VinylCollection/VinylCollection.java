
import java.util.HashMap;
import java.util.Map;

/**
 * VinylCollection.java - A class that implements a Vinyl Record  using a Bag
* @author Roni Kulkarni
* @version 1.0.0
 */

public class VinylCollection
{
    private final LinkedBag<VinylRecord> vinylRecords;
    
    // Constructor for vinylCollection
    public VinylCollection()
    {
        vinylRecords = new LinkedBag<>();     // initialize with any Bag implementation
    }
    
    // add() -- adds aVinylRecord to our VinylCollection. Accepts vinylRecord as input parameter
    //  @returns TRUE if successful, FALSE otherwise
    public boolean add(VinylRecord aVinylRecord)
    {
        return vinylRecords.add(aVinylRecord);
    }
    
   // addMultipleCopies() -- add multiple copies of aVinylRecord to our VinylCollection. Accepts vinylRecord and numCopies as input parameters
    //  @returns TRUE if successful, FALSE otherwise
    public boolean addMultiple(VinylRecord aVinylRecord, int numCopies)
    {
        return vinylRecords.addMultiple(aVinylRecord, numCopies);
    }


    // removeRandomRecord() -- remove random records from collection
    // @returns TRUE if successful, FALSE if the collection is empty
    public boolean removeRandomRecord()
    {
        //if vinylrecords is not empty
        if (!vinylRecords.isEmpty()) {
            vinylRecords.remove(); //remove record
            System.out.println("Removed random record from the collection.");
            return true;
        }
        else {
            System.out.println("Cannot remove random record. VinylRecord collection is empty.");
            return false;
        }
    }

    // removeSpecificRecord() -- remove specific records from collection
    // pass the VinylRecord to be removed as the input parameter
    // @returns TRUE if successful, FALSE if the collection is empty
    public boolean removeSpecificRecord(VinylRecord thisRecord)
    {
        //if vinylrecords is not empty
        if (!vinylRecords.isEmpty()) {
            System.out.println("Removed record " + thisRecord.getAlbumTitle() + " from the collection.");
            return vinylRecords.remove(thisRecord); //remove record
        } else {
            System.out.println("Cannot remove specific record. VinylRecord collection is empty.");
            return false;
        }
    
    }

    // displayEntireCollection() -- display the entire VinylRecords collection
    public void displayEntireCollection()
    {
        if (vinylRecords.isEmpty()){
            System.out.println("Cannot display the collection. The VinylRecords collection is empty.");
        } else
        {
            System.out.println("Displaying the entire collection:");
            Object[] recordsArray = vinylRecords.toArray(); //get VinylRecordsCollection as an array
            //loop through the array to display entire collection
            for (Object recordsArray1 : recordsArray) {
                System.out.println(recordsArray1);
            } // end for
            System.out.println("Total number of records in the VinylRecords collection: " + vinylRecords.getCurrentSize());
        }
    }
    
    // getArtistWithMostRecords -- get the artist with the most records in the collection
    // return String which contains the artist
    public String getArtistWithMostRecords()
    {
        int highestFrequency = 0;
        String mostPopular = "";

        if (vinylRecords.isEmpty()){
            System.out.println("Cannot get artist with the most records. The VinylRecords collection is empty.");
        } else
        {
            Object[] recordsArray = vinylRecords.toArray();
            
            // Use a hashmap to add artist as key and frequency as value
            Map<String, Integer> artistFrequency = new HashMap<>();
            for (Object recordsArray1 : recordsArray) {
               VinylRecord record = (VinylRecord)recordsArray1;
               // if artist is in the map increment the value by 1, else set default to 0
               artistFrequency.put(record.getArtist(), artistFrequency.getOrDefault(record.getArtist(), 0) + 1);
            }

            // Find the artist with maximum frequency
            for (Map.Entry<String, Integer> entry : artistFrequency.entrySet()) {
                if (entry.getValue() > highestFrequency) {
                    highestFrequency = entry.getValue();
                    mostPopular = entry.getKey();
                 }
            }
            System.out.println(mostPopular + " is the artist with the most records:  " + highestFrequency);
        }
        
        return mostPopular;
    }
    
}
