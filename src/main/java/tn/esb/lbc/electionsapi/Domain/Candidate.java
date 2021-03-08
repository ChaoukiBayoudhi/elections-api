package tn.esb.lbc.electionsapi.Domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor //generates a constructon without parameters
@RequiredArgsConstructor

//@AllArgsConstructor //generates constructor with all attributes as parameters
@Data //generates all getters and setters
//@Getter //generates only getters
//@Setter //generates only seeters
//@ToString //returns all attributes values
@ToString(exclude = "photo") //return all attributes but no photo
//@EqualsAndHashCode //compares tow candidates using all attributes
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//compares candidates using
                               // only attributes with include annotation
@Entity //Candiadate will be a relationnal table
//@Document dans le cas de Mongodb
@Table(name="candidate_tab")//specify some properties about the relationnal table
//like its name, uniquecontraints,....
public class Candidate {
    @Id //the propertie "id" is primary key
    @GeneratedValue   //the primary key is auto-generated ( default strategy is identity)
    //identity sarts with 1 and inrements by 1 each time
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private LocalDate birthDate;
    private int listPosition;
    private byte[] photo;
    /*Create table Candidate_Openion(
       candidate_id Number,
       elector_id Number,
       constraint pk_candelect primary key(id_Elect, id_cand)
       constraint fk_candelect_candidate Foreign key candidate_id references Candidate(id)
       constraint fk_candelect_elector Foreign key elector_id references Elector(id)
);
*/
    @ManyToMany
    @JoinTable(name = "Candidate_Openion",
    joinColumns = @JoinColumn(name="candidate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "elector_id", referencedColumnName = "id")
    )
    private Set<Elector> electors=new HashSet<>();
    @OneToMany(mappedBy = "candidateOwner", cascade = CascadeType.ALL)
    private Set<Activity> activities=new HashSet<>();
    @ManyToOne
    @JoinColumn(name="List_id", referencedColumnName = "id")
    private CandidatesList listOfCandidate;

}
