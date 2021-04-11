package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publication implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDateTime date;
	private String description;
	private String attachment;
	private LocalDateTime modifyDate;
	private Integer voteCount = 0;



	@ManyToOne
	@JsonIgnore
	private User user;


	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publication")
	private Set<Comment> comments;

}
