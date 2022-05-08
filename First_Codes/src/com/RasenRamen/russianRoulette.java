package com.RasenRamen;

import com.RasenRamen.ANSI;

import java.util.Random;
import java.util.Scanner;

public class russianRoulette {
    public static void play(){
        boolean isStop = false;

        while (true){

            String chosen;
            int chosenTurn = 1;

            int[] turn = {0, 0, 0, 0, 0, 0};
            Random rng = new Random();
            turn[rng.nextInt(5)] = 1;



            while (true) {
                Scanner chooseTurn = new Scanner(System.in);
                System.out.println("Choose Turn (1-6):");
                chosen = chooseTurn.nextLine().trim().toLowerCase();
                if (chosen.equals("stop")) {
                    isStop = true;
                    break;
                }
                else if (((chosen.contains("1") || chosen.contains("2")) || chosen.contains("3") || chosen.contains("4") || chosen.contains("5") || chosen.contains("6")) && !(chosen.contains("-"))
                ) {
                    try {
                        chosenTurn = Integer.parseInt(chosen);
                        if(chosenTurn > 0 && chosenTurn < 7)
                            break;
                    } catch (Exception e){
                        continue;
                    }

                }
            }

            if(isStop)
                break;

            for (int i = 0; i < 6; i++) {
                if (turn[i] == 0)
                    System.out.println("click");
                else {
                    System.out.println(ANSI.ANSI_YELLOW + "BANG" + ANSI.ANSI_RESET);
                    break;
                }
            }

            if (turn[chosenTurn - 1] == 1)
                System.out.println(ANSI.ANSI_RED + "you loose" + ANSI.ANSI_RESET);
            else
                System.out.println(ANSI.ANSI_GREEN + "you win" + ANSI.ANSI_RESET);

        }
    }
}
// ((chosen.contains("1") || chosen.contains("2")) || chosen.contains("3") || chosen.contains("4") || chosen.contains("5") || chosen.contains("6")) && !(chosen.contains("-"))

//(((((chosen.contains("1") ^ chosen.contains("2")) ^ (chosen.contains("3") ^ chosen.contains("4"))) ^ (chosen.contains("5") ^ chosen.contains("6")))) && !(chosen.contains("-")))