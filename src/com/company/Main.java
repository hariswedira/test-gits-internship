package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    private static int jawaban;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while(jawaban != 7){
            System.out.println("--- Soal Gits ---");
            System.out.println("1. Soal Logic substring yang sama ditara dua string\n" +
                    "2. Soal Logic Menampilkan angka yang tidak ada pada deret(1...n)\n" +
                    "3. Min-max Sum\n" +
                    "7. Exit");
            System.out.print("\nPilih nomor\t: ");
            jawaban = in.nextInt();
            switch (jawaban){
                case 1:
                    inputOne();
                    break;
                case 2:
                    inputTwo();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Tidak ada pilihan");
                    break;
            }
        }
    }

    //TODO : nomor 1
    public static void inputOne(){
        String first, second;

        System.out.print("\nHuruf satu\t: ");
        first = in.next();
        System.out.print("Huruf dua\t: ");
        second = in.next();
        first.toLowerCase();
        second.toLowerCase();

        splitOne(first,second);
    }

    public static void splitOne(String first, String second){
        char firstArray[] = new char[first.length()];
        char secondArray[] = new char[second.length()];
        ArrayList<Character> result = new ArrayList<Character>();
        ArrayList<Character> tempResult = new ArrayList<Character>();

        for (int i = 0; i < first.length() ; i++) {
            firstArray[i] = first.charAt(i);
        }
        for (int i = 0; i < second.length() ; i++) {
            secondArray[i] = second.charAt(i);
        }

        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if (firstArray[i] == secondArray[j]){
                    result.add(firstArray[i]);
                }
            }
        }

        if (result.size() > 0){
            System.out.print("\nYES : ");
            for (int i = 0; i < result.size(); i++) {
                for (int j = (i+1); j < result.size(); j++) {
                    if (result.get(i) == result.get(j)){
                        result.remove(i);
                    }
                }
            }

            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) == result.get(result.size()-1)){
                    System.out.print(result.get(i)+".");
                }else {
                    System.out.print(result.get(i)+", ");
                }
            }
            System.out.println("\n");
        }else {
            System.out.println("\nNO\n");
        }
    };

    //TODO : nomor dua
    public static void inputTwo(){
        int maksimum;
        ArrayList<Integer> deret = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        String jawab = "y";
        while(jawab.equalsIgnoreCase("y")){
            System.out.print("\nAngka : ");
            int angka = in.nextInt();
            deret.add(angka);
            System.out.print("\nMasukan Lagi ? (y/n) : ");
            jawab = in.next();
        }
        System.out.print("\nAngka inputan\t: ");
        for (int i = 0; i < deret.size(); i++) {
            if (deret.get(i) == deret.get(deret.size()-1)){
                System.out.print(deret.get(i)+".");
            }else {
                System.out.print(deret.get(i)+", ");
            }
        }

        maksimum = deret.get(0);
        for(int i = 0; i < deret.size(); i++) {
            if (deret.get(i) > maksimum){
                maksimum = deret.get(i);
            }
        }


        for (int i = 1; i <= maksimum ; i++) {
            temp.add(i);
        }

        System.out.println();
        for (int i = 0; i < temp.size() ; i++) {
            for (int j = 0; j < deret.size(); j++) {
                if (temp.get(i) == deret.get(j)){
                    result.add(temp.get(i));
                }
            }
        }

        System.out.println();
        for (int i = 0; i < temp.size() ; i++) {
            for (int j = 0; j < result.size(); j++) {
                if (temp.get(i) == result.get(j)){
                    temp.remove(i);
                }
            }
        }

        for (int i = 0; i < temp.size() ; i++) {
            if (temp.get(i) == temp.get(temp.size()-1)){
                System.out.print("Angka yang tidak ada didalam deret\t: "+temp.get(i)+".");
            }else {
                System.out.print("Angka yang tidak ada didalam deret\t: "+temp.get(i)+", ");
            }
        }

        System.out.println("\n");
    }
}