package Project;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Day {
    int currentDay;
    int startingDay = 1;
    int currentStorageIndex = 0;
    List<List<String>> dayStorage;
    
    public Day() {
        dayStorage = new ArrayList<>();
    }

    public void isComplete() {
        
    }

    public int randomInt() {
        Random random = new Random();
        return random.nextInt(60) + 1;
    }

    public dayTypes determineEvent() {
        int eventSeed = randomInt();

        System.out.println("Generated event seed: " + eventSeed);

        for(dayTypes type : dayTypes.values()) {
            if(eventSeed >= type.getOdds()[0] && eventSeed <= type.getOdds()[1]) {
                return type;
            } 
        }

        return dayTypes.NO_EVENT;
    }

    public void fillDayStorage(int day, dayTypes event) {
        while(dayStorage.size() <= day) {
            dayStorage.add(new ArrayList<>());
        }
        
        dayStorage.get(day).add(day + 1 + " " + event);
    }

    public void nextDay() {
        dayTypes event = determineEvent();
        int day = currentDay;

        fillDayStorage(day, event);
        System.out.println(dayStorage);

        currentDay++;
    }
}
