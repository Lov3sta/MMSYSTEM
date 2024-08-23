package com.example.mmsystem;

import com.example.mmsystem.Admin.AdminRepository;
import com.example.mmsystem.Admin.TransactionSheetRepo;
import com.example.mmsystem.Admin.UserAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

//import static com.sun.webkit.dom.EventImpl.SELECT;

public class HelloController {
    //    LOGIN INT
    @FXML
    private TextField usernameTxt, password;
    @FXML
    private TextField passwordTxt;
    //    @FXML
//    private PasswordField passwordTxt;
    @FXML
    private Button login;
    @FXML
    private Button exitButton;
    @FXML
    private Label loginMsgLabel;
    @FXML
    private Hyperlink signUpHyperlink;
    @FXML
    private Label adminRegMsgLable;
    @FXML
    private Button Save;

    //        TransactionSheet
    @FXML
    private TextField customerTxt;
    @FXML
    private TextField contTxt;
    @FXML
    private TextField cashTxt;
    @FXML
    private TextField TserviceTxt;
    @FXML
    private TextField TtypeTxt;
    @FXML
    private Label saveMsgLabel;
    //    @FXML
//    private TextField dateTxt;
//    @FXML
//    private  TextField timeTxt;
    @FXML
    private Button save;
    @FXML
    private Button view;
    @FXML
    private Button close;


//    REGISTRATION

    @FXML
    private TextField userTxt;
//    @FXML
//    private PasswordField passwordField;

    @FXML
    private TextField firstnameTxt;
    @FXML
    private TextField lastnameTxt;
    @FXML
    private TextField contactTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private Button backButton;
    @FXML
    private Button previousButton, submitButton;


    @FXML
    public void loginButtonOnClick(ActionEvent event) throws IOException {
        if (!usernameTxt.getText().isBlank() && !passwordTxt.getText().isBlank()) {
            accessLogin();
        } else {
            loginMsgLabel.setText("Please enter Username and Password");
        }
    }

    public void accessLogin() {
        DBConnection dbConnection = new DBConnection();
        Connection connectDB = dbConnection.getConnection();


        String query = "SELECT * FROM User WHERE Username = ? AND Password = ?";

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);


            String username = usernameTxt.getText();
            String passwor = passwordTxt.getText();
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, passwor);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {


                loginMsgLabel.setText("Welcome!"); // Set success message
                switchToTransaction();


                // switchToScene3();
            } else {
                // Authentication failed
                System.out.println("Invalid login. pls retry");
                loginMsgLabel.setText("Invalid Login. Please retry.");
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ; // Handle SQL exceptions
//            loginMsgLabel.setText("Error");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        } finally {
            // Close the database connection
            try {
                if (connectDB != null && !connectDB.isClosed()) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void switchToAdminReg() throws IOException {
        Stage stage = (Stage) signUpHyperlink.getScene().getWindow();
        stage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminReg-view.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Registration");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @FXML
    private void submitAdminInfo() throws IOException {

        String Username = userTxt.getText();
        String Password = password.getText();
        String Firstname = firstnameTxt.getText();
        String Lastname = lastnameTxt.getText();
        String Contact = contactTxt.getText();
        String Email = emailTxt.getText();


        UserAdmin userAdmin = new UserAdmin();
        // Checking if text field is empty or not
        if (Lastname.isBlank()) {
            System.out.println("Pls enter Lastname");
            return;
        } else {
            userAdmin.setLastname(Lastname);
        }
        if (Firstname.isBlank()) {
            System.out.println("Pls enter Firstname");
            return;
        } else {
            userAdmin.setFirstName(Firstname);
        }
        if (Username.isBlank()) {
            System.out.println("Pls enter Username");
            return;
        } else {
            userAdmin.setUsername(Username);
        }
        if (Password.isBlank()) {
            System.out.println("Pls enter Password");
            return;
        } else {
            userAdmin.setPassword(Password);
        }
        if (Contact.isBlank()) {
            System.out.println("Pls enter Contact");
            return;
        } else {
            userAdmin.setContact(Contact);
        }
        if (Email.isBlank()) {
            System.out.println("Pls enter email");
            return;
        } else {
            userAdmin.setEmail(Email);
        }


        int res = AdminRepository.insert(userAdmin);

        if (res > 0) {
            System.out.println("login successfully");
            switchToCustomer();
//            adminRegMsgLabel.setText("Good Job");
        } else {
            adminRegMsgLable.setText("Lazy Work");
        }

    }

    public void switchToLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) previousButton.getScene().getWindow();
        stage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("login-view");
        primaryStage.setScene(new Scene(root, 710, 395));
        primaryStage.show();

    }

    @FXML
    public void switchToCustomer() throws IOException {
//        Stage stage = new Stage();
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
        Parent root = null;
        root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("login-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void switchToTransaction() throws IOException {
        Stage stage = (Stage) login.getScene().getWindow();
        stage.close();

        Parent root = null;
        root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("customer-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    //
    //         code on save button
    @FXML
    public void saveButtonOnClick() throws IOException {
        String customerName = customerTxt.getText();
        String Contact = contTxt.getText();
        String Amount = cashTxt.getText();
        String transactionService = TserviceTxt.getText();
        String transactionType = TtypeTxt.getText();


        TransactionSheet transactionSheet = new TransactionSheet();
        // Checking if text field is empty or not
        if (customerName.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter customer name");
            alert.showAndWait();


        } else if (Contact.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter contact");
            alert.showAndWait();

        } else if (Amount.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter amount");
            alert.showAndWait();

        } else if (transactionService.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter Transaction Service");
            alert.showAndWait();

        } else if (transactionType.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter Transaction Type");
            alert.showAndWait();

        } else {
            transactionSheet.setCustomerName(customerName);
            transactionSheet.setContact(Contact);
            transactionSheet.setAmount(Amount);
            transactionSheet.setTransactionService(transactionService);
            transactionSheet.setTransactionType(transactionType);


            int res = TransactionSheetRepo.insert(transactionSheet);
//
            if (res > 0) {
                saveMsgLabel.setText("save successfully");

            }else {
                saveMsgLabel.setText("Save successfully");
            }
        }
    }

    public void closeButtonOnClick(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

}


