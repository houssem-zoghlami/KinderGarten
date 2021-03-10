package tn.esprit.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Getter
@Setter

public class Kindergarten implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String email;
    private String description;
    private String address;
    private int nombreemploye;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<User> user;
//
//    @OneToMany(cascade = CascadeType.ALL,mappedBy="child")
//    private List<Child> child;






}
