package edu.iu.c322.group10.orderservice.controller;

import edu.iu.c322.group10.orderservice.model.Comment;
import edu.iu.c322.group10.orderservice.repository.CommentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    //will likely need a find by itemId

}
