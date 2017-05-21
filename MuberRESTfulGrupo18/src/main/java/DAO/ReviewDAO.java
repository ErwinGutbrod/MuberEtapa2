package DAO;

import java.util.List;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;

public interface ReviewDAO extends GenericDAO<Review, Integer> {
	Review createReview(Travel travel, Passenger passenger);
	List<Review> getReviewsFromDriver(Driver driver) throws Exception;
}
