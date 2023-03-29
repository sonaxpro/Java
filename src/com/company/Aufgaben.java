package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Aufgaben {
    Aufgaben() {
    }

    public static void txt_create() {
        //File myObj = new File("Filename.txt");
        try {
            FileWriter FileWriter = new FileWriter("filename.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

