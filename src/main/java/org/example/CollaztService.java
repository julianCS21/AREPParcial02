package org.example;

import static spark.Spark.*;
public class CollaztService {


    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("hello", (req,res) -> "Hello Docker!");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }







}
