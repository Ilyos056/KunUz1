package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.CommentLikeDto;
import tadjik.ilyosjon.kunuz1.model.CommentLike;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.CommentLikeService;

import java.util.List;

@RestController
@RequestMapping("/commentlike")
public class CommentLikeController {
    @Autowired
    CommentLikeService commentLikeService;

    @GetMapping
    public List<CommentLike> getCommentLikes(){
        return commentLikeService.findallcommenlike();
    }

    @GetMapping("/{id}")
    public CommentLike getCommentLike(@PathVariable Integer id){
        return commentLikeService.findbyid(id);
    }

    @PostMapping
    public Result addCommentLike(@RequestBody CommentLikeDto commentLikedto){
        Result result = commentLikeService.createcommentlike(commentLikedto);
        return result;
    }

    @PutMapping("/{id}")
    public Result removeCommentLike(@PathVariable Integer id,  @RequestBody CommentLikeDto commentLikedto){
        Result result = commentLikeService.updatecommentlike(id, commentLikedto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result removeCommentLike(@PathVariable Integer id){
        Result result = commentLikeService.deletecommentlike(id);
        return result;
    }
}
