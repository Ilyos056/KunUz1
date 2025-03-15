package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.CommentLikeDto;
import tadjik.ilyosjon.kunuz1.model.Comment;
import tadjik.ilyosjon.kunuz1.model.CommentLike;
import tadjik.ilyosjon.kunuz1.model.Profile;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.CommentLikeRepo;
import tadjik.ilyosjon.kunuz1.repository.CommentRepo;
import tadjik.ilyosjon.kunuz1.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CommentLikeService {

    @Autowired
    CommentLikeRepo commentLikeRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    CommentRepo commentRepo;


    // get all
    public List<CommentLike> findallcommenlike(){
        return commentLikeRepo.findAll();
    }

    // get by id
    public CommentLike findbyid(Integer id){
        return commentLikeRepo.findById(id).get();
    }

    // create
    public Result createcommentlike(CommentLikeDto commentLikedto){
        CommentLike commentLike = new CommentLike();


        Optional<Profile> profileOptional = profileRepo.findById(commentLikedto.getProfiles());
        Profile profile = profileOptional.get();
        commentLike.setProfiles((List<Profile>)profile);

        Optional<Comment> articleOptional = commentRepo.findById(commentLikedto.getComments());
        Comment comment = articleOptional.get();
        commentLike.setComments((List<Comment>)comment);

        commentLikeRepo.save(commentLike);
        return new Result(true,"success");
    }


    // update
    public Result updatecommentlike(Integer id, CommentLikeDto commentLikedto){
        Optional<CommentLike> commentLikeOptional = commentLikeRepo.findById(id);
        if(commentLikeOptional.isPresent()){
            CommentLike commentLike = commentLikeOptional.get();

            Optional<Profile> profileOptional = profileRepo.findById(commentLikedto.getProfiles());
            Profile profile = profileOptional.get();
            commentLike.setProfiles((List<Profile>)profile);

            Optional<Comment> commentOptional = commentRepo.findById(commentLikedto.getComments());
            Comment comment = commentOptional.get();
            commentLike.setComments((List<Comment>)comment);
            commentLikeRepo.save(commentLike);
            return new Result(true,"success");
        }
        return new Result(false,"error");
    }

    // delete
    public Result deletecommentlike(Integer id){
        commentLikeRepo.deleteById(id);
        return new Result(true,"success");
    }
}
