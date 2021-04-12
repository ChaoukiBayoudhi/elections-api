package tn.esb.lbc.electionsapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.lbc.electionsapi.Domain.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    //ORM :Object Relational Mapper

    //Quelques méthodes de l'interface JpaRepository
    //en SQL : insert into ... values()<==>T save(T obj)
    //en SQL :select * from activity where id=10 <==> findById(S id)

}
