package edu.iu.c322.group10.orderservice.repository;

import edu.iu.c322.group10.orderservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
