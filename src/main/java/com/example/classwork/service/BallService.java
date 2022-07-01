package com.example.classwork.service;

import com.example.classwork.model.Ball;
import com.example.classwork.repository.BallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BallService {

    @Autowired
    BallRepository repository;
    public List<Ball> getAllBall() { return repository.findAll();
    }

    public Ball getBallById(Long id) {
        Optional<Ball> ballOptional = repository.findById(id);
        if (ballOptional.isPresent()) {
            return ballOptional.get();
        } else {
            throw new RuntimeException();
        }
    }
    public void deleteBallById(Long id) {repository.deleteById(id);}

    public void createAndSaveBall(Ball ball) {
        if (ball.getBallID() == null
                || !repository.existsById(ball.getBallID()))
            repository.save(ball);
    }

    public void updateBallById(Long id, Ball ball) {
        Ball ballExisting = getBallById(id);
        ballExisting.setSize(ball.getSize());
        ballExisting.setWeight(ball.getWeight());
        ballExisting.setColor(ball.getColor());
        repository.save(ballExisting);
    }

    public List<Ball> getBallWithSize(Integer size) {
        return repository.findBallBySize(size);
    }

    public List<Ball> getBallWithWeight(Float weight) {
        return repository.findBallByWeight(weight);
    }

    public List<Ball> getBallWithColor(String color) {
        return  repository.findBallByColor(color);
    }

    public List<Ball> getAllBallsBySizeAndWeight(Integer size, Float weight) {
        List <Ball> ball = getAllBall();
        ball = ball.stream()
                .filter(balls -> balls.getSize() >=size)
                .filter(balls ->balls.getWeight() >=weight)
                .toList();
        return  ball;
    }


//    public Collection<Ball> getBallWithSizeLike(Integer size) {
//        return repository.findAllBallbySize(size);
//    }
}
