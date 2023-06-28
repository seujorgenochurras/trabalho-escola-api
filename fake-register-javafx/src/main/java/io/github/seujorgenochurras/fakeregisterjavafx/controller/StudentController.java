package io.github.seujorgenochurras.fakeregisterjavafx.controller;

import io.github.seujorgenochurras.fakeregisterjavafx.domain.Student;
import io.github.seujorgenochurras.fakeregisterjavafx.service.StudentService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class StudentController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField cepField;

    @FXML
    private DatePicker birthField;

    @FXML
    public void onRegister(){

        Student student = new Student();
        String name = nameField.getText();
        String cep = cepField.getText();
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

        StudentService.postStudent(student);
    }
}
