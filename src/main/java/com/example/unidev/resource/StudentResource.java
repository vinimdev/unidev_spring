package com.example.unidev.resource;

import com.example.unidev.entity.Student;
import com.example.unidev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> listar() {
        return ResponseEntity.ok().body(studentService.list());
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student student) {
        student = studentService.save(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId())
                .toUri();

        return ResponseEntity.created(uri).body(student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student student) {
        Student obj = studentService.findById(id);

        obj.setCpf(student.getCpf());
        obj.setName(student.getName());
        obj.setLastName(student.getLastName());
        obj.setTelephones(student.getTelephones());

        return ResponseEntity.ok().body(studentService.save(obj));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
