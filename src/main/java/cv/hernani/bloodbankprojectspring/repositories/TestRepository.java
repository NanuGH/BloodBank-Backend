package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import cv.hernani.bloodbankprojectspring.models.PersonModel;

public interface TestRepository extends JpaRepository<PersonModel, UUID> {

  /*   interface tRepositoryQuery {
        List<PersonModel> findPersonBy(String namePerson, String surnamePerson);
    }

    @Repository
    class tRepositoryImpl implements tRepositoryQuery {

        EntityManager em;

        // constructor
        @Override
        public List<PersonModel> findPersonBy(String namePerson, String surnamePerson) {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PersonModel> cq = cb.createQuery(PersonModel.class);

            Root<PersonModel> book = cq.from(PersonModel.class);
            Predicate NamePredicate = cb.equal(book.get("namePerson"), namePerson);
            Predicate SurnamePredicate = cb.like(book.get("surnamePerson"),
                    "%" + surnamePerson + "%");
            cq.where(NamePredicate, SurnamePredicate);

            TypedQuery<PersonModel> query = em.createQuery(cq);
            return query.getResultList();

        } */

    }


