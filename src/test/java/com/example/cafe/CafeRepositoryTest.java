package com.example.cafe;

import com.example.cafe.domain.Cafe;
import com.example.cafe.repository.CafeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CafeRepositoryTest {

    @Autowired
    CafeRepository cafeRepository;

    @Test
    void findCafe(){
        Cafe findCafe = cafeRepository.findById("카페홈즈").get();

        Assertions.assertThat("카페홈즈").isEqualTo(findCafe.getCafeName());
    }
}
