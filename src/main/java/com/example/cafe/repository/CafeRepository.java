package com.example.cafe.repository;

import com.example.cafe.domain.Cafe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class CafeRepository {

    private final EntityManager em;
    public CafeRepository(EntityManager em) {
        this.em = em;
    }

    public Cafe save(Cafe cafe){
        em.persist(cafe);
        return cafe;
    }

    public void update(Long cafeId, CafeUpdateDTO updateParam){
        Cafe findCafe = em.find(Cafe.class, cafeId);
        findCafe.setCustomer(updateParam.getCustomer());
        findCafe.setMaxSales(updateParam.getMinSales());
        findCafe.setMinSales(updateParam.getMinSales());
    }

    public Optional<Cafe> findById(Long id){
        Cafe cafe = em.find(Cafe.class, id);
        return Optional.ofNullable(cafe);
    }

    public List<Cafe> findAll(CafeSearchCond cond){
        String jpql = "select c from Cafe c";

        String cafeName = cond.getCafeName();
        Long maxSales = cond.getMaxSales();
        Long minSales = cond.getMinSales();
        String address = cond.getAddress();
        String customer = cond.getCustomer();

        if (StringUtils.hasText(cafeName) || maxSales != null) {
            jpql += " where";
        }
        boolean andFlag = false;
        if (StringUtils.hasText(cafeName)) {
            jpql += " i.itemName like concat('%',:cafeName,'%')";
            andFlag = true;
        }
        if (maxSales != null) {
            if (andFlag) {
                jpql += " and";
            }
            jpql += " i.maxSales <= :maxSales";
        }
        log.info("jpql={}", jpql);
        TypedQuery<Cafe> query = em.createQuery(jpql, Cafe.class);
        if (StringUtils.hasText(cafeName)) {
            query.setParameter("cafeName", cafeName);
        }
        if (maxSales != null) {
            query.setParameter("maxSales", maxSales);
        }
        return query.getResultList();
    }

}
