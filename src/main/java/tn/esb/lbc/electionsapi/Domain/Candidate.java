package tn.esb.lbc.electionsapi.Domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
@NoArgsConstructor //generates a constructon without parameters
@AllArgsConstructor //generates constructor with all attributes as parameters
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
    private String name;
    private LocalDate birthDate;
    private int listPosition;
    private byte[] photo;

}
