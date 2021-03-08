package tn.esb.lbc.electionsapi.Domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"electionSymbol","slogan"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CandidatesList {
    @Id
    @GeneratedValue
    private Long id;
    @EqualsAndHashCode.Include
    @NonNull
    private String name;
    private String slogan;
    @EqualsAndHashCode.Include
    @NonNull
    private String state;
    private String electionStatement;
    @Lob
    private byte[] electionSymbol;
}
