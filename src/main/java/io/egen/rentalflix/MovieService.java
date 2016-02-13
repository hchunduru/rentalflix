package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Synchronized;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
    List<Movie> movielist= new ArrayList<Movie>();


	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return movielist;
	}

	@Override
	public List<Movie> findByName(String name) {
		// TODO Auto-generated method stub
		
		List<Movie> cinema=new ArrayList<Movie>();
		String str_regex="\\b"+name+"\\b";
		Pattern p=Pattern.compile(str_regex);
		for(Movie mov:movielist){
			Matcher m=p.matcher(mov.getTitle());
			if(m.find())
				cinema.add(mov)	;
			else throw new IllegalArgumentException("This movie with "+name+"is not present in the list");
		}

		return cinema;
	}

	@Override
	@Synchronized
	public Movie create(Movie movie) {
		// TODO Auto-generated method stub
	movielist.add(movie);

		return movie;
		}

	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub

		for (Movie mov:movielist){
			if(mov.getId().equals(movie.getId())){
				Collections.replaceAll(movielist, mov, movie);
				}
			else throw new IllegalArgumentException("This movie is not present in the list");
		}
		if(movielist.contains(movie))
		return movie;
		else
	    return null;
	}

	@Override
	public Movie delete(int id2) {
		// TODO Auto-generated method stub
		String id=Integer.toString(id2);
		Movie mv=new Movie();
		for (Movie mov:movielist){
			if(mov.getId().equals(id)){
				movielist.remove(mov);
				mv=mov;
				}else
	  throw new IllegalArgumentException("This movie with "+id+"is not present in the list");
}
		return mv;
	}

	@Override
	public boolean rentMovie(int Id, String user) {
		// TODO Auto-generated method stub]
		String movieId=Integer.toString(Id);
		for (Movie mov:movielist){
			if(mov.getId().equals(movieId)){
				if(mov.getRented_by()==null) {
				    mov.setRented_by(user);
				       return true;
				}else
				{
					throw new IllegalArgumentException("This movie is already rented by a user");
				}
		    }

		}
		return false;
	}

}
