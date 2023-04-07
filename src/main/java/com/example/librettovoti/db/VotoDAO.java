package com.example.librettovoti.db;

import com.example.librettovoti.model.Voto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VotoDAO {

    public List<Voto> getVoti(){

        try {
            Connection connection = DBConnect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Voto getVotoByNomeCorso(String nomeCorso){
        return null;
    }

    public boolean insVoto(Voto voto){
        return false;
    }
}
