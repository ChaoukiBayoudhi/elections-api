package tn.esb.lbc.electionsapi.Domain;

import lombok.NonNull;
import tn.esb.lbc.electionsapi.Enumerations.JustificationType;

import javax.persistence.*;

@Entity

public class Justification {
    @Id @GeneratedValue
    private Long code;
    @NonNull //champ obligatoire
    @Lob
    private byte[] content;
    private JustificationType type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;
}
