package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.CommentDto;
import tadjik.ilyosjon.kunuz1.model.Comment;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getComments(){
        return commentService.findAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Integer id){
        return commentService.findById(id);
    }


    @PostMapping
    public Result addComment(@RequestBody CommentDto commentdto){
        Result result = commentService.createcomment(commentdto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateComment(@PathVariable Integer id, @RequestBody CommentDto commentdto){
        Result result = commentService.updatecomment(id, commentdto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteComment(@PathVariable Integer id){
        Result result = commentService.deletecomment(id);
        return result;
    }

}
