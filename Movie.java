public class Movie {
    
    private String title;
    private int year;
    private String genres;

    public Movie (String aTitle, String aYear, String theGenres) {
        title = aTitle;
        year = Integer.parseInt(aYear);
        genres = theGenres;
    }

    public String getTitle () {
        return title;
    }

    public int getYear () {
        return year;
    }

    public String getGenres () {
        return genres;
    }
}
