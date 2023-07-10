package com.example.cafe.service;

import com.example.cafe.domain.Cafe;
import com.example.cafe.repository.CafeRepository;
import com.example.cafe.repository.CafeUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;

    public Cafe save(Cafe cafe){
        Cafe save = cafeRepository.save(cafe);
        return save;
    }

    public Optional<Cafe> findByName(String cafeName){
        Optional<Cafe> findCafe = cafeRepository.findById(cafeName);

        return findCafe;
    }

    public void update(String cafeName, CafeUpdateDTO updateParam){
        cafeRepository.update(cafeName, updateParam);
    }

}
