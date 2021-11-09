package pr06.navidad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UIController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfDireccion;
    @FXML
    private TextField tfCalcetines;
    @FXML
    private TextField tfSueterH;
    @FXML
    private TextField tfSueterM;
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField tfSubTotal;
    @FXML
    private TextField tfDescuento;
    @FXML
    private TextField tfIVA;
    @FXML
    private TextField tfTotal;
    @FXML
    private Button btnPedido;
    @FXML
    private TextField tfFechaE;
    @FXML
    private Button btnSiguiente;
    @FXML
    private Button btnSalir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
