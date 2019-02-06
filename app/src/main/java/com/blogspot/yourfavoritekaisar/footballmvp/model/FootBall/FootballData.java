package com.blogspot.yourfavoritekaisar.footballmvp.model.FootBall;

import com.google.gson.annotations.SerializedName;

public class FootballData {

    @SerializedName("idTeam")
    private int idTeam;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }
}
