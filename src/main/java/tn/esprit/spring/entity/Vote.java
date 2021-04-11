package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Vote {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer voteId;
    @Enumerated(EnumType.STRING)
    private VoteType voteType;

    @NotNull
    @ManyToOne(fetch = LAZY)
    private Publication publication;

    @OneToOne(fetch = LAZY)
    private User user;

}
