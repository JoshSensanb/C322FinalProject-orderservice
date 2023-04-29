package edu.iu.c322.group10.orderservice.controller;

import edu.iu.c322.group10.orderservice.model.Comment;
import edu.iu.c322.group10.orderservice.repository.CommentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Comment comment){
        Comment newComment = commentRepository.save(comment);
        return newComment.getCommentId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Comment comment, @PathVariable int id){
        comment.setCommentId(id);
        commentRepository.save(comment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Comment comment = new Comment();
        comment.setCommentId(id);
        commentRepository.delete(comment);
    }

    @GetMapping("/getall")
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public List<Comment> findbyItemId(@PathVariable int id){
        List<Comment> tempList = commentRepository.findAll();
        for(int i = 0;i<tempList.size();i++){
            Comment tempComment = tempList.get(i);
            if(tempComment.getItemId()!=id){
                tempList.remove(tempComment);
            }
        }
        return tempList;

    }
}
