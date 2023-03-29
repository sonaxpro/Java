package com.company;

import java.util.Scanner;

public class Rechner {
    double a = 0;
    double b = 0;

    public void Main(){

        Rechner Rechner1 = new Rechner();
        //Rechner.Main();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tippen Sie erste Zahl ein(double): ");
        Rechner1.a= scanner.nextDouble();
        System.out.println("Tippen Sie das Symbol der Prozedur \n+ plus(summe), \n- Minus(Subtraktion), \n* Multiplikation, \n/ Division, \n% Rückstand: ");
        char prozedur = scanner.next().charAt(0);
        System.out.println("Tippen Sie zweite Zahl ein(double): ");
        Rechner1.b= scanner.nextDouble();
        if (prozedur=='+'){
            Rechner1.summe();
        }
        else if (prozedur=='-'){
            Rechner1.Subtraktion();
        }
        else if (prozedur=='/'){
            Rechner1.Division();
        }
        else if (prozedur=='*'){
            Rechner1.Multiplikation();
        }
        else if (prozedur=='%'){
            Rechner1.Rückstand();
        }
    }

    public double summe(){
        double sum=a+b;
        System.out.println("Summe ist "+sum);
        return sum;
    }

    //Вычитание
    public double Subtraktion(){
        double sum=a-b;
        System.out.println("Subtraktion ist "+sum);
        return sum;
    }
    //Умножение
    public double Multiplikation(){
        double sum=a*b;
        System.out.println("Multiplikation ist "+sum);
        return sum;
    }
    //Деление
    public double Division(){
        double sum=a/b;
        System.out.println("Division ist "+sum);
        return sum;
    }
    public double Rückstand(){
        double sum=a%b;
        System.out.println("Rückstand ist "+sum);
        return sum;
    }
    
}
