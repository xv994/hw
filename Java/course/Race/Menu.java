package course.Race;

import java.util.Scanner;

public class Menu{

    private Contestants contestants = new Contestants();

    public Menu(){}
    public Menu(Contestants contestants){
        this.contestants = contestants;
    }

    public void getMenu(){
        System.out.println(
            "       Menu\n" + 
            "1. about judges\n" +
            "2. about contestant\n" +
            "3. exit"
        );
        makeChoice();
    }
    void makeChoice(){
        Scanner input = new Scanner(System.in);
        
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                menuJudges();
                break;
            case 2:
                menuContestant();
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Please make a correct choice.");
                getMenu();
                break;
        }
    }

    void menuJudges(){

        System.out.println(
            "       Judge Menu\n" +
            "1. set the number of judges\n" +
            "2. show the number of judges\n" +
            "3. exit"
        );

        makeChoiceJudges();

    }

    void makeChoiceJudges(){
        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Please enter the number of judges:");
                int tmp = input.nextInt();
                Contestants.setNumberOfJudges(tmp);
                back(1);
                break;
            case 2:
                System.out.printf("There are %d judges now.\n", Contestants.getNumberOfJudges());
                back(1);
                break;
            case 3:
                getMenu();
                break;
            default:
                System.out.println("Please enter a correct number.");
                menuJudges();
                break;
        }
    }

    void menuContestant(){

        System.out.println(
            "   Contestant Menu\n" +
            "1. add one contestant\n" +
            "2. add some contestants\n" +
            "3. delete one contestant\n" +
            "4. delete all contestants\n" +
            "5. show someone's score\n" +
            "6. show all score\n" +
            "7. exit" 
        );

        makeChoiceContestant();

    }

    void makeChoiceContestant(){
        Scanner input = new Scanner(System.in);

        int tmp = input.nextInt();
        switch (tmp) {
            case 1:
                contestants.addOneItem();
                back(2);
                break;
            case 2:
                contestants.addSomeItems();
                back(2);
                break;
            case 3:
                if (!contestants.deleteOneItem())
                    makeChoiceContestant();
                else
                    back(2);
                break;
            case 4:
                contestants.deleteAllItems();
                back(2);
                break;
            case 5:
                contestants.getOneScore();
                back(2);
                break;
            case 6:
                contestants.getAllScore();
                back(2);
                break;
            case 7:
                getMenu();
                break;
            default:
                System.out.println("Please enter a correct number.");
                menuContestant();
                break;
        }
    }

    void exit(){
        System.out.println("Thank you for your using");
        System.exit(0);
    }

    void back(int tmp){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter anything to continue");
        input.nextLine();
        if (tmp == 1)
            menuJudges();
        else if (tmp == 2)
            menuContestant();
    }

}