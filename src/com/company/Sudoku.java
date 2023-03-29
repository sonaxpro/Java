package com.company;

public class Sudoku {
    //Sudoku Sudoku = new Sudoku();
    //Sudoku.Main();
    private static byte[][] array = new byte[9][9];
    /*private static byte[][] array =
        {
            {1,2,3,4,5,6,7,8,9},
            {4,5,6,7,8,9,1,2,3},
            {7,8,9,1,2,3,4,5,6},
            {2,3,4,5,6,7,8,9,1},
            {5,6,7,8,9,1,2,3,4},
            {8,9,1,2,3,4,5,6,7},
            {3,4,5,6,7,8,9,1,2},
            {6,7,8,9,1,2,3,4,5},
            {9,1,2,3,4,5,6,7,8}
        };*/

    public static void Main() {
        sudoku_erste_random();
        //sudoku_erste_generation();
        //sudoku_bis_ende_ausfuelen();
        //sudoku_random_austausch();
        //sudoku_austausch( (byte) 1,(byte) 5,(byte) 6); //0-8
        sudoku_quadrat_zeigen();
    }

    private static void sudoku_random_austausch(){
        byte randquadrat, randmethod,randobj1,randobj2,randquadratpunkt = 0;


        for (byte i=0;i<100;i++){

            randquadrat     = (byte) (Math.random() * 3 + 1); //vom 1 bis 3
            randmethod      = (byte) (Math.random() * 3 ); //vom 0 bis 2
            //randmethod =2;
            randobj1        = (byte) (Math.random() * 3 + 1); //vom 1 bis 3
            randobj2        = (byte) (Math.random() * 3 + 1); //vom 1 bis 3

            for (byte j = 0; j<100;j++){
                if(randobj1==randobj2){
                    randobj2  = (byte) (Math.random() * 3 + 1); //vom 1 bis 3
                }
                else break;
            }


            if (randmethod==0||randmethod==1){

                randquadratpunkt= quadratpunkt(randquadrat);
                randobj1        = (byte) (randquadratpunkt + randobj1);
                randobj2        = (byte) (randquadratpunkt + randobj2);


                System.out.println      (randmethod+" "+randobj1+" "+randobj2);
                sudoku_austausch_linie  (randmethod, randobj1, randobj2);
            }
            else if (randmethod==2){
                randmethod      = (byte) (Math.random() * 2 ); //vom 0 bis 1 Horrizontal oder Vertikal
                System.out.println(randmethod+" "+randobj1+" "+randobj2);
                //sudoku_austausch_quadrat(randmethod, randobj1,randobj2);
                sudoku_austausch_quadrat(randmethod,randobj1,randobj2);
            }




        }
    }

    private static byte quadratpunkt(byte randquadrat){
        byte randquadratpunkt=-1;

        if(randquadrat==1){
            randquadratpunkt=-1;
        }
        else if(randquadrat==2){
            randquadratpunkt=2;
        }
        else if(randquadrat==3){
            randquadratpunkt=5;
        }
        return randquadratpunkt;
    }

