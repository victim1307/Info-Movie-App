package com.example.myapplication;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.List;

public class MovieParsing implements Serializable {
    public Integer id;
    private String original_language;

    private String imdb_id;

    private Boolean video;

    private String title;

    private String backdrop_path;

    private Integer revenue;

    private List < ? extends Genres > genres;

    private Double popularity;

    private List < ? extends Production_countries > production_countries;

    private Integer vote_count;

    private Integer budget;

    private String overview;

    private String original_title;

    private Integer runtime;

    private String poster_path;

    private List < ? extends Spoken_languages > spoken_languages;

    private List < ? extends Production_companies > production_companies;

    private String release_date;

    private Double vote_average;

    private Belongs_to_collection belongs_to_collection;

    private String tagline;

    private Boolean adult;

    private String homepage;

    private String status;

    public String getOriginal_language() {
        return this.original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public Boolean getVideo() {
        return this.video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return this.backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Integer getRevenue() {
        return this.revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public List < ? extends Genres > getGenres() {
        return this.genres;
    }

    public void setGenres(List < ? extends Genres > genres) {
        this.genres = genres;
    }

    public Double getPopularity() {
        return this.popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public List < ? extends Production_countries > getProduction_countries() {
        return this.production_countries;
    }

    public void setProduction_countries(List < ? extends Production_countries > production_countries) {
        this.production_countries = production_countries;
    }

    public Integer getVote_count() {
        return this.vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public Integer getBudget() {
        return this.budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_title() {
        return this.original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Integer getRuntime() {
        return this.runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getPoster_path() {
        return this.poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List < ? extends Spoken_languages > getSpoken_languages() {
        return this.spoken_languages;
    }

    public void setSpoken_languages(List < ? extends Spoken_languages > spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public List < ? extends Production_companies > getProduction_companies() {
        return this.production_companies;
    }

    public void setProduction_companies(List < ? extends Production_companies > production_companies) {
        this.production_companies = production_companies;
    }

    public String getRelease_date() {
        return this.release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Double getVote_average() {
        return this.vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Belongs_to_collection getBelongs_to_collection() {
        return this.belongs_to_collection;
    }

    public void setBelongs_to_collection(Belongs_to_collection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public String getTagline() {
        return this.tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Boolean getAdult() {
        return this.adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getHomepage() {
        return this.homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Genres implements Serializable {
        private String name;

        private Integer id;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    public static class Production_countries implements Serializable {
        private String iso_3166_1;

        private String name;

        public String getIso_3166_1() {
            return this.iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Spoken_languages implements Serializable {
        private String name;

        private String iso_639_1;

        private String english_name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso_639_1() {
            return this.iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getEnglish_name() {
            return this.english_name;
        }

        public void setEnglish_name(String english_name) {
            this.english_name = english_name;
        }
    }

    public static class Production_companies implements Serializable {
        private Object logo_path;

        private String name;

        private Integer id;

        private String origin_country;

        public Object getLogo_path() {
            return this.logo_path;
        }

        public void setLogo_path(Object logo_path) {
            this.logo_path = logo_path;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getOrigin_country() {
            return this.origin_country;
        }

        public void setOrigin_country(String origin_country) {
            this.origin_country = origin_country;
        }
    }

    public static class Belongs_to_collection implements Serializable {
        private String backdrop_path;

        private String name;

        private Integer id;

        private String poster_path;

        public String getBackdrop_path() {
            return this.backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPoster_path() {
            return this.poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }
    }

    @Override
    public String toString() {
        return "\nClassName1{" +
                "\noriginal_language='" + original_language + '\'' +
                ", \nimdb_id='" + imdb_id + '\'' +
                ", \nvideo=" + video +
                ", \ntitle='" + title + '\'' +
                ", \nbackdrop_path='" + backdrop_path + '\'' +
                ", \nrevenue=" + revenue +
                ", \ngenres=" + genres +
                ", \npopularity=" + popularity +
                ", \nproduction_countries=" + production_countries +
                ", \nid=" + id +
                ", \nvote_count=" + vote_count +
                ", \nbudget=" + budget +
                ", \noverview='" + overview + '\'' +
                ", \noriginal_title='" + original_title + '\'' +
                ", \nruntime=" + runtime +
                ", \nposter_path='" + poster_path + '\'' +
                ",\n spoken_languages=" + spoken_languages +
                ", \nproduction_companies=" + production_companies +
                ", \nrelease_date='" + release_date + '\'' +
                ", \nvote_average=" + vote_average +
                ", \nbelongs_to_collection=" + belongs_to_collection +
                ", \ntagline='" + tagline + '\'' +
                ", \nadult=" + adult +
                ", \nhomepage='" + homepage + '\'' +
                ", \nstatus='" + status + '\'' +
                '}';
    }
}
