package tn.esb.lbc.electionsapi.Domain;

import lombok.NonNull;
import tn.esb.lbc.electionsapi.Enumerations.JustificationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity

public class Justification {
    @Id @GeneratedValue
    private Long code;
    @NonNull //champ obligatoire
    @Lob
    private byte[] content;
    private JustificationType type;
}
