package DAO;

import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;

public interface ReviewDAO extends GenericDAO<Review, Integer> {
	Review createReview(Travel travel, Passenger passenger);
}
