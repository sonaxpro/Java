package com.company;

import java.util.Scanner;

//Anruf
//TikTakToe TikTakToe = new TikTakToe();
//TikTakToe.TikTakToe();

public class TikTakToe {
    private static String[][] tiktac = new String[3][3];
    private static boolean[] SteineX = new boolean[]{true, true, true, true, true, true};//[6]
    private static boolean[] SteineY = new boolean[]{true, true, true, true, true, true};//[6]

    public static void TikTakToe() {

        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++)
                tiktac[i][j] = "__";
        }

        byte player = 1;
        byte wer_gewonnen = 0;
        tiktac_zeigen((byte) 1);
        for (byte i = 1; i <= 13; i++) {
            player = (byte) (i % 2 == 0 ? 2 : 1);
            tiktac_eintippen(player, i);
            tiktac_zeigen(i);
            wer_gewonnen = wer_gewonnen();
            if (wer_gewonnen == 1) {
                System.out.println("Player 1 ist gewonnen!");
                break;
            } else if (wer_gewonnen == 2) {
                System.out.println("Player 2 ist gewonnen!");
                break;
            } else if (wer_gewonnen == 3) {
                System.out.println("Unentschieden! Gibt's mehr keine Steine!");
                break;
            }


        }
    }

    //ist der Stein frei?
    private static boolean SteineXY(byte player, byte Grosse) {
        if (player != (byte) 1 && player != (byte) 2) {
            System.out.println("Fehler! Player ist nicht korrekt");
        } else if (Grosse != (byte) 0 && Grosse != (byte) 1 && Grosse != (byte) 2) {
            System.out.println("Fehler! Grosse ist nicht korrekt");
        }

        if (player == 1) {
            //x
            if (Grosse == 0) {
                if (SteineX[0] == true || SteineX[1] == true) {
                    if (SteineX[0] == true) {
                        SteineX[0] = false;
                    } else if (SteineX[1] == true) {
                        SteineX[1] = false;
                    }
                    return true;
                }
            } else if (Grosse == 1) {
                if (SteineX[2] == true || SteineX[3] == true) {
                    if (SteineX[2] == true) {
                        SteineX[2] = false;
                    } else if (SteineX[3] == true) {
                        SteineX[3] = false;
                    }
                    return true;
                }
            } else if (Grosse == 2) {
                if (SteineX[4] == true || SteineX[5] == true) {
                    if (SteineX[4] == true) {
                        SteineX[4] = false;
                    } else if (SteineX[5] == true) {
                        SteineX[5] = false;
                    }
                    return true;
                }
            }
        } else if (player == 2) {
            //y
            if (Grosse == 0) {
                if (SteineY[0] == true || SteineY[1] == true) {
                    if (SteineY[0] == true) {
                        SteineY[0] = false;
                    } else if (SteineY[1] == true) {
                        SteineY[1] = false;
                    }
                    return true;
                }
            } else if (Grosse == 1) {
                if (SteineY[2] == true || SteineY[3] == true) {
                    if (SteineY[2] == true) {
                        SteineY[2] = false;
                    } else if (SteineY[3] == true) {
                        SteineY[3] = false;
                    }
                    return true;
                }
            } else if (Grosse == 2) {
                if (SteineY[4] == true || SteineY[5] == true) {
                    if (SteineY[4] == true) {
                        SteineY[4] = false;
                    } else if (SteineY[5] == true) {
                        SteineY[5] = false;
                    }
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean pruefung_2_Steinen(byte player, char Grosse) {
        if (player != (byte) 1 && player != (byte) 2) {
            System.out.println("Fehler! Player ist nicht korrekt");
        } else if (Grosse != '0' && Grosse != '1' && Grosse != '2') {
            System.out.println("Fehler! Grosse ist nicht korrekt");
        }


        byte count = 0;
        char playerchar = 'x';
        char charattemp;
        char GrosseChar = (char) Grosse;

        if (player == (byte) 1) {
            playerchar = 'x';
        } else if (player == (byte) 2) {
            playerchar = 'y';
        }

        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {

                if (tiktac[i][j].charAt(1) == playerchar) {
                    charattemp = tiktac[i][j].charAt(0);
                    if (charattemp == Grosse) {
                        count++;
                    }
                }
            }
        }
        if (count >= 2) {
            return false;
        } else {
            return true; //Erfolgreich, darf man schreiben
        }
    }

    private static void tiktac_zeigen(byte schritt) {

        System.out.print("\n\n\n\n\n\n\n\nTikTak. ");
        if (schritt != 0) System.out.println("Schritt N" + schritt);
        //else if(schritt==0){

        //}
        System.out.print("     ");
        for (byte i = 0; i < 1; i++) {
            for (byte j = 0; j < tiktac[i].length; j++) {
                System.out.print(j + "     ");
            }
        }
        System.out.println("<-y");
        for (byte i = 0; i < tiktac.length; i++) {
            System.out.print(i + ". | ");

            for (byte j = 0; j < tiktac[i].length; j++)
                System.out.print(tiktac[i][j] + " | ");

            System.out.println();
        }
        System.out.println("X");
        //Steine Zeigen
        String Steinen1 = "Steinen des Players 1: ";
        String Steinen2 = "Steinen des Players 2: ";
        for (byte i = 0; i < 6; i++) {
            if (SteineX[i] == true) {
                if (i == 0 || i == 1) {
                    Steinen1 += "0 ";
                } else if (i == 2 || i == 3) {
                    Steinen1 += "1 ";
                } else if (i == 4 || i == 5) {
                    Steinen1 += "2 ";
                }
            }
            if (SteineY[i] == true) {
                if (i == 0 || i == 1) {
                    Steinen2 += "0 ";
                } else if (i == 2 || i == 3) {
                    Steinen2 += "1 ";
                } else if (i == 4 || i == 5) {
                    Steinen2 += "2 ";
                }
            }
            //SteineX[i];
            //SteineY[i];
        }
        System.out.println(Steinen1);
        System.out.println(Steinen2);
    }

    private static void tiktac_eintippen(byte player, byte schritt) {

        if (player != (byte) 1 && player != (byte) 2)
            System.out.println("Fehler! Braucht man nur Player 1 or 2");
        else {
            byte playerx, playery;
            byte player_grosse;
            char player_grosse_char;
            Scanner num = new Scanner(System.in);


            System.out.print("Player " + player + ": Tippen Sie X ein: ");
            playerx = num.nextByte();
            if (playerx < 0 || playerx >= tiktac.length) {
                System.out.println("Fehler! Falsche Koordinate X");
                tiktac_eintippen(player, schritt);
            } else {
                System.out.print("Player " + player + ": Tippen Sie Y ein: ");
                playery = num.nextByte();


                if (playery < 0 || playery >= tiktac.length) {
                    System.out.println("Fehler! Falsche Koordinate Y");
                    tiktac_eintippen(player, schritt);
                } else {
                    if ((player == 1 && tiktac[playerx][playery].charAt(1) == 'x') || (player == 2 && tiktac[playerx][playery].charAt(1) == 'y')) {
                        System.out.println("Fehler! Die Koordinate ist schon besitzt");
                        tiktac_eintippen(player, schritt);
                    } else {
                        System.out.print("Player " + player + ": Tippen Sie die Grosse des Steins(0, 1, 2): ");
                        //player_grosse = num.nextByte();
                        player_grosse = num.nextByte();

                        if (player_grosse != 0 && player_grosse != 1 && player_grosse != 2) {
                            System.out.println("Fehler! Grosse kann nur 0,1,2 sein");
                            tiktac_eintippen(player, schritt);
                        } else {
                            String player_grosse_string = Byte.toString(player_grosse);
                            player_grosse_char = player_grosse_string.charAt(0);


                            /*if (pruefung_2_Steinen(player, player_grosse_char) == false) {
                                System.out.println("Fehler! Man darf nicht schreiben: Es gibt schon 2 Steine mit Grosse " + player_grosse_char);
                                tiktac_eintippen(player, schritt);
                            }
                            else*/
                            if (tiktac[playerx][playery] == "__" || tiktac[playerx][playery].charAt(0) < player_grosse_char) {

                                if (SteineXY(player, player_grosse)) {

                                    if (player == 1) {
                                        tiktac[playerx][playery] = player_grosse_char + "x";
                                    } else if (player == 2) {
                                        tiktac[playerx][playery] = player_grosse_char + "y";
                                    }


                                } else {
                                    System.out.println("Fehler! Man darf nicht schreiben: Es hat schon 2 Steine mit den Grossen " + player_grosse_char + " ausgegeben");
                                    tiktac_eintippen(player, schritt);
                                }


                            } else if (tiktac[playerx][playery].charAt(0) >= player_grosse_char) {
                                System.out.println("Fehler! Man braucht grosser Stein");
                                tiktac_eintippen(player, schritt);
                            }
                        }
                    }
                }
            }
        }
    }


    private static byte wer_gewonnen() {
        //Horizontal || waagerecht
        if (tiktac[0][0].charAt(1) == 'x' && tiktac[0][1].charAt(1) == 'x' && tiktac[0][2].charAt(1) == 'x') {
            return 1;
        }
        if (tiktac[0][0].charAt(1) == 'y' && tiktac[0][1].charAt(1) == 'y' && tiktac[0][2].charAt(1) == 'y') {
            return 2;
        }
        if (tiktac[1][0].charAt(1) == 'x' && tiktac[1][1].charAt(1) == 'x' && tiktac[1][2].charAt(1) == 'x') {
            return 1;
        }
        if (tiktac[1][0].charAt(1) == 'y' && tiktac[1][1].charAt(1) == 'y' && tiktac[1][2].charAt(1) == 'y') {
            return 2;
        }
        if (tiktac[2][0].charAt(1) == 'x' && tiktac[2][1].charAt(1) == 'x' && tiktac[2][2].charAt(1) == 'x') {
            return 1;
        }
        if (tiktac[2][0].charAt(1) == 'y' && tiktac[2][1].charAt(1) == 'y' && tiktac[2][2].charAt(1) == 'y') {
            return 2;
        }
        //Vertikal
        if (tiktac[0][0].charAt(1) == 'x' && tiktac[1][0].charAt(1) == 'x' && tiktac[2][0].charAt(1) == 'x') {
            return 1;
        }
        if (tiktac[0][0].charAt(1) == 'y' && tiktac[1][0].charAt(1) == 'y' && tiktac[2][0].charAt(1) == 'y') {
            return 2;
        }
        if (tiktac[0][1].charAt(1) == 'x' && tiktac[1][1].charAt(1) == 'x' && tiktac[2][1].charAt(1) == 'x') {
            return 1;
        }
        if (tiktac[0][1].charAt(1) == 'y' && tiktac[1][1].charAt(1) == 'y' && tiktac[2][1].charAt(1) == 'y') {
            return 2;
        }
        //schräg gegenüber
        if (tiktac[0][0].charAt(1) == 'x' && tiktac[1][1].charAt(1) == 'x' && tiktac[2][2].charAt(1) == 'x') {
            return 1;
        }
        if (tiktac[0][0].charAt(1) == 'y' && tiktac[1][1].charAt(1) == 'y' && tiktac[2][2].charAt(1) == 'y') {
            return 2;
        }
        if (tiktac[0][2].charAt(1) == 'x' && tiktac[1][1].charAt(1) == 'x' && tiktac[2][0].charAt(1) == 'x') {
            return 1;
        }
        if (tiktac[0][2].charAt(1) == 'y' && tiktac[1][1].charAt(1) == 'y' && tiktac[2][0].charAt(1) == 'y') {
            return 2;
        }


        //Gibt's etwas noch?
        boolean Steine1 = false;
        boolean Steine2 = false;
        for (byte i = 0; i < 6; i++) {
            if (SteineX[i] == true) {
                Steine1 = true;
            }
            if (SteineY[i] == true) {
                Steine2 = true;
            }
        }
        if (Steine1 == false && Steine2 == false) {
            return 3;
        }
        return 0;
    }
}
 