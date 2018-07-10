package com.nokia.traning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FairPlayPointsCalculatr {


    public static final String RED = "red";

    public static int calculatePoints(String s) {
        int teamPoints = 0;
        String[] data= s.split(",");
        Map<String, List<String>> foulsByPlayer = getOffenses(data);
        for(String name: foulsByPlayer.keySet()){
            List<String> foulsByCurrentPlayer = foulsByPlayer.get(name);
            teamPoints += calculatePointsForPlayer(foulsByCurrentPlayer);
        }
        return teamPoints;
    }

    private static int calculatePointsForPlayer(List<String> fouls) {
        if(fouls.contains(RED)){

            return fouls.size() == 2 ? 5 : 4;
        }
        if(fouls.size() == 1){
            return 1;
        }
        else{
            return 3;
        }
    }

    private static List<String> getFouls(String[] data){
        List<String> fouls = new ArrayList<>();
        for(int i = 1; i < data.length; i+=2){
            fouls.add(data[i]);
        }
        return fouls;
    }

    private static Map<String, List<String>> getOffenses(String[] data){
        Map<String, List<String>>  foulsByPlayer = new HashMap<>();
        List<String> names = getNames(data);
        List<String> fouls = getFouls(data);
        for(int i=0; i<names.size(); i++){
            if(foulsByPlayer.containsKey(names.get(i))){
                foulsByPlayer.get(names.get(i)).add(fouls.get(i));
            }
            else{
                List<String> tempFouls = new ArrayList<>();
                tempFouls.add(fouls.get(i));
                foulsByPlayer.put(names.get(i), tempFouls);
            }
        }
        return foulsByPlayer;
    }

    private static List<String> getNames(String[] data){
        List<String> names = new ArrayList<>();
        for(int i = 0; i < data.length; i+=2){
            names.add(data[i]);
        }
        return names;
    }
}
