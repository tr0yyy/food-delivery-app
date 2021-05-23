package services;

import food.Ingredient;
import food.Local;
import food.Produs;
import order.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLTools {
    private final String MySQL = "jdbc:mysql://localhost:3306/proiect_java?useSSL=false";
    private final String userName = "root";
    private final String password = "java123";
    private final Connection con = DriverManager.getConnection(MySQL, userName, password);

    public SQLTools() throws SQLException {
    }

    public void insertUser(User user){
        String query = "insert into user (username, nume, prenume, nr_telefon, adresa) values";
        query += " ('" + user.getUsername() + "', '" + user.getNume() + "', '" + user.getPrenume() +
                "', '" + user.getNrTelefon() + "', '" + user.getAdresa() + "');";
        try {
            Statement stmt = con.createStatement();
            stmt.execute(query);
            stmt.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertFirmaLivrare(String denumire){
        String query = "insert into firma_livrare (denumire) value" + "('" + denumire + "');";
        try {
            Statement stmt = con.createStatement();
            stmt.execute(query);
            stmt.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertLocal(Local local){
        String query = "insert into local (denumire_local, adresa, oras) VALUES "
                + "('" + local.getDenumire() + "', '"+ local.getStrada() + "', '" +
        local.getOras() + "');";
        try {
            Statement stmt = con.createStatement();
            stmt.execute(query);
            stmt.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertIngredient(String denumire_ingredient){
        String query = "insert into ingredient (denumire_ingredient) value ('" +
                denumire_ingredient + "');";
        try {
            Statement stmt = con.createStatement();
            stmt.execute(query);
            stmt.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProdus(String localName, Produs produs) {
        String getLocalID = "select local_id from Local where lower(denumire_local)" +
                "like lower('" + localName + "')";
        String query = "insert into produs (local_id, denumire_produs, pret) VALUES"
                + " ((" + getLocalID + "), '" + produs.getDenumire() + "', " +
                produs.getPret() + ");";
        try {
            Statement stmt = con.createStatement();
            stmt.execute(query);
            for (Ingredient i :
                    produs.getIngrediente()) {
                String getProdusID = "select produs_id from produs where lower(denumire_produs) like" +
                        " lower('" + produs.getDenumire() + "')";
                query = "insert into alocare (produs_id, ingredient, cantitate) VALUES " +
                        " ((" + getProdusID + "), '" + i.getDenumire() + "'," + i.getCantitate()
                        + ");";
                stmt.execute(query);
            }
            stmt.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void selectProduse(){
        String query = "select * from produs";
        try {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                String nebunie = res.getString("denumire_produs");
                System.out.println(nebunie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Local> readRestaurantsSQL() throws InstantiationException, IllegalAccessException {
        ArrayList<Local> localuri = new ArrayList<>();
        Local bufferLocal = Singleton.getInstance(Local.class);
        Produs bufferProdus = Singleton.getInstance(Produs.class);
        Ingredient ing = Singleton.getInstance(Ingredient.class);
        try {
            Statement stmt = con.createStatement();
            ResultSet resLocal = stmt.executeQuery("select l.denumire_local, l.adresa, l.oras, " +
                    "p.denumire_produs, p.pret, i.denumire_ingredient, a.cantitate " +
                    "from local l join produs p using(local_id) join alocare a using(produs_id) " +
                    "join ingredient i on a.ingredient = i.denumire_ingredient;");
            boolean OK = false;
            boolean OK2 = false;
            String denumireAnt = "";
            String denumireAntProd = "";
            List<Produs> produse = new ArrayList<Produs>();
            List<Ingredient> ingrediente = new ArrayList<>();
            while (resLocal.next()){
                if (OK == false) {
                    bufferLocal.setDenumire(resLocal.getString("denumire_local"));
                    bufferLocal.setStrada(resLocal.getString("adresa"));
                    bufferLocal.setOras(resLocal.getString("oras"));
                    denumireAnt = resLocal.getString("denumire_local");
                    OK = true;
                }
                else if(OK == true && !(resLocal.getString("denumire_local").equals(denumireAnt))) {
                    bufferProdus.setIngrediente(ingrediente);
                    produse.add(new Produs(bufferProdus));
                    bufferLocal.setListaProduse(produse);
                    localuri.add(new Local(bufferLocal));
                    produse = new ArrayList<Produs>();
                    ingrediente = new ArrayList<>();
                    OK2 = false;
                    bufferLocal.setDenumire(resLocal.getString("denumire_local"));
                    bufferLocal.setStrada(resLocal.getString("adresa"));
                    bufferLocal.setOras(resLocal.getString("oras"));
                    denumireAnt = resLocal.getString("denumire_local");
                }
                if(OK2 == false){
                    bufferProdus.setDenumire(resLocal.getString("denumire_produs"));
                    bufferProdus.setPret(resLocal.getFloat("pret"));
                    ingrediente = new ArrayList<>();
                    denumireAntProd = resLocal.getString("denumire_produs");
                    OK2 = true;
                }
                else if(OK2 == true && !(resLocal.getString("denumire_produs").equals(denumireAntProd))) {
                    bufferProdus.setIngrediente(ingrediente);
                    produse.add(new Produs(bufferProdus));
                    bufferProdus.setDenumire(resLocal.getString("denumire_produs"));
                    bufferProdus.setPret(resLocal.getFloat("pret"));
                    ingrediente = new ArrayList<>();
                    denumireAntProd = resLocal.getString("denumire_produs");
                }
                ing.setDenumire(resLocal.getString("denumire_ingredient"));
                ing.setCantitate(resLocal.getFloat("cantitate"));
                ingrediente.add(new Ingredient(ing));
            }
            bufferProdus.setIngrediente(ingrediente);
            produse.add(new Produs(bufferProdus));
            bufferLocal.setListaProduse(produse);
            localuri.add(bufferLocal);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return localuri;
    }
}
