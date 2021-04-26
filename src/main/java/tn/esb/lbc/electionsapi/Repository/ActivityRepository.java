package tn.esb.lbc.electionsapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.lbc.electionsapi.Domain.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    //ORM :Object Relational Mapper
    //CRUD : CREATE READ UPDATE and DELETE
    //Quelques méthodes de l'interface JpaRepository
    //en SQL : insert into ... values()<==>T save(T obj)
    //en SQL :select * from activity where id=10 <==> findById(S id)
    //List<T> findAll() <==> en SQL : select * from T
    //void DeleteById(S id) <==> en SQL : delete from T where id=10;
    // La methode "save" joue double rôle : si l'id de l'objet passé en paramètre
    //existe déjà alors c'est un update, sinon c'est un ajout (ajout d'une nouvelle ligne dans la table associée)

}
