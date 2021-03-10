package tn.esprit.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Getter
@Setter

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Please provide your first name")
    private String firstname;
    @NotEmpty(message = "Please provide your last name")
    private String lastname;
    @NotEmpty(message = "Please provide your password")
    private String password;
    @NotEmpty(message="Please provide an e-mail")
    private String email;
    private int numtel;
    @NotEmpty(message="Please choose a Role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Temporal (TemporalType.DATE)
    private Date dateInscription;

    

//    @OneToMany(cascade = CascadeType.ALL,mappedBy="post")
//    private List<Post> post;







}
