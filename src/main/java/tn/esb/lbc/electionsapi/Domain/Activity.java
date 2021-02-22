package tn.esb.lbc.electionsapi.Domain;

import lombok.*;
import tn.esb.lbc.electionsapi.Enumerations.ActivityType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    @EqualsAndHashCode.Include
    private String title;
    @EqualsAndHashCode.Include
    private LocalDateTime activityDate;
    private double duration;
    private String place;
    private ActivityType type;
}
