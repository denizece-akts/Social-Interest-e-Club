package com.example.webapp.club;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@AllArgsConstructor
public class ClubService {

    @Autowired
    ClubRepository clubRepository;
    ClubCommentRepository clubCommentRepository;

    public String clubadd(CreateClubRequest request){

        if(clubRepository.findByClubname(request.getClubname()).isPresent()){
            throw new IllegalStateException("Clubname is taken");
        }

        Club clubData = new Club(request.getClub_admin(), request.getClubname(), request.getPermissions());

        clubRepository.save(clubData);
        return "Club" + clubData.getClubname() + " created";

    }

    public ArrayList<Club> clubsearch(){
        ArrayList<Club> result=clubRepository.findAllBy();
        return result;
    }

    public ArrayList<Club> clubdelete(long postID){
        clubRepository.deleteById(postID);

        ArrayList<Club> result=clubsearch();
        return result;
    }

    public String clubrate(long clubID, Integer rate) {

        if (rate > 10) {
            throw new IllegalStateException("rate can't be higher than 10");
        } else if (rate < 0){
            throw new IllegalStateException("rate cannot be less than 0");
        } else{
            Optional<Club> result=clubRepository.findById(clubID);
            result.get().addRate(rate);
            return "new rate is:" + result.get().getRate();
        }
    }

    public List<ClubComment> clubcomment(long clubID, String username, String newComment){

        Optional<Club> result=clubRepository.findById(clubID);
        ClubComment comment = new ClubComment();
        comment.setComment(newComment);
        comment.setUsername(username);
        comment.setClub(result.get());

        clubCommentRepository.save(comment);
        return clubCommentRepository.findAll();

    }

}
