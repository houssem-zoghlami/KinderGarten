package tn.esprit.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter

public class Post implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String contained;
    private Integer likeCount = 0;

//    @ManyToOne
//     User user;
//

}
