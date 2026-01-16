/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.DBConnection;
import Model.Student;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentDAO {
    
    public boolean isNameDuplicate(String name) {
        String sql = "SELECT COUNT(*) FROM students WHERE name = ?";
        try (Connection con = DBConnection.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Returns true if name exists
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return false;
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (id_number, name, email, gender, course, year_level) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, student.getId());
            pst.setString(2, student.getName());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getGender());
            pst.setString(5, student.getCourse());
            pst.setString(6, student.getYear());
            pst.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, email=?, gender=?, course=?, year_level=? WHERE id_number=?";
        try (Connection con = DBConnection.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setString(3, student.getGender());
            pst.setString(4, student.getCourse());
            pst.setString(5, student.getYear());
            pst.setString(6, student.getId());
            pst.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deleteStudent(String id) {
        String sql = "DELETE FROM students WHERE id_number=?";
        try (Connection con = DBConnection.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public DefaultTableModel searchStudents(String query) {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"ID Number", "Name", "Email", "Gender", "Course", "Year Level"}, 0);
    
    // Updated SQL to include Course and Year Level search
        String sql = "SELECT * FROM students WHERE " +
                    "id_number LIKE ? OR " +
                    "name LIKE ? OR " +
                    "course LIKE ? OR " +
                    "year_level LIKE ? " +
                    "ORDER BY id_number ASC";
                 
        try (Connection con = DBConnection.getConnection(); 
            PreparedStatement pst = con.prepareStatement(sql)) {
        
           String searchPattern = "%" + query + "%";
           pst.setString(1, searchPattern);
           pst.setString(2, searchPattern);
           pst.setString(3, searchPattern);
           pst.setString(4, searchPattern);
        
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_number"), rs.getString("name"), 
                    rs.getString("email"), rs.getString("gender"), 
                    rs.getString("course"), rs.getString("year_level")
                });
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return model;
    }
}