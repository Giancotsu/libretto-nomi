package com.example.librettovoti.db;

import com.example.librettovoti.model.Voto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VotoDAO {

    public List<Voto> getVoti(){

        try {
            Connection connection = DBConnect.getConnection();
            String query = "SELECT * FROM voto";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Voto> voti =  new ArrayList<Voto>();

            while(resultSet.next()){
                Voto votoDB = new Voto(resultSet.getString("nome_corso"), resultSet.getInt("voto"), null);
                voti.add(votoDB);
            }

            return voti;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Voto getVotoByNomeCorso(String nomeCorso){
        return null;
    }

    public boolean insVoto(Voto voto){
        return false;
    }
}
