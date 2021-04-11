package tn.esb.lbc.electionsapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.lbc.electionsapi.Domain.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
