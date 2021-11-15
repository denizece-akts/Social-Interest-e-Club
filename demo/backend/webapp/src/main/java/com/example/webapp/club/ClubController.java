package com.example.webapp.club;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/clubService")
public class ClubController {
    @Autowired
    ClubService clubService;
    ClubRepository clubRepository;


    @PostMapping("/add")
    @ResponseBody
    public String addClub(@RequestBody CreateClubRequest request){

        return clubService.clubadd(request);
    }

    @GetMapping("/search")
    @ResponseBody
    public ArrayList<Club> retrieveAllPost(){
        ArrayList<Club> result=clubService.clubsearch();
        return result;
    }

    @DeleteMapping("/delete/{clubId}")
    @ResponseBody
    public ArrayList<Club> deleteParticularPost(@PathVariable("clubId") long clubId){
        ArrayList<Club> result=clubService.clubdelete(clubId);
        return result;
    }

    @PostMapping("/rate/{clubID}")
    @ResponseBody
    public String rateClub(@PathVariable("clubId") long clubId, @RequestBody Integer body ){
        String result=clubService.clubrate(clubId,body);
        return result;
    }

    @PostMapping("/comment/{clubId}")
    @ResponseBody
    public List<ClubComment> commentOnClub(@PathVariable("clubId") long clubId, CommentRequest commentRequest){
        List<ClubComment> result=clubService.clubcomment(clubId, commentRequest.getUsername(), commentRequest.getComment());
        return result;
    }

}
