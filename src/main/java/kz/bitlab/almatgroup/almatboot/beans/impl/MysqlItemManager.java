package kz.bitlab.almatgroup.almatboot.beans.impl;

import kz.bitlab.almatgroup.almatboot.beans.ItemManager;
import kz.bitlab.almatgroup.almatboot.dto.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MysqlItemManager implements ItemManager {

    private Connection connection;

    public MysqlItemManager(String url, String user, String password){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addItem(Items item) {
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items (name, price, amount) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getAmount());

            int rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Items> getAllItems() {

        ArrayList<Items> items = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT id, name, amount, price FROM items");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                items.add(
                        new Items(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("amount"),
                                resultSet.getDouble("price")
                        )
                );

//                items.add(
//                        new Items(
//                                resultSet.getLong(1),
//                                resultSet.getString(2),
//                                resultSet.getInt(3),
//                                resultSet.getDouble(4)
//                        )
//                );

                statement.close();

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public Items getItem(Long id) {

        Items item = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT id, name, amount, price " +
                    "FROM items " +
                    "WHERE id = ? LIMIT 1");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

               item = new Items(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("amount"),
                        resultSet.getDouble("price")
               );

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return item;

    }
}
