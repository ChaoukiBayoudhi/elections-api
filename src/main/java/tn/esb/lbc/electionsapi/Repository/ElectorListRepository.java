package tn.esb.lbc.electionsapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esb.lbc.electionsapi.Domain.ElectorList;
import tn.esb.lbc.electionsapi.Domain.ElectorListId;

public interface ElectorListRepository extends JpaRepository<ElectorList, ElectorListId> {
}
