package com.example.mprasher.foodbuddy.webservices.endpoints;

/**
 * Created by mprasher on 2016-10-01.
 */

public class EndPoints {

    public static final String BASE_URL = "http://192.168.54.61:8000/api/";
    public static final String POST_ELASTIC_BASE_URL = "http://ec2-54-89-137-160.compute-1.amazonaws.com:9200/";
    public static class Registeration{
        public static final String REGISTERATION_URL="registration";
        public static final String LOGIN_URL="signin";

    }
    public static class PostCreate{
        public static final String POST_CREATE_URL="foodpost";
        public static final String GET_POST_URL="foodbuddy/foodpost/_search";

    }
}
