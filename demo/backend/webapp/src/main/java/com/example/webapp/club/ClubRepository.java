package com.example.webapp.club;

import com.example.webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import com.example.webapp.club.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club,Integer> {

    ArrayList<Club> findAllBy();
    Club save(Club club);
    void deleteById(long postID);
    Optional<Club> findById(long clubId);
    Optional<Club> findByClubname(String clubname);

}