    private static void sudoku_austausch_quadrat(byte method,byte objekt1, byte objekt2){
        byte [][] array_temp = new byte[6][9];
        byte quadratpunkt1 = quadratpunkt(objekt1);
        byte quadratpunkt2 = quadratpunkt(objekt2);

        //Horizontal == 0
        if (method == 0){
            for (byte i=0;i<9;i++){
                array_temp[0][i]=array[quadratpunkt1+1][i];
                array_temp[1][i]=array[quadratpunkt1+2][i];
                array_temp[2][i]=array[quadratpunkt1+3][i];

                array_temp[3][i]=array[quadratpunkt2+1][i];
                array_temp[4][i]=array[quadratpunkt2+2][i];
                array_temp[5][i]=array[quadratpunkt2+3][i];
            }

            array[quadratpunkt1+1]  = array_temp[3];
            array[quadratpunkt1+2]  = array_temp[4];
            array[quadratpunkt1+3]  = array_temp[5];

            array[quadratpunkt2+1]  = array_temp[0];
            array[quadratpunkt2+2]  = array_temp[1];
            array[quadratpunkt2+3]  = array_temp[2];
        }
        //Vertikal == 1
        else if (method == 1){
            for (byte i=0;i<9;i++){
                array_temp[0][i]=array[i][quadratpunkt1+1];
                array_temp[1][i]=array[i][quadratpunkt1+2];
                array_temp[2][i]=array[i][quadratpunkt1+3];

                array_temp[3][i]=array[i][quadratpunkt2+1];
                array_temp[4][i]=array[i][quadratpunkt2+2];
                array_temp[5][i]=array[i][quadratpunkt2+3];

            }
            for (byte i=0;i<9;i++){
                array[i][quadratpunkt2+1]=array_temp[0][i];
                array[i][quadratpunkt2+2]=array_temp[1][i];
                array[i][quadratpunkt2+3]=array_temp[2][i];

                array[i][quadratpunkt1+1]=array_temp[3][i];
                array[i][quadratpunkt1+2]=array_temp[4][i];
                array[i][quadratpunkt1+3]=array_temp[5][i];
            }
        }
    }
    private static void sudoku_austausch_linie(byte method,byte objekt1, byte objekt2){
        byte [][] array_temp = new byte[2][9];

        //Horizontal == 0
        if (method == 0){
            //System.out.println("Horizhjhgjontal");
            for (byte i=0;i<9;i++){
                array_temp[0][i]=array[objekt1][i];
                array_temp[1][i]=array[objekt2][i];
            }
            array[objekt1]=array_temp[1];
            array[objekt2]=array_temp[0];
        }
        //Vertikal == 1
        if (method == 1){
            //System.out.println("Vertikal");
            for (byte i=0;i<9;i++){
                array_temp[0][i]=array[i][objekt1];
                array_temp[1][i]=array[i][objekt2];
            }
            for (byte i=0;i<9;i++){
                array[i][objekt1]=array_temp[1][i];
                array[i][objekt2]=array_temp[0][i];
            }
        }
    }

    private static void sudoku_erste_random() {
        byte randomx = 0, randomy = 0, randomnum = 0;


        for (int i = 0; i < 100000000; i++) {
            randomx = (byte) (Math.random() * 9);//von 0 bis 8
            randomy = (byte) (Math.random() * 9);//von 0 bis 8
            randomnum = (byte) (Math.random() * 9 + 1); //vom 1 bis 9

            sudoku_insert(randomx, randomy, randomnum);
        }
    }

