package com.opticalix;


import com.opticalix.medicine.Runner;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Runner runner = new Runner();
        try {
            runner.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
