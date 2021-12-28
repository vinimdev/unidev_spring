package com.example.unidev.service;

import com.example.unidev.entity.Student;
import com.example.unidev.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

}
