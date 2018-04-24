package JavaFx1;

import javafx.application.Application;
import javafx.application.Platform;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginForm1 extends Application{
    
    TextField txtUserId = new TextField();
    PasswordField txtPass = new PasswordField();
    Label lblMessage = new Label();
    public UserInterface theGUI;
    
    public final static double WINDOW_WIDTH = 800;
    public final static double WINDOW_HEIGHT = 600;
    //DatePicker datePicker = new DatePicker();
    
    public void UInterface(Pane theRoot)
    {              
        Label lblHead = new Label("Login Form");
        
        Label lblUserId = new Label("User Id");
        Label lblPass = new Label("Password");
                
        Button btnSubmit = new Button("Submit");
        Button btnExit = new Button("Exit");
        
                
        lblHead.setLayoutX(250); lblHead.setLayoutY(50);
        lblHead.setFont(Font.font("Arial",24));
        
        
        lblUserId.setLayoutX(90); lblUserId.setLayoutY(160);
        lblPass.setLayoutX(90); lblPass.setLayoutY(200);
        
        txtUserId.setLayoutX(240); txtUserId.setLayoutY(160);
        txtPass.setLayoutX(240); txtPass.setLayoutY(200);
        
        btnSubmit.setLayoutX(190); btnSubmit.setLayoutY(260);
        btnSubmit.setOnAction((event) -> { submitAction(); });
        
        
        btnExit.setLayoutX(390); btnExit.setLayoutY(260);
        btnExit.setOnAction(e -> Platform.exit());
        
        lblMessage.setLayoutX(200); lblMessage.setLayoutY(300);
        lblMessage.setFont(Font.font("Arial",24));
        
     // Set the path for the image.   
     Image image1 = new Image("https://i.ytimg.com/vi/LsDa1bLYaEk/mqdefault.jpg");
     // Setting the Image View.
     ImageView imageView = new ImageView(image1);
     // Setting the position of the image.
     imageView.setX(0); imageView.setY(0);
     // Setting the Fit height and width of the image.
     imageView.setFitHeight(150);
     imageView.setFitWidth(190);
        
        //datePicker.setLayoutX(200); datePicker.setLayoutY(250);
        
        //datePicker.setOnAction((event) -> { datePickerAction(); });
        ComboBox <String> comboBox = new ComboBox<String>();
        comboBox.setPromptText("Course");
        comboBox.getItems().addAll("AD", "Calculus", "Physics");
        comboBox.setLayoutX(270); comboBox.setLayoutY(300);
        theRoot.getChildren().addAll(lblHead, imageView, lblUserId,lblPass,txtUserId,txtPass,
                btnSubmit,btnExit,lblMessage,comboBox);
        //,datePicker);
        //,);
            }

    @Override 
       public void start(Stage stage) {
        
        stage.setTitle("Login Form");            // Label the stage (a window)
        
        Pane theRoot = new Pane();
        
        UInterface(theRoot);
        Scene scene = new Scene(theRoot,600,400); //Creating a scene object
         
        stage.setScene(scene);    //Adding scene to the stage 
          
         stage.show();            //Displaying the contents of the stage
    }
    
    public static void main(String args[]){ 
          launch(args); 
       } 

    public void submitAction() {
        
        String checkUser = txtUserId.getText().toString();
        String checkPw = txtPass.getText().toString();
        
        if(checkUser.equals("Preetinder") && checkPw.equals("4040") || 
                checkUser.equals("Admin") && checkPw.equals("2018")    ){
              lblMessage.setText("!..Success..!");
              
              lblMessage.setTextFill(Color.GREEN);
              Stage theStage = new Stage();
              theStage.setTitle("Effort Log Merge and Analysis Tool");                // Label the stage (a window)
                
              Pane theRoot = new Pane();                            // Create a pane within the window
                
              theGUI = new UserInterface(theRoot);                    // Create the Graphical User Interface
                
              Scene theScene = new Scene(theRoot, WINDOW_WIDTH, WINDOW_HEIGHT);    // Create the scene
                
              theStage.setScene(theScene);                            // Set the scene on the stage
            
              theStage.show();                                        // Show the stage to the user          
        }
        else{
            lblMessage.setText("Invalid User Id or Password.");
            lblMessage.setTextFill(Color.RED);
            }    
    }  
}

