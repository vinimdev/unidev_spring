package com.example.unidev.entity;

import com.example.unidev.core.entity.AbstractEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String lastName;

    private String cpf;

    @ElementCollection
    @CollectionTable(name = "TELEPHONE")
    private Set<String> telephones = new HashSet<>();

    public Student() {
    }

    public Student(String name, String lastName, String cpf) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(Set<String> telephones) {
        this.telephones = telephones;
    }
}
