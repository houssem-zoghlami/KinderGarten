package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idComment;
	@Column(name= "createDate")
	private LocalDateTime createDate;
	@NotNull
	@Lob
	private String text;


	@Column(name= "modifyDate")
	private LocalDateTime modifyDate;
	@ManyToOne
	@JsonIgnore
	private User user;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Publication_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Publication publication;





}