package com.example.crudDemo.Dao;

import com.example.crudDemo.Entity.Instructor;
import com.example.crudDemo.Entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int id);
    void deleteById(int id);
    InstructorDetail findInstructorDetailById(int id);
}
