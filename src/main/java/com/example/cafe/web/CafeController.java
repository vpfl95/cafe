package com.example.cafe.web;

import com.example.cafe.domain.Cafe;
import com.example.cafe.repository.CafeUpdateDTO;
import com.example.cafe.service.CafeService;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    @ResponseBody
    @PostMapping("/add")
    public String addCafe(@ModelAttribute Cafe cafe){
        cafeService.save(cafe);

        return "OK";
    }

    @ResponseBody
    @PostMapping("/update")
    public String updateCafe(String cafeName,@ModelAttribute CafeUpdateDTO updateParam){
        cafeService.update(cafeName, updateParam);

        return "OK";
    }

    @ResponseBody   
    @GetMapping("/cafe")
    public Optional<Cafe> getCafe(String cafeName){
        Optional<Cafe> findCafe = cafeService.findByName(cafeName);
        log.info(cafeName);
        return findCafe;
    }

}
