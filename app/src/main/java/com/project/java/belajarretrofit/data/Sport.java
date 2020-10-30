package com.project.java.belajarretrofit.data;

import com.google.gson.annotations.SerializedName;

public class Sport {
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("strFormat")
    private String  strFormat;
    @SerializedName("strSportThumb")
    private String strSportThumb;

    public Sport() {
    }

    public Sport(String strSport, String strFormat, String strSportThumb) {
        this.strSport = strSport;
        this.strFormat = strFormat;
        this.strSportThumb = strSportThumb;
    }

    public String getStrSport() {
        return strSport;
    }

    public String getStrFormat() {
        return strFormat;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }
}
