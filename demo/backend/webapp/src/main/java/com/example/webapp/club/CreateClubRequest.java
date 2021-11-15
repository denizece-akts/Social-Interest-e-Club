package com.example.webapp.club;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateClubRequest {

    private final String club_admin;
    private final String clubname;
    private final String permissions;

}
