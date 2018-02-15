package hu.nyirszikszi;

import java.util.Arrays;
import java.util.Random;

public class Generator {
    int winningNumbers[];

    public Generator() {
        winningNumbers = new int[5];

        upload();
        show();
    }

    private int generate() {
        int min = 1;
        int max = 90;

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private void upload() {
        for (int i = 0; i < winningNumbers.length; i++) {
            int rand = generate();

            while (!isUnique(rand)) {
                rand = generate();
            }

            winningNumbers[i] = rand;
        }
    }

    private boolean isUnique(int num) {
        for (int i = 0; i < winningNumbers.length; i++) {
            if (winningNumbers[i] == num) {
                return false;
            }
        }

        return true;
    }

    private void sort() {
        Arrays.sort(winningNumbers);
    }

    private void show() {
        System.out.print("Nyerőszámok: ");
        for (int n : winningNumbers) {
            System.out.print(n + " ");
        }

        System.out.println();
        sort();

        System.out.print("Nyerőszámok növekvő sorrendben: ");
        for (int n : winningNumbers) {
            System.out.print(n + " ");
        }
    }
}