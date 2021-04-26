package tn.esb.lbc.electionsapi.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esb.lbc.electionsapi.Enumerations.ActivityType;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime activityDate;
    private double duration;
    private String place;
    @NonNull
    @Enumerated(EnumType.STRING)
    private ActivityType type;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="candidate_id",referencedColumnName = "id")
    private Candidate candidateOwner;
    @JsonIgnore
    @OneToOne
    private Justification activityJustification;

    public Activity(@NonNull String title, @NonNull LocalDateTime activityDate, double duration, String place, @NonNull ActivityType type) {
        this.title = title;
        this.activityDate = activityDate;
        this.duration = duration;
        this.place = place;
        this.type = type;
    }

    public Activity(@NonNull String title, @NonNull LocalDateTime activityDate, double duration, String place, @NonNull ActivityType type, Candidate candidateOwner, Justification activityJustification) {
        this.title = title;
        this.activityDate = activityDate;
        this.duration = duration;
        this.place = place;
        this.type = type;
        this.candidateOwner = candidateOwner;
        this.activityJustification = activityJustification;
    }
}