    private static void sudoku_bis_ende_ausfuelen() {
        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                for (byte k = 1; k <= 9; k++) {
                    sudoku_insert(i, j, k);
                }
            }
        }
    }

    private static void sudoku_insert(byte randomx, byte randomy, byte randomnum) {
        byte error = 0, Quadrat = 0;

        if (array[randomx][randomy] == 0) {


            for (byte j = 0; j < 9; j++) {
                //Prüfung Zeile (строка)
                if (array[randomx][j] == randomnum && error == 0) {
                    error = 1;
                    //System.out.println("Нельзя записать! По горизонтали совпадение");
                    // System.out.println("Array["+randomx+"]["+randomy+"]="+randomnum+" совпадает с array["+randomx+"]["+j+"]="+array[randomx][j]);
                }
                //Prüfung Spalte (столбец)
                if (array[j][randomy] == randomnum && error == 0) {
                    error = 1;
                    //.out.print("Нельзя! По вертикали  совпадение");
                }
            }

            //Welche Quadrat
            //1 2 3
            //4 5 6
            //7 8 9
            if (randomx == 0 || randomx == 1 || randomx == 2) {
                if (randomy == 0 || randomy == 1 || randomy == 2) {
                    Quadrat = 1;
                } else if (randomy == 3 || randomy == 4 || randomy == 5) {
                    Quadrat = 2;
                } else if (randomy == 6 || randomy == 7 || randomy == 8) {
                    Quadrat = 3;
                }
            }
            if (randomx == 3 || randomx == 4 || randomx == 5) {
                if (randomy == 0 || randomy == 1 || randomy == 2) {
                    Quadrat = 4;
                } else if (randomy == 3 || randomy == 4 || randomy == 5) {
                    Quadrat = 5;
                } else if (randomy == 6 || randomy == 7 || randomy == 8) {
                    Quadrat = 6;
                }
            }
            if (randomx == 6 || randomx == 7 || randomx == 8) {
                if (randomy == 0 || randomy == 1 || randomy == 2) {
                    Quadrat = 7;
                } else if (randomy == 3 || randomy == 4 || randomy == 5) {
                    Quadrat = 8;
                } else if (randomy == 6 || randomy == 7 || randomy == 8) {
                    Quadrat = 9;
                }
            }
            //Prüfung konkrette Quadrat
            //1 2 3
            //4 5 6
            //7 8 9
            if (error == 0) {
                if (Quadrat == 1) {
                    if (array[0][0] == randomnum || array[0][1] == randomnum || array[0][2] == randomnum ||
                            array[1][0] == randomnum || array[1][1] == randomnum || array[1][2] == randomnum ||
                            array[2][0] == randomnum || array[2][1] == randomnum || array[2][2] == randomnum)
                        error = 1;
                } else if (Quadrat == 2) {
                    if (array[0][3] == randomnum || array[0][4] == randomnum || array[0][5] == randomnum ||
                            array[1][3] == randomnum || array[1][4] == randomnum || array[1][5] == randomnum ||
                            array[2][3] == randomnum || array[2][4] == randomnum || array[2][5] == randomnum)
                        error = 1;
                } else if (Quadrat == 3) {
                    if (array[0][6] == randomnum || array[0][7] == randomnum || array[0][8] == randomnum ||
                            array[1][6] == randomnum || array[1][7] == randomnum || array[1][8] == randomnum ||
                            array[2][6] == randomnum || array[2][7] == randomnum || array[2][8] == randomnum)
                        error = 1;
                } else if (Quadrat == 4) {
                    if (array[3][0] == randomnum || array[3][1] == randomnum || array[3][2] == randomnum ||
                            array[4][0] == randomnum || array[4][1] == randomnum || array[4][2] == randomnum ||
                            array[5][0] == randomnum || array[5][1] == randomnum || array[5][2] == randomnum)
                        error = 1;
                } else if (Quadrat == 5) {
                    if (array[3][3] == randomnum || array[3][4] == randomnum || array[3][5] == randomnum ||
                            array[4][3] == randomnum || array[4][4] == randomnum || array[4][5] == randomnum ||
                            array[5][3] == randomnum || array[5][4] == randomnum || array[5][5] == randomnum)
                        error = 1;
                } else if (Quadrat == 6) {
                    if (array[3][6] == randomnum || array[3][7] == randomnum || array[3][8] == randomnum ||
                            array[4][6] == randomnum || array[4][7] == randomnum || array[4][8] == randomnum ||
                            array[5][6] == randomnum || array[5][7] == randomnum || array[5][8] == randomnum)
                        error = 1;
                } else if (Quadrat == 7) {
                    if (array[6][0] == randomnum || array[6][1] == randomnum || array[6][2] == randomnum ||
                            array[7][0] == randomnum || array[7][1] == randomnum || array[7][2] == randomnum ||
                            array[8][0] == randomnum || array[8][1] == randomnum || array[8][2] == randomnum)
                        error = 1;
                } else if (Quadrat == 8) {
                    if (array[6][3] == randomnum || array[6][4] == randomnum || array[6][5] == randomnum ||
                            array[7][3] == randomnum || array[7][4] == randomnum || array[7][5] == randomnum ||
                            array[8][3] == randomnum || array[8][4] == randomnum || array[8][5] == randomnum)
                        error = 1;
                } else if (Quadrat == 9) {
                    if (array[6][6] == randomnum || array[6][7] == randomnum || array[6][8] == randomnum ||
                            array[7][6] == randomnum || array[7][7] == randomnum || array[7][8] == randomnum ||
                            array[8][6] == randomnum || array[8][7] == randomnum || array[8][8] == randomnum)
                        error = 1;
                }
            }
            if (error == 0) {
                array[randomx][randomy] = randomnum;
            }
        }
    }


    private static void sudoku_quadrat_zeigen() {
        String text = "";
        System.out.print("Y->   ");
        for (byte y = 1; y <= 9; y++) {

            text = y == 3 || y == 6 ? "      " : "   ";
            System.out.print(y + text);
        }
        System.out.println("  ↓X\n------------------------------------------------------");

        for (byte x = 1; x <= 9; x++) {
            if (x == 4 || x == 7) System.out.println("");
            System.out.print(x + "     ");

            for (byte j = 0; j < 9; j++) {

                System.out.print(array[x - 1][j]);

                text = j == 2 || j == 5 ? "      " : " | ";
                if (j == 8) text = "      " + x;
                System.out.print(text);
            }
            System.out.println();
        }

        System.out.println("------------------------------------------------------");
        System.out.print("↑X    ");
        for (byte y = 1; y <= 9; y++) {

            text = y == 3 || y == 6 ? "      " : "   ";
            System.out.print(y + text);
        }
        System.out.print("  <-Y");
    }
}