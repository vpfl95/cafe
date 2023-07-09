package com.example.cafe.web;

import com.example.cafe.domain.Cafe;
import com.example.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CafeController {

    public final CafeService cafeService;

    @ResponseBody
    @PostMapping("/add")
    public String addCafe(@ModelAttribute Cafe cafe){
        System.out.println(cafe.getCafeName());

        cafeService.save(cafe);

        log.info("asdfasdf");
        return "OK";
    }

}
