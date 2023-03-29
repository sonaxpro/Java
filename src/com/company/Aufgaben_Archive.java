package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Aufgaben_Archive {
    //public static void
    Aufgaben_Archive(){
        //System.out.println("Aufgabe A1! Hallo");
    }
    public static void rechner() {
        //System.out.println("Rechner! Hallo");
        Scanner num = new Scanner(System.in);
        int first, second;
        System.out.print("Enter first num: ");
        first = num.nextInt();
        System.out.print("Enter second num: ");
        second = num.nextInt();
        int sum = first + second;
        int minus = first - second;
        int Einteilung = first / second;
        int Multiplication = first * second;

        //System.out.println("Summa first+second ist: " + sum);
        //System.out.println("Subtrahieren first-second ist: " + minus);

        //String operator;
        System.out.print("\nWelche operation wollen Sie machen?:\n+ Summa\n- Minus\n/ Einteilung \n* Multiplikation");
        //int operator = num.nextInt();

        String operator;
        operator = num.nextLine();
        operator = num.nextLine();
        System.out.println(operator);

        if(operator.equals("+")){
            System.out.println("Summa ist " + sum);
        }else if(operator.equals("-")){
            System.out.println("Minus ist " + minus);
        }else if(operator.equals("/")){
            System.out.println("Einteilung ist " + Einteilung);
        }else if(operator.equals("*")){
            System.out.println("Multiplication ist " + Multiplication);
        } else {
            System.out.println("Error: Nicht korrekt! ");
        }


        /*System.out.println("Text ist: " + operator);
        switch (operator) {
            case 1:
                System.out.println("Summa ist " + sum);
                break;
            case 2:
                System.out.println("Minus ist " + minus);
                break;
            case 3:
                System.out.println("Einteilung ist " + Einteilung);
                break;

            default:
                System.out.println ("Leider muss man nur 1 oder 2 eintippen.");
                break;
        }
*/
        //String sentence = scanner.nextLine();


    }
    public static void rechner_sec_zu_jahr(){
        Scanner scanner = new Scanner(System.in);


        int resultjahr = 0, resultmonaten =0, resultstunden = 0, resulttagen=0, resultminuten=0;
        int jahrsekunden = 365 * 24 * 60 * 60; //31536000 ok
        int monatsekunden = jahrsekunden/12; //2628000 ok
        int tagesekunden =86400;
        int stundensekunden = tagesekunden/24;
        int minutesekunden = stundensekunden/60;
        System.out.print("Tippen Sie ein, wie viel Secunden braucht man zu konventieren: ");
        int sekunden = scanner.nextInt();
        int resultrest = sekunden;

        if(sekunden>=jahrsekunden){
            resultjahr = sekunden/jahrsekunden;
            resultrest = sekunden%jahrsekunden;
        }
        if(resultrest>= monatsekunden) {
            resultmonaten = resultrest/monatsekunden;
            resultrest = resultrest%monatsekunden;
        }
        if(resultrest>= tagesekunden) {
            resulttagen = resultrest/tagesekunden;
            resultrest = resultrest%tagesekunden;
        }
        if(resultrest>= stundensekunden) {
            resultstunden = resultrest/stundensekunden;
            resultrest = resultrest%stundensekunden;
        }
        if(resultrest>= minutesekunden) {
            resultminuten = resultrest/minutesekunden;
            resultrest = resultrest%minutesekunden;
        }

        String end = resultjahr + " Jahr(en), "+resultmonaten + " Monat(en), " + resulttagen + " Tag(en), " + resultstunden + " Stunde(n), " + resultminuten + " Minute(n), " + resultrest +" Sekunde(n)";
        System.out.println(end);
        rechner_sec_zu_jahr();

        //Aufgaben_Archive aufgabenArchive = new Aufgaben_Archive();
        //aufgabenArchive.rechner_sec_zu_jahr();
    }

    public static String rechner_jahr_zu_sec(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tippen Sie ein, wie viel Jahren braucht man in Sekunden zu konventieren: ");
        int jahren = scanner.nextInt();
        int jahrsekunden = 365 * 24 * 60 * 60; //31536000 ok
        int result = jahren*jahrsekunden;

        return result + " Sekunde(n)";
    }


    public static void gerade_Zahlen(){
        System.out.println("Gerade Zahlen");
        for(byte i = 0; i<=100; i+=2){
            System.out.print(i+" ");
        }

        System.out.println("\n\nUngerade Zahlen");
        /* Variant durch for auch funktioniert
        for(byte i = 1; i<=100; i+=2){
            System.out.print(i+" ");
        }*/
        byte a = 1;
        while (a <= 100) {
            System.out.print(a+" ");
            a+=2;
        }


        System.out.println("\n\nQuadrat Zahlen");
        int result;
        for(byte i = 1; i<=100; i++){
            result=i*i;
            System.out.println(i +" * "+i+ " = " + result);
        }




    }


    public static void primzahlen() {
        byte rest = 0;
        String i_primzahl_list="";

        for (byte i = 2; i <= 126; i++) {
            boolean i_primzahl = false;

            for (byte ia = 2; ia <= i; ia++) {
                if(i % ia==0 && i == ia){
                    i_primzahl = true;
                }
                if(i % ia==0 && i != ia){
                    break;
                }
            }

            if(i_primzahl == true){
                i_primzahl_list+=(i_primzahl_list != "")? ", ":"";
                i_primzahl_list+= i;
            }
        }
        System.out.println("Primzahlen sind: "+i_primzahl_list+".");
    }

    public static void minmax(){
        byte n=100;
        double avg=0;
        double[] array = new double[n];

        for(byte i=0; i<array.length; i++){
            array[i] = Math.random();
            avg+=array[i];
        }
        avg=avg/array.length;
        double min = array[0];
        double max = array[0];


        for (byte i=0; i<array.length; i++){
            //System.out.println(array[i]);
            if(array[i]>max) {
                max = array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }


        System.out.println("Min: "+min);
        System.out.println("Max: "+max);
        System.out.println("Avg: "+avg);
    }

    public void minmax_arrayList(){
        ArrayList<Double> arrayList = new ArrayList<Double>();
        double random=0, avg=0;
        byte n=126;
        for(byte i=0; i<n; i++){
            random =Math.random();
            arrayList.add (random);
            avg+=random;
        }
        double min = Collections.min(arrayList);
        double max = Collections.max(arrayList);
        avg=avg/n;
        //avg=avg/arrayList.indexOf();
        System.out.println("Min: "+min);
        System.out.println("Max: "+max);
        System.out.println("Avg: "+avg);
        System.out.println("Count: "+arrayList.size());
        //System.out.println(arrayList.toString)=;
        //double min = array[0];
        //double max = array[0];
    }

    public void sortArray() {
        byte[] array1 = {2, 4, 3, 2, 4, 5, 4};

        byte[] counter= new byte[array1.length];
        for (int i = 0; i < array1.length; i++) {
            counter[i]=1;
        }

        for(byte j = 0;j< array1.length; j++){
            if(counter[array1[j]]>1) continue;

            if (counter[array1[j]] == 1) {
                for (int k = 0; k < array1.length; k++) {
                    if (j == k) continue; //verpasst sich selbst

                    if (array1[j] == array1[k]) {
                        counter[array1[j]]++;
                    }
                }
                //System.out.print("Element ["+j+"]=");
                System.out.println(array1[j] + " wird " + counter[array1[j]] + " mal getzeigt");
            }
        }
    }

    public static void arrayList() {
        ArrayList<String> cars_array = new ArrayList<String>();
        cars_array.add("Porsche");
        cars_array.add("BMW");
        cars_array.add("Mercedes");
        //cars_array.sort();
        System.out.println(cars_array.get(2));
        System.out.println(cars_array.toString());
        cars_array.clear();
    }

    public static void zusammen_array(){
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(90);
        arr1.add(240);
        arr1.add(300);
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(10);
        arr2.add(13);
        arr2.add(14);
        arr2.add(20);
        arr2.add(25);
        ArrayList<Integer> arr3 = new ArrayList<Integer>();
        int avg=0;
        for (byte i=0; i<arr1.size();i++){
            arr3.add(arr1.get(i));
            avg+=arr1.get(i);
        }
        for (byte i=0; i<arr2.size();i++){
            arr3.add(arr2.get(i));
            avg+=arr2.get(i);
        }
        Collections.sort(arr3);
        int count = arr3.size();
        int median =  (count+1)/2;
        float median2 = (float) (arr3.get(median-1)+arr3.get(median))/2;
        //avg=avg/arr3.size();
        System.out.println(median2+arr3.toString());

    }


    public static void UserName_aendern(){

        Scanner scanner = new Scanner(System.in);
        //String UserName = scanner.nextLine();
        String UserName = "osama2 al34ba5ji";
        // UserName = Osama Alabaji
        int Space_Position = UserName.indexOf(" ");

        //Erste Buchstabe vom Name grösser machen + Vorname Extra
        char ch = Character.toUpperCase(UserName.charAt (0));
        String UserNameVorname= ch + UserName.substring (1,Space_Position);


        //Erste Buchstabe vom Familiename grösser machen
        char ch1 = Character.toUpperCase(UserName.charAt (Space_Position+1));
        String UserNameFamilieName = ch1 + UserName.substring (Space_Position+2);

        for(byte i=0;i<=9;i++){
            UserNameVorname = UserNameVorname.replace (Byte.toString(i) , "");
            UserNameFamilieName = UserNameFamilieName.replace(Byte.toString(i) , "");
        }

        /*//Trim
        System.out.println(UserNameFamilieName.trim());
        //Warum funktioniert nicht? Zeigt: "Al  ba ji" mit spaces

        UserNameVorname=UserNameVorname.trim();
        UserNameFamilieName= UserNameFamilieName.trim();

        System.out.println(UserNameVorname + " "+ UserNameFamilieName);

        char Erste_Buchstabe_des_Names                   = UserName.charAt(0);
        char Erste_Buchstabe_des_Familienames            = UserName.charAt(Space_Position+1);
        String Erste_Buchstabe_des_Names_String          = Character.toString(Erste_Buchstabe_des_Names);
        String Erste_Buchstabe_des_Familienames_String   = Character.toString(Erste_Buchstabe_des_Familienames);
        Erste_Buchstabe_des_Names_String                 = Erste_Buchstabe_des_Names_String.toUpperCase();
        Erste_Buchstabe_des_Familienames_String          = Erste_Buchstabe_des_Familienames_String.toUpperCase();

        System.out.println(Erste_Buchstabe_des_Names_String +" - "+ Erste_Buchstabe_des_Familienames_String);
        UserName.replace(UserName.charAt(0), Erste_Buchstabe_des_Names);


        String word =UserName;//= “Java";

        //char ch = Character.toUpperCase(word.charAt (0)); // = O
        //System.out.println(ch);
        word = ch + word.substring (1); //
        System.out.println(word);*/

    }
    public static void sortInsert() {
        byte[] arr = {3, 0, 1, 8, 7, 2, 5, 4, 9, 6};
        byte temp, j = 0;


        for (byte i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr));
            j = i;
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            if (i > 0) {
                for (j = i; j >= 0; j--) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
/*
        Aufgaben aufgaben = new Aufgaben();
        aufgaben.a1();
 */

}