package com.example.webapp.club;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import com.example.webapp.club.Club;

@Repository
public interface ClubCommentRepository extends JpaRepository<ClubComment,Integer> {



}
