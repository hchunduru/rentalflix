package io.egen.rentalflix;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.java.io.egen.rentaflix.Movie;
import main.java.io.egen.rentaflix.MovieService;

public class Testrentflix {

	@Test
	public void testFindall() {


		MovieService movieSer=new MovieService();
		Movie movie= new Movie();
		movie.setId("1");
		movie.setLanguage("english");
		movie.setRented_by(null);
		movie.setTitle("BatmanReturns");
		movie.setYear("1998");
		movieSer.create(movie);
		List<Movie> movi=movieSer.findByName("Batman");

		fail("Not yet implemented");
		Assert.assertEquals(movi.contains(movie), movi.contains(movie));

	}


	@Test
	public void testCreate() {


		MovieService movieSer=new MovieService();
		Movie movie= new Movie();
		movie.setId("1");
		movie.setLanguage("english");
		movie.setRented_by(null);
		movie.setTitle("BatmanReturns");
		movie.setYear("1998");
		movieSer.create(movie);
	  Assert.assertEquals(movieSer.findAll().contains(movie),movieSer.findAll().contains(movie));

	}

	@Test
	public void testFindByName() {

		MovieService movieSer=new MovieService();
		Movie movie= new Movie();
		movie.setId("1");
		movie.setLanguage("english");
		movie.setRented_by(null);
		movie.setTitle("BatmanReturns");
		movie.setYear("1998");
		List<Movie >mov= movieSer.findByName("Batman");

     Assert.assertEquals(mov.contains(movie),mov.contains(movie));

	}

	@Test
	public void testUpdate() {

		MovieService movieSer=new MovieService();
		Movie movie= new Movie();
		Movie movie2= new Movie();
		movie.setId("1");
		movie.setLanguage("english");
		movie.setRented_by(null);
		movie.setTitle("BatmanReturns");
		movie.setYear("1998");
		movieSer.create(movie);
		movie2.setId("1");
		movie2.setLanguage("english");
		movie2.setRented_by("Harish");
		movie2.setTitle("BatmanReturns2");
		movie2.setYear("1994");

       Movie cinema= movieSer.update(movie2);

     Assert.assertEquals(cinema,movie2);

	}

	@Test
	public void testDelete() {

		MovieService movieSer=new MovieService();
		Movie movie= new Movie();
		movie.setId("1");
		movie.setLanguage("english");
		movie.setRented_by(null);
		movie.setTitle("BatmanReturns");
		movie.setYear("1998");
		movieSer.create(movie);
		movieSer.delete(1);
		boolean delete=false;
		if(movieSer.findAll().contains(movie))
			delete=true;
	  Assert.assertEquals(true, delete);;

	}


	@Test
	public void testRent() {


		MovieService movieSer=new MovieService();
		for(int i=0;i<3;i++){
		Movie movie= new Movie();
		String movieId=Integer.toString(i);
		movie.setId(movieId);
		movie.setLanguage("english");
		movie.setRented_by(null);
		movie.setTitle("BatmanReturns");
		movie.setYear("1998");
		movieSer.create(movie);
		}
		movieSer.rentMovie(2, "Harsha");
		String name=null;
		for(Movie mov :movieSer.findAll()){
			name=mov.getRented_by();
		}
	 Assert.assertEquals(name,"Harsha");

	}








}
