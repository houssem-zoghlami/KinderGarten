package tn.esprit.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter

public class Post implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String contained;
    private Integer likeCount = 0;

//    @ManyToOne
//     User user;
//

}
