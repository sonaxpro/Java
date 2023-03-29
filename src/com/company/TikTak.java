package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class TikTak {
    public static char [][]  tiktac = new char [3][3];

    public static void TikTak(){

        for (byte i=0; i<3;i++){
            for (byte j=0;j<3;j++)
                tiktac[i][j]='_';
        }

        byte player=1; byte wer_gewonnen =0;
        tiktac_zeigen((byte) 1);
        for (byte i=1;i<=9;i++){
            player = (byte) (i%2==0?2:1);
            tiktac_eintippen(player,i);
            tiktac_zeigen(i);
            wer_gewonnen = wer_gewonnen();
            if(wer_gewonnen==1){
                System.out.println("Player 1 ist gewonnen!");
                break;
            } else if(wer_gewonnen==2){
                System.out.println("Player 2 ist gewonnen!");
                break;
            }
        }
    }

    public static void tiktac_zeigen(byte schritt){

        System.out.print("\n\n\n\n\n\n\n\nTikTak. ");
        if(schritt!=0) System.out.println("Schritt №"+schritt);
        //else if(schritt==0){

        //}
        System.out.print("     ");
        for (byte i=0; i<1;i++){
            for (byte j=0;j<tiktac[i].length;j++){
                System.out.print(j+"   ");
            }
        }
        System.out.println("<-y");
        for (byte i=0; i<tiktac.length;i++){
            System.out.print(i + ". | ");

            for (byte j=0;j<tiktac[i].length;j++)
                System.out.print(tiktac[i][j] + " | ");

            System.out.println();
        }
        System.out.println("↑X");
    }

    public static void tiktac_eintippen(byte player, byte schritt){
        if (player != (byte) 1 && player != (byte) 2 )
            System.out.println("Fehler! Braucht man nur Player 1 or 2");
        else {
            byte playerx,playery;
            Scanner num = new Scanner(System.in);


            System.out.print( "Player "+ player +": Tippen Sie X ein: ");
            playerx = num.nextByte();
            if (playerx<0 || playerx>=tiktac.length)
            {
                System.out.println("Fehler! Falsche Koordinate X");
                tiktac_eintippen(player, schritt);
            }
            else
            {
                System.out.print("Player "+ player +": Tippen Sie Y ein: ");
                playery = num.nextByte();
                if (playery<0 || playery>=tiktac.length)
                {
                    System.out.println("Fehler! Falsche Koordinate Y");
                    tiktac_eintippen(player, schritt);
                }
                else if(tiktac[playerx][playery]=='_'){

                    tiktac[playerx][playery]=player==1?'x':'o';
                }
                else {
                    tiktac_zeigen(schritt);
                    System.out.println("Koordinaten X: "+playerx+" Y:"+playery+" ist schon besitzt");
                    tiktac_eintippen(player, schritt);
                }
            }
        }
    }

    public static byte wer_gewonnen(){
        //Horizontal || waagerecht
        if(tiktac[0][0]=='x' && tiktac[0][1]=='x' && tiktac[0][2]=='x'){
            return 1;
        }
        if(tiktac[0][0]=='o' && tiktac[0][1]=='o' && tiktac[0][2]=='o'){
            return 2;
        }
        if(tiktac[1][0]=='x' && tiktac[1][1]=='x' && tiktac[1][2]=='x'){
            return 1;
        }
        if(tiktac[1][0]=='o' && tiktac[1][1]=='o' && tiktac[1][2]=='o'){
            return 2;
        }
        if(tiktac[2][0]=='x' && tiktac[2][1]=='x' && tiktac[2][2]=='x'){
            return 1;
        }
        if(tiktac[2][0]=='o' && tiktac[2][1]=='o' && tiktac[2][2]=='o'){
            return 2;
        }
        //Vertikal
        if(tiktac[0][0]=='x' && tiktac[1][0]=='x' && tiktac[2][0]=='x'){
            return 1;
        }
        if(tiktac[0][0]=='o' && tiktac[1][0]=='o' && tiktac[2][0]=='o'){
            return 2;
        }
        if(tiktac[0][1]=='x' && tiktac[1][1]=='x' && tiktac[2][1]=='x'){
            return 1;
        }
        if(tiktac[0][1]=='o' && tiktac[1][1]=='o' && tiktac[2][1]=='o'){
            return 2;
        }
        //schräg gegenüber
        if(tiktac[0][0]=='x' && tiktac[1][1]=='x' && tiktac[2][2]=='x'){
            return 1;
        }
        if(tiktac[0][0]=='o' && tiktac[1][1]=='o' && tiktac[2][2]=='o'){
            return 2;
        }
        if(tiktac[0][2]=='x' && tiktac[1][1]=='x' && tiktac[2][0]=='x'){
            return 1;
        }
        if(tiktac[0][2]=='o' && tiktac[1][1]=='o' && tiktac[2][0]=='o'){
            return 2;
        }


        return 0;
    }
}
