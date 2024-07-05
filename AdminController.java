package com.example.hrmanagementtejaswi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class AdminController implements Initializable {
    public TableView<Admin> adminTable;
    public TableColumn<Admin, Integer> id;
    public TableColumn<Admin, String> name;
    public TableColumn<Admin, String> password;
    public TableColumn<Admin, String> city;
    public TextField uid;
    public TextField uname;
    public TextField upassword;
    public TextField ucity;
    @FXML
    private Label welcomeText;

    ObservableList<Admin> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fetchData();
    }

    @FXML
    private void fetchData() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM admin";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String city = resultSet.getString("city");
                adminTable.getItems().add(new Admin(id, name, password, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Admin, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Admin, String>("name"));
        password.setCellValueFactory(new PropertyValueFactory<Admin, String>("password"));
        city.setCellValueFactory(new PropertyValueFactory<Admin, String>("city"));
        adminTable.setItems(list);
    }

    public void insertData(ActionEvent actionEvent) {
        String name = uname.getText();
        String password = upassword.getText();
        String city = ucity.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO admin (name, password, city) VALUES ('" + name + "','" + password + "','" + city + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(ActionEvent actionEvent) {
        String id = uid.getText();
        String name = uname.getText();
        String password = upassword.getText();
        String city = ucity.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "UPDATE admin SET name='" + name + "', password='" + password + "', city='" + city + "' WHERE id='" + id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(ActionEvent actionEvent) {
        String id = uid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "DELETE FROM admin WHERE id='" + id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadData(ActionEvent actionEvent) {
        String id = uid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM admin WHERE id='" + id + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String city = resultSet.getString("city");

                uname.setText(name);
                upassword.setText(password);
                ucity.setText(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
