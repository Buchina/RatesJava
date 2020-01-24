package MyClass;

import java.util.Random;

public class PlayRates {

    public void preGame(Participant members[], float membersCof[]) {
        for (int i = 0; i < 4; i++) {
            System.out.println("№" + (i + 1) + members[i].toString());
            System.out.println("КОЭФФИЦИЕНТ: " + Coefficient(members[i]) + "\n");
            membersCof[i] = Coefficient(members[i]);
        }
    }

    public int Winner() {
        int min = 0;
        int max = 3;
        int winner = new Random().nextInt((max - min) + 1) + min;
        return winner;
    }

    public float Coefficient(Participant member) {
        float zmax = (70 + 10) / 2;
        float z = (member.speed + member.power) / member.age;
        return (2 - z / zmax);
    }

    public float Reward(int win, int choice, float moneyRate, float membersCof[]) {
        float add = 0;
        if (win == choice) {
            add = moneyRate * membersCof[win];
            System.out.println("Поздравляю! Ваш выигрыш составил " + add + " монет");
        } else System.out.println("К сожалению, ваша ставка не зашла:(");
        return add;
    }
}


