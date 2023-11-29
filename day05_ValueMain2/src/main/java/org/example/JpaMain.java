package org.example;

import org.example.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();


        try {
//           // Criteria 사용 준비
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            Root<Member> m = query.from(Member.class);
//
//            CriteriaQuery<Member> cq =  query.select(m);
//
//            String username = "dsafas";
//            if(username != null) {
//                cq = cq.where(cb.equal(m.get("username"), "kim"));
//            }
//            List<Member> resultList = em.createQuery(cq).getResultList();
//
//            System.out.println("resultList : " + resultList);
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            // flush = commit, query
            em.flush();

            // 결과 0
            // dbconn.executeQuery("select * from member");

            List<Member> members =
                    em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER",Member.class).getResultList();
            System.out.println("members : " + members);

            for(Member member1 : members) {
                System.out.println("member1 = " + member1);
            }

            tx.commit();
        } catch (Exception e) {
            System.err.println("버그 발견!!!" + e.getMessage());
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}