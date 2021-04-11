package tn.esb.lbc.electionsapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.lbc.electionsapi.Domain.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    //ORM :Object Relational Mapper
}
