package DAO;

import java.util.List;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Review;


public interface ReviewDAO extends GenericDAO<Review, Integer> {
	List<Review> getReviewsFromDriver(Driver driver) throws Exception;
}
