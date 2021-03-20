package course.Race;

import java.util.Scanner;

public class ContestantItem implements Comparable<ContestantItem>{
    
    private String number;
    private String name;
    private float score;

    ContestantItem(){}
    ContestantItem(int score){
        this.score = score;
    }

    public String getNumber() {
        return number;
    }

    public float getScore() {
        return score;
    }

    public void setItem(){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the number of the constestant:");
        this.number = input.nextLine();
        if (!"#".equals(number) && !"".equals(number)){

            System.out.println("Please enter the name of contestant");
            this.name = input.nextLine();

            System.out.println("Please enter the score of this one");

            int max = 0;
            int min = 11;
            for (int i = 0; i < Contestants.getNumberOfJudges(); i++) {
                int tmp = input.nextInt();
                if (tmp > max) max = tmp;
                if (tmp < min) min = tmp;
                this.score += tmp;
            }

            this.score = (this.score - max - min) / (Contestants.getNumberOfJudges() - 2);
        }
        
    }

    public void setScore(float score){
        this.score = score;
    }

    @Override
    public int compareTo(ContestantItem tep) {
        // TODO Auto-generated method stub
        return tep.getScore() < this.getScore() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "name=" + name + ", score=" + score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
