package tn.esb.lbc.electionsapi.Domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"electionSymbol","slogan"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CandidatesList {
    @Id
    @GeneratedValue
    private Long id;
    @EqualsAndHashCode.Include
    private String name;
    private String slogan;
    @EqualsAndHashCode.Include
    private String state;
    private String electionStatement;
    private byte[] electionSymbol;
}
