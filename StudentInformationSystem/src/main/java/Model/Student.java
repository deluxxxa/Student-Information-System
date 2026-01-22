/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// FORDA BLUEPRINT 
package Model;

    // variables that gets the student information 
public class Student {
    private String id;
    private String name;
    private String email;
    private String gender;
    private String course;
    private String year;
    
    // The Constructor
    public Student(String id, String name, String email, String gender, String course, String year) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.course = course;
        this.year = year;
    }
    // The Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getGender() { return gender; }
    public String getCourse() { return course; }
    public String getYear() { return year; }
}