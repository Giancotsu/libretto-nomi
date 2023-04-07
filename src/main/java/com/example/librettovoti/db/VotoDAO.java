package com.example.librettovoti.db;

import com.example.librettovoti.model.Voto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VotoDAO {

    public List<Voto> getVoti(){

        String query = "SELECT * FROM voto";

        try {
            Connection connection = DBConnect.getConnection();


            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Voto> voti =  new ArrayList<Voto>();

            while(resultSet.next()){
                LocalDate date = resultSet.getDate("data").toLocalDate();
                Voto votoDB = new Voto(resultSet.getString("nome_corso"), resultSet.getInt("voto"), date);
                voti.add(votoDB);
            }
            connection.close();
            return voti;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Voto getVotoByNomeCorso(String nomeCorso){
        return null;
    }

    public boolean insVoto(Voto voto){

        String sql = "INSERT INTO voto (`nome_corso`, `voto`, `data`) "
                +"VALUES (?, ?, ?);" ;

        try {
            Connection connection = DBConnect.getConnection();


            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, voto.getNomeCorso());
            ps.setInt(2, voto.getVoto());
            ps.setDate(3, Date.valueOf(voto.getDataEsame()));

            ps.executeUpdate();

            connection.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }



    }
}
