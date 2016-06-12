/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Random;

/**
 *
 * @author Warco
 */
public class dataGen {

    private static String[] fname = {"bo", "ip", "Marco", "david", "alex"};
    private static String[] lname = {"hansen", "larsen", "marcsen", "alexsen", "dansen"};
    private static String[] street = {"main street 13", "2nd street 27", "roskildevej 17", "lyngbyvej 23", "street 7"};
    private static String[] city = {"lyngby", "roskilde", "aarhus", "odense", "washington"};

    public static JsonArray getData(int number, String prop) {
        String[] props;
        Random nr = new Random();
        boolean[] props2 = new boolean[4];
        if (prop.contains(",")) {
            props = prop.split(",");
        } else {
            props = new String[1];
            props[0] = prop;
        }
        for (String p : props) {
            if (p.equals("fname")) {
                props2[0] = true;
            }
            if (p.equals("lname")) {
                props2[1] = true;
            }
            if (p.equals("street")) {
                props2[2] = true;
            }
            if (p.equals("city")) {
                props2[3] = true;
            }
        }
        JsonArray ja = new JsonArray();
        for (int i = 0; i < number; i++) {
            JsonObject jo = new JsonObject();
            if (props2[0]) {
                jo.addProperty("fname", fname[nr.nextInt(5)]);
            }
            if (props2[1]) {
                jo.addProperty("lname", lname[nr.nextInt(5)]);
            }
            if (props2[2]) {
                jo.addProperty("street", street[nr.nextInt(5)]);
            }
            if (props2[3]) {
                jo.addProperty("city", city[nr.nextInt(5)]);
            }
            ja.add(jo);
        }
        return ja;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(getData(10, "fname,street,city,lname").toString());
    }

}
