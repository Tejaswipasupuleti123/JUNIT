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

public class workerController implements Initializable {
    public TableView<Worker> workerTable;
    public TableColumn<Worker, Integer> empid;
    public TableColumn<Worker, String> emp;
    public TableColumn<Worker, String> empwd;
    public TableColumn<Worker, Double> salary;
    public TextField uempid;
    public TextField uname;
    public TextField upassword;
    public TextField usalary;
    @FXML
    private Label welcomeText;

    ObservableList<Worker> list = FXCollections.observableArrayList();

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
            String query = "SELECT * FROM employe";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int empid = resultSet.getInt("empid");
                String emp = resultSet.getString("emp");
                String empwd = resultSet.getString("empwd");
                double salary = resultSet.getDouble("salary");
                workerTable.getItems().add(new Worker(empid, emp, empwd, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empid.setCellValueFactory(new PropertyValueFactory<>("empid"));
        emp.setCellValueFactory(new PropertyValueFactory<>("emp"));
        empwd.setCellValueFactory(new PropertyValueFactory<>("empwd"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        workerTable.setItems(list);
    }

    public void InsertData(ActionEvent actionEvent) {
        String emp = uname.getText();
        String empwd = upassword.getText();
        double salary = Double.parseDouble(usalary.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO employe (emp, empwd, salary) VALUES ('" + emp + "','" + empwd + "','" + salary + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        int empid = Integer.parseInt(uempid.getText());
        String emp = uname.getText();
        String empwd = upassword.getText();
        double salary = Double.parseDouble(usalary.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "UPDATE employe SET emp='" + emp + "', empwd='" + empwd + "', salary='" + salary + "' WHERE empid='" + empid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {
        int empid = Integer.parseInt(uempid.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "DELETE FROM employe WHERE empid='" + empid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {
        int empid = Integer.parseInt(uempid.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3_tejaswi";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM employe WHERE empid='" + empid + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String emp = resultSet.getString("emp");
                String empwd = resultSet.getString("empwd");
                double salary = resultSet.getDouble("salary");

                uname.setText(emp);
                upassword.setText(empwd);
                usalary.setText(String.valueOf(salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}