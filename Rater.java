import java.util.*;
public class Rater {
    private String myName;
    private ArrayList<Rating> myRatings;
    private int type=1 ;
    /*
     	1 for viewer; 
     	2 for critic
    */

    public Rater(String id) {
        myName = id;
        myRatings = new ArrayList<Rating>();
    }

    public void addRating(String item, double rating) {
    	if(this.numRatings()==3)
    		type=2 ;
    	// When user becomes critic
    	if(this.type==2)
    		myRatings.add(new Rating(item,2*rating));
    	myRatings.add(new Rating(item,rating));
    	
    }

    public boolean hasRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return true;
            }
        }
        
        return false;
    }

    public String getID() {
        return myName;
    }

    public double getRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return myRatings.get(k).getValue();
            }
        }
        
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        
        return list;
    }
}
