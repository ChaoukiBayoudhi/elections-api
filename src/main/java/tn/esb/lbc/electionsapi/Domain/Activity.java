package tn.esb.lbc.electionsapi.Domain;

import lombok.*;
import tn.esb.lbc.electionsapi.Enumerations.ActivityType;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@RequiredArgsConstructor //add a contructor with only nonNull attributs
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String title;
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDateTime activityDate;
    private double duration;
    private String place;
    @NonNull
    private ActivityType type;

    @ManyToOne
    @JoinColumn(name="candidate_id",referencedColumnName = "id")
    private Candidate candidateOwner;
    @OneToOne
    private Justification activityJustification;

    public Activity(@NonNull String title, @NonNull LocalDateTime activityDate, double duration, String place, @NonNull ActivityType type) {
        this.title = title;
        this.activityDate = activityDate;
        this.duration = duration;
        this.place = place;
        this.type = type;
    }
}
