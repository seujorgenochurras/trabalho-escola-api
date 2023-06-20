module io.github.seujorgenochurras.fakeregister {
   requires javafx.controls;
   requires javafx.fxml;


   opens io.github.seujorgenochurras.fakeregister to javafx.fxml;
   exports io.github.seujorgenochurras.fakeregister;
}