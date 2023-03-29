package com.company;

public class Tildung {

    public void main() {

        Double Darlehen = 10000.00;
        Double Jahreszinssatz = 4.8;
        Double Annuitaetsrate = 2000.00;

        System.out.println("Darlehensumme: " + Darlehen);
        System.out.println("Jahreszinssatz in Prozent: " + Jahreszinssatz);
        System.out.println("Annuitaetsrate (Euro pro Jahr): " + Annuitaetsrate + "\n\n");

        System.out.println("Jahr       Zinsen       Tilgung       Restschuld");
        System.out.println("====================================================");

        //byte i = 1;

        Double Restschuld= Darlehen, Zinsen,Tilgung,result,scale;



        for(byte i=1; i<10000000;i++){
            if (Restschuld<0){
                break;
            }
            Zinsen = (Restschuld*Jahreszinssatz)/100;
            scale = Math.pow(10, 3);
            Zinsen = Math.ceil(Zinsen * scale) / scale;
            //Zinsen=Math.pow(Zinsen,2);

            Tilgung=Annuitaetsrate-Zinsen;

            Restschuld = Restschuld-Tilgung;

            System.out.println(i + "          "+ Zinsen + "        "+Tilgung + "          " + Restschuld);
        }


    }



}
