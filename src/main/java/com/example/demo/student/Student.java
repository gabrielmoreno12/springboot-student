package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity // Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados
@Table  // Especifica os detalhes da tabela, usando o nome padrão "student"
public class Student {

    @Id // Define o campo 'id' como a chave primária da entidade
    @SequenceGenerator(
            name = "student_sequence",  // Nome do gerador de sequência
            sequenceName = "student_sequence",  // Nome da sequência no banco de dados
            allocationSize = 1  // Incremento da sequência por vez
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // Estratégia de geração de valores de chave primária
            generator = "student_sequence"  // Nome do gerador a ser usado
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient  // Indica que este campo não será persistido no banco de dados
    private Integer age;

    public Student() { }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // Construtor sem 'id' (útil para criar novos estudantes)
    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // Calcula a idade com base na data de nascimento e na data atual
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age + '}';
    }

}
