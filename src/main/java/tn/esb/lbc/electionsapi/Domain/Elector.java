package tn.esb.lbc.electionsapi.Domain;

import lombok.*;
import tn.esb.lbc.electionsapi.Enumerations.Level;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Elector {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private int age;
    private String state;
    private Level scientificLevel;
    @ManyToMany
    private Set<Candidate> candidates =new HashSet<>();

}
