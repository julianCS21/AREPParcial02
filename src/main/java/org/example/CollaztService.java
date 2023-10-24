package org.example;


import java.util.ArrayList;

import static spark.Spark.*;
public class CollaztService {


    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("collazt", (req,res) -> {

            res.type("text/json");

            int number = Integer.parseInt(req.queryParams("number"));

            return CollaztSecuence(number);
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }


    public static String CollaztSecuence(int number){
        ArrayList<String> secuence = new ArrayList<>();
        secuence.add(String.valueOf(number));

        while(number != 1 &&  number > 0){
            if(number % 2 == 0){
                number = number / 2;
            }
            else {
                number = 3 * number + 1;
            }
            secuence.add(String.valueOf(number));
        }
        String result = secuence.get(0) + " ";
        for(int i = 1; i < secuence.size(); i++){
            result +=  "-> " + secuence.get(i);
        }
        return result;
    }







}
