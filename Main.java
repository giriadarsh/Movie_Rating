import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.*;
import java.util.Map.Entry;
public class Main {

	
	public static int avgRating(String title, ArrayList <Rater> myRaters)
	{
		System.out.println("Enter the name of movie to get the avgRating ");
		int score=0 ;
		int numRaters=1 ;
		for(Rater rater: myRaters)
		{
			if(rater.hasRating(title))
			{
				score+=rater.getRating(title) ;
				numRaters++ ;
			}
		}
		int avgRating = score/numRaters ;
		return avgRating;		
	}
	
	public static int avgCriticRating(String title, ArrayList <Rater> myRaters)
	{
		System.out.println("Enter the name of movie to get the avgRating ");
		int score=0 ;
		int numRaters=1 ;
		for(Rater rater: myRaters)
		{
			if(rater.hasRating(title) && rater.numRatings()>=3)
			{
				score+=rater.getRating(title) ;
				numRaters++ ;
			}
		}
		int avgRating = score/numRaters ;
		return avgRating;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in) ;
		ArrayList <Movie> myMovies = new ArrayList <Movie>();
		ArrayList <Rater> myRaters = new ArrayList <Rater>();
		
		int choice ;
		while(true)
		{	
			System.out.println("Enter Suitable choice\n1. Onboard movies\n2. Add Users\n3. Add reviews");
			choice = in.nextInt() ;
			switch(choice)
			{
			case 1:
			{
				
				System.out.println("Enter title,year and genre of the movie");
				String title = in.next() ;
				//System.out.println("Enter year of the movie");
				String year = in.next() ;
				//System.out.println("Enter genre of the movie");
				String Genre = in.next() ;
				myMovies.add(new Movie(title,year,Genre)) ;
				break ;
			}
			case 2:
			{
				System.out.println("Enter user's name");
				String name = in.next() ;
				myRaters.add(new Rater(name)) ;
				break ;
				
			}
			case 3:
			{
				boolean flag=true ;// whether this data is to be stored or not based on exception
				System.out.println("Enter user's name, title and user's rating to the movie");
				String name = in.next() ;
				//System.out.println("Enter title of the movie");
				String title = in.next() ;
				//System.out.println("Enter user's rating to the movie");
				int rating = in.nextInt() ;
				
				for(Movie movie: myMovies)
				{
					if(movie.getTitle().equalsIgnoreCase(title))
					{
						if(movie.getYear()>=2021) {
							System.out.println("Exception movie yet to be released");
							flag = false ;
						}
					}
				}
				
				int numRating=0 ;
				for(Rater rater: myRaters)
				{
					if(rater.getID().equalsIgnoreCase(name))
					{
						numRating = rater.numRatings() ;
						if(rater.hasRating(title))
						{
							System.out.println("Exception multiple reviews not allowed");
							flag = false ;
						}
					}
				}
				
				if(rating<1 || rating>10)
				{
					System.out.println("Exception rating value can not be less than 1 or greater than 10");
					flag = false ;
				}
				
				if(flag)
				{
					for(Rater rater: myRaters)
					{
						if(rater.getID().equalsIgnoreCase(name))
						{
							rater.addRating(title, rating);
						}
					}
						
					if(numRating==2)
						System.out.println("Since "+name+" has published 3 reviews, he is promoted to ‘critic’ now");
				}
				
				break ;
			}
			
			case 4:
			{
				System.out.println("Enter the name of movie to get the avgRating ");
				String title = in.next() ;
				System.out.println("avgRating for movie "+title+"is "+avgRating(title,myRaters));
			}
			
			case 5:
			{
				int total=0 ;
				int num=0 ;
				System.out.println("Enter year to get the average review score in that particular year of release.");
				int year = in.nextInt() ;
				for(Movie movie: myMovies)
				{
					if(movie.getYear()==year)
					{
						total+=avgRating(movie.getTitle(),myRaters) ;
						num++ ;
					}
				}
				System.out.println("avgRating for year "+year+"is "+total/num);
			}
			
			case 6:
			{
				System.out.println("Enter genre of the movie.");
				String genre = in.next() ;
				HashMap<String, Integer> map = new HashMap<>();
				
				for(Movie movie : myMovies)
				{
					if(movie.getGenres().equalsIgnoreCase(genre))
					{
						map.put(movie.getTitle(), avgCriticRating(movie.getTitle(),myRaters)) ;
					}
				}
				
				Set<Entry<String, Integer>> set = map.entrySet();
		        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(
		                set);
		        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
		            public int compare(Map.Entry<String, Integer> o1,
		                    Map.Entry<String, Integer> o2) {
		                return o1.getValue().compareTo(o2.getValue());
		            }
		        });

		        for (Entry<String, Integer> entry : list) {
		            System.out.println(entry.getKey());

		        }

				
			}
			
			}
		}

	}

}
