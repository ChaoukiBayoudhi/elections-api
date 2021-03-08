package tn.esb.lbc.electionsapi.Domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
//@Getter
//@Setter
//@EqualsAndHashCode
//@NoArgsConstructor
@Data
@AllArgsConstructor
@Embeddable
public class ElectorListId implements Serializable {
    @Column(name="elector_id")
    private Long electorId;
    @Column(name="list_elector_id")
    private Long listId;
}
