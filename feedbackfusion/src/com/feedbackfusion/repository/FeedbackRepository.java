package com.feedbackfusion.repository;

import com.feedbackfusion.model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository (DAO) class responsible for performing CRUD (Create, Read, Update, Delete)
 * operations on the {@code feedback} database table.
 * <p>
 * This class interacts directly with the database using JDBC and provides methods
 * to insert, fetch, update, and delete feedback records.
 * </p>
 *
 * <h2>Responsibilities:</h2>
 * <ul>
 *     <li>Create new feedback entries.</li>
 *     <li>Fetch all feedback records from the table.</li>
 *     <li>Update existing feedback entries.</li>
 *     <li>Delete feedback records by ID.</li>
 * </ul>
 *
 * <h2>Dependencies:</h2>
 * <ul>
 *     <li>{@link DBConnection} for managing database connections.</li>
 *     <li>{@link Feedback} model class for mapping database rows to Java objects.</li>
 * </ul>
 */
public class FeedbackRepository {

    /**
     * Inserts a new feedback record into the database.
     *
     * @param feedback the {@link Feedback} object containing feedback details.
     * @throws SQLException if a database access error occurs or SQL execution fails.
     */
    public void create(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO feedback (feedback_type, rating, comments) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, feedback.getFeedbackType());
            ps.setInt(2, feedback.getRating());
            ps.setString(3, feedback.getComments());
            ps.executeUpdate();
        }
    }

    /**
     * Retrieves all feedback records from the database, ordered by descending ID.
     *
     * @return a {@link List} of {@link Feedback} objects.
     * @throws SQLException if a database access error occurs or SQL execution fails.
     */
    public List<Feedback> findAll() throws SQLException {
        String sql = "SELECT id, feedback_type, rating, comments FROM feedback ORDER BY id DESC";
        List<Feedback> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Feedback(
                        rs.getInt("id"),
                        rs.getString("feedback_type"),
                        rs.getInt("rating"),
                        rs.getString("comments")
                ));
            }
        }
        return list;
    }

    /**
     * Updates an existing feedback record in the database.
     *
     * @param feedback the {@link Feedback} object containing updated details.
     *                 The {@code id} must not be null, as it identifies the record to update.
     * @throws SQLException if a database access error occurs or SQL execution fails.
     */
    public void update(Feedback feedback) throws SQLException {
        String sql = "UPDATE feedback SET feedback_type = ?, rating = ?, comments = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, feedback.getFeedbackType());
            ps.setInt(2, feedback.getRating());
            ps.setString(3, feedback.getComments());
            ps.setInt(4, feedback.getId());
            ps.executeUpdate();
        }
    }

    /**
     * Deletes a feedback record from the database by its ID.
     *
     * @param id the unique identifier of the feedback record to delete.
     * @throws SQLException if a database access error occurs or SQL execution fails.
     */
    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM feedback WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
