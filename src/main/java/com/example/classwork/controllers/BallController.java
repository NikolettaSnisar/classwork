package com.example.classwork.controllers;


import com.example.classwork.model.Ball;
import com.example.classwork.service.BallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class BallController {

    @Autowired
    BallService ballService;

    @GetMapping(path = "/ball")
    public List<Ball> getAllBall() {
        return ballService.getAllBall();
    }

    @GetMapping(path = "/ball/{id}")
    public Ball getBallById(@PathVariable Long id) {
        return ballService.getBallById(id);
    }

    @DeleteMapping(path = "/ball/{id}")
    public void deleteBallById(@PathVariable Long id) {
        ballService.deleteBallById(id);
    }

    @PostMapping(path = "/ball/new")
    public void createAndSaveBall(@RequestBody Ball ball) {
        ballService.createAndSaveBall(ball);
    }

    @PutMapping(path = "/ball/{id}")
    public void updateBall (@PathVariable Long id, @RequestBody Ball ball) {
        ballService.updateBallById(id, ball);
    }

    @GetMapping(path = "/ball/listS")
    public List<Ball> getBallBySize (@RequestParam Integer size) {
        return ballService.getBallWithSize(size);
    }
    @GetMapping(path = "/ball/listW")
    public List<Ball> getBallByWeight (@RequestParam Float weight) {
        return ballService.getBallWithWeight(weight);
    }

    @GetMapping(path = "/ball/listC")
    public List<Ball> getBallByWColor(@RequestParam String color) {
        return ballService.getBallWithColor(color);
    }
    @GetMapping (path = "/ballsbiger")
    public List <Ball> getBallBySizeAndWeight (@RequestParam (required = false) Integer size,
                                               @RequestParam (required = false) Float weight){
        return ballService.getAllBallsBySizeAndWeight(size, weight);
    }







//    @GetMapping(path = "/ball/find")
//    public Collection<Ball> getBallWithSizeLike (@RequestParam Integer size) {
//        return ballService.getBallWithSizeLike(size);
//    }
}
