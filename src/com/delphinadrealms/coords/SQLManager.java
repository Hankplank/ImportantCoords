package com.delphinadrealms.coords;

import java.sql.*;
import java.util.ArrayList;

public class SQLManager {

    private Connection connection;

    public SQLManager() {
        this.connect();
    }

    public void setup() {
        if (connection!= null) {
            try {
                String createTableCoords = "CREATE TABLE IF NOT EXISTS coords(coordName text UNIQUE, coordX real, coordY real, coordZ real); ";
                Statement createTable = connection.createStatement();
                createTable.execute(createTableCoords);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void connect() {
        String url = "jdbc:SQLite:plugins/Coords/coords.db";
        try {
            this.connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addCoords(String name, double x, double y, double z) {
        if (connection!=null) {
            try {
                String addCoords = String.format("INSERT INTO coords VALUES (\"%s\", %f, %f, %f);", name, x, y, z);
                Statement addCoordsStatement = connection.createStatement();
                addCoordsStatement.execute(addCoords);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean removeCoords(String name) {
        if (connection!=null) {
            try {
                String removeCoords = String.format("DELETE from coords WHERE coordName=\"%s\"", name);
                Statement removeStatement = connection.createStatement();
                removeStatement.execute(removeCoords);
            return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public ArrayList<CoordsObject> getCoordList() {
        if (connection!= null) {
            try {
                String getCoords = "SELECT * FROM coords;";
                Statement getCoordsStatement = connection.createStatement();
                ResultSet results = getCoordsStatement.executeQuery(getCoords);
                ArrayList<CoordsObject> coordsList = new ArrayList<>();
                while (results.next()) {
                    coordsList.add(new CoordsObject(results.getString("coordName"), results.getDouble("coordX"),results.getDouble("coordY"), results.getDouble("coordZ")));
                }
                return coordsList;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }



}
