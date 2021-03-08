package tn.esb.lbc.electionsapi.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ElectorList {
    @EmbeddedId //composite primary key
    private ElectorListId id;
    private float score;
    @ManyToOne
    @MapsId("electorId")
    private Elector elector;

    @ManyToOne
    @MapsId("listId")
    private CandidatesList list;
}
