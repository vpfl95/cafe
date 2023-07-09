package com.example.cafe.service;

import com.example.cafe.domain.Cafe;
import com.example.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {
    public final CafeRepository cafeRepository;

    public Cafe save(Cafe cafe){
        Cafe save = cafeRepository.save(cafe);
        return save;
    }

}
