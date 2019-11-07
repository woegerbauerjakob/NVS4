package at.htl.person.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private LocalDate dob = LocalDate.now();

    public Person(){}
    public Person(Long id, String name, LocalDate dob)
    {
        this.id = id;
        this.dob = dob;
        this.name = name;
    }
    public Person(String name){
        this.name = name;
    }

    ///region Getter and Setter
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name = name;
    }
    public LocalDate getdob(){
        return dob;
    }
    public void setdob(LocalDate dob){
        this.dob = dob;
    }
    ///end region Getter and Setter

    public String toString()
    {
        return id.toString() + name + dob.format(DateTimeFormatter.ofPattern("DD.MM.YYYY"));
    }
}
