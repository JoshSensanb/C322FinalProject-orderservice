package edu.iu.c322.group10.orderservice.controller;

import edu.iu.c322.group10.orderservice.model.Comment;
import edu.iu.c322.group10.orderservice.repository.CommentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @GetMapping("/getall")
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public List<Comment> findbyItemId(@PathVariable int id){



        List<Comment> tempList =commentRepository.findAll();
        for(int i = 0;i<tempList.size();i++){
            Comment tempComment = tempList.get(i);
            if(tempComment.getItemId()!=id){
                tempList.remove(tempComment);
            }
        }
        return tempList;

    }

    //will likely need a find by itemId

}
