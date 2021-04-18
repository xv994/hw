package course.Race;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Contestants {

    Map<String, ContestantItem> contestants = new HashMap<>();
    private static int numberOfJudges = 3;
    private int numberOfContestant;

    public static int getNumberOfJudges() {
        return numberOfJudges;
    }

    public static void setNumberOfJudges(int numberOfJudges) {
        Contestants.numberOfJudges = numberOfJudges;
    }

    public boolean addOneItem() {
        ContestantItem item = new ContestantItem();
        item.setItem();
        if (!"#".equals(item.getNumber()) && !"".equals(item.getNumber())) {
            contestants.put(item.getNumber(), item);
            this.numberOfContestant++;

            return true;
        }
        return false;
    }

    public void addSomeItems() {
        boolean tmp = true;
        while (tmp)
            tmp = addOneItem();
    }

    public int getNumberOfContestant() {
        return numberOfContestant;
    }

    public boolean deleteOneItem() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the number of contestant you will delete:");
        String key = input.nextLine();

        if (contestants.containsKey(key)) {
            contestants.remove(key);
            return true;
        } else {
            System.out.println("No such number like this!");
            return false;
        }

    }

    public void deleteAllItems() {
        contestants.clear();
    }

    public boolean getOneScore() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the number of contestant you want:");
        String key = input.nextLine();

        if (contestants.containsKey(key)) {
            System.out.println(contestants.get(key).toString());
            return true;
        } else {
            System.out.println("No such number like this!");
            return false;
        }
    }

    public void getAllScore() {
        if (!contestants.isEmpty()) {

            List<Map.Entry<String, ContestantItem>> list = new ArrayList<>(contestants.entrySet());

            list.sort(new Comparator<Map.Entry<String, ContestantItem>>(){
    
                @Override
                public int compare(Entry<String, ContestantItem> o1, Entry<String, ContestantItem> o2) {
                    // TODO Auto-generated method stub
                    return o1.getValue().compareTo(o2.getValue());
                };
            });

            String str = "";
        for (Entry<String,ContestantItem> map : list) {
            str += map.getKey().toString() + ": " + map.getValue().toString() + "\n";
        }

            System.out.println(str); 
            
        } else {
            System.out.println("This is a empty bool.");
        }
    }

}
