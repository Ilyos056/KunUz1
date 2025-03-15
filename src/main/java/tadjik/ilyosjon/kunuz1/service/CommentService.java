package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.CommentDto;
import tadjik.ilyosjon.kunuz1.model.Article;
import tadjik.ilyosjon.kunuz1.model.Comment;
import tadjik.ilyosjon.kunuz1.model.Profile;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.ArticleRepo;
import tadjik.ilyosjon.kunuz1.repository.CommentRepo;
import tadjik.ilyosjon.kunuz1.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ArticleRepo articleRepo;

    // get by all
    public List<Comment> findAllComments() {
        return (List<Comment>) commentRepo.findAll();
    }

    // get by id
    public Comment findById(Integer id) {
        return commentRepo.findById(id).get();
    }

    // create
    public Result createcomment(CommentDto commentdto){
        Comment comment = new Comment();
        comment.setContent(commentdto.getContent());
        comment.setReply_id(commentdto.getReply_id());

        Optional<Profile> profileOptional = profileRepo.findById(commentdto.getProfiles());
        Profile profile = profileOptional.get();
        comment.setProfiles((List<Profile>)profile);

        Optional<Article> articleOptional = articleRepo.findById(commentdto.getArticlesid());
        Article article = articleOptional.get();
        comment.setArticlesid((List<Article>)article);

        commentRepo.save(comment);
        return new Result(true,"success");
    }


    // update
    public Result updatecomment(Integer id, CommentDto commentdto){
        Optional<Comment> byId = commentRepo.findById(id);
        if(byId.isPresent()){
            Comment comment = byId.get();
            comment.setContent(commentdto.getContent());
            comment.setReply_id(commentdto.getReply_id());

            Optional<Profile> profileOptional = profileRepo.findById(commentdto.getProfiles());
            Profile profile = profileOptional.get();
            comment.setProfiles((List<Profile>)profile);

            Optional<Article> articleOptional = articleRepo.findById(commentdto.getArticlesid());
            Article article = articleOptional.get();
            comment.setArticlesid((List<Article>)article);

            commentRepo.save(comment);
            return new Result(true,"success");
        }
        return new Result(false,"not found");
    }

    // delete
    public Result deletecomment(Integer id){
        commentRepo.deleteById(id);
        return new Result(true,"success");
    }
}
