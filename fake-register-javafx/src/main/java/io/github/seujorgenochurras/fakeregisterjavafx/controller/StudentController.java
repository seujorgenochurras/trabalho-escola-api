package io.github.seujorgenochurras.fakeregisterjavafx.controller;

import com.google.gson.Gson;
import io.github.seujorgenochurras.fakeregisterjavafx.domain.Student;
import io.github.seujorgenochurras.fakeregisterjavafx.service.StudentService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class StudentController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField cepField;

    @FXML
    private Text responseText;

    @FXML
    private DatePicker birthField;

    @FXML
    public void onRegister(){

        Student student = new Student();
        String name = nameField.getText();
        String cep = cepField.getText().replace("-", "");
        LocalDate birthDate = birthField.getValue();
        if(name.isBlank() || cep.isBlank() || birthDate == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You've typed something dumb");
            alert.setContentText("You need to write something somewhere");
            alert.showAndWait();
        }
        student.setName(name);
        student.setCep(cep);
        student.setBirthDate(birthDate.toString());

        StudentService.PostedStudent postedStudent = StudentService.postStudent(student);
        if(!postedStudent.isSuccessful()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Your request was invalid");
            alert.setContentText("" + postedStudent.getStatusCode());
            alert.showAndWait();
        }
        responseText.setText(postedStudent.getBody());
    }
}
