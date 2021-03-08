package tn.esb.lbc.electionsapi.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @OneToMany(mappedBy = "listOfCandidate", cascade = CascadeType.ALL)
    private Set<Candidate> canditates=new HashSet<>();
    @OneToMany(mappedBy = "list")
    private Set<ElectorList> lists=new HashSet<>();
}
