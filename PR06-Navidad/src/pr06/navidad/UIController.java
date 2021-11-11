package pr06.navidad;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
    int inventarioCalcetines = 200;
    int inventarioSueterH = 50;
    int inventarioSueterM = 150;
    
    int totalCalcetines = 0;
    int totalSueterH = 0;
    int totalSueterM = 0;
    
    double subTotal = 0;
    int descuento = 0;
    double IVA = 0;
    double total = 0;
    int aux = 0;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void calcularVenta(ActionEvent event) {
        obtenerCliente();
        obtenerPedido();
        
        switch (this.tfCodigo.getText()) {
            case "":
                subTotal = (totalCalcetines * 250) + (totalSueterH * 520) + (totalSueterM * 450);
                IVA = subTotal * 0.16;
                total = subTotal + IVA;

                if (restarInventario()) {
                    this.tfSubTotal.setText("$" + String.valueOf(subTotal));
                    this.tfDescuento.setText(String.valueOf(descuento) + "%");
                    this.tfIVA.setText("$" + String.valueOf(IVA));
                    this.tfTotal.setText("$" + String.valueOf(total));
                    this.tfFechaE.setText(getDiaSemana());
                }              
                break;
                
            case "Dasher":
                aux = (totalCalcetines * 250) + (totalSueterH * 520) + (totalSueterM * 450);
                subTotal = aux - (aux*0.05);
                descuento = 5;
                IVA = subTotal * 0.16;
                total = subTotal + IVA;

                if (restarInventario()) {
                    this.tfSubTotal.setText("$" + String.valueOf(subTotal));
                    this.tfDescuento.setText(String.valueOf(descuento) + "%");
                    this.tfIVA.setText("$" + String.valueOf(IVA));
                    this.tfTotal.setText("$" + String.valueOf(total));
                    this.tfFechaE.setText(getDiaSemana());
                }              
                
                break;
                
            case "Dancer":
                aux = (totalCalcetines * 250) + (totalSueterH * 520) + (totalSueterM * 450);
                subTotal = aux - (aux*0.10);
                descuento = 10;
                IVA = subTotal * 0.16;
                total = subTotal + IVA;

                if (restarInventario()) {
                    this.tfSubTotal.setText("$" + String.valueOf(subTotal));
                    this.tfDescuento.setText(String.valueOf(descuento) + "%");
                    this.tfIVA.setText("$" + String.valueOf(IVA));
                    this.tfTotal.setText("$" + String.valueOf(total));
                    this.tfFechaE.setText(getDiaSemana());
                }
                break;
                
            case "Prancer":
                aux = (totalCalcetines * 250) + (totalSueterH * 520) + (totalSueterM * 450);
                subTotal = aux - (aux*0.15);
                descuento = 15;
                IVA = subTotal * 0.16;
                total = subTotal + IVA;
                
                if (restarInventario()) {
                    this.tfSubTotal.setText("$" + String.valueOf(subTotal));
                    this.tfDescuento.setText(String.valueOf(descuento) + "%");
                    this.tfIVA.setText("$" + String.valueOf(IVA));
                    this.tfTotal.setText("$" + String.valueOf(total));
                    this.tfFechaE.setText(getDiaSemana());
                }                
                break;
                
            case "Rudolph":
                aux = (totalCalcetines * 250) + (totalSueterH * 520) + (totalSueterM * 450);
                subTotal = aux - (aux*0.20);
                descuento = 20;
                IVA = subTotal * 0.16;
                total = subTotal + IVA;

                if (restarInventario()) {
                    this.tfSubTotal.setText("$" + String.valueOf(subTotal));
                    this.tfDescuento.setText(String.valueOf(descuento) + "%");
                    this.tfIVA.setText("$" + String.valueOf(IVA));
                    this.tfTotal.setText("$" + String.valueOf(total));
                    this.tfFechaE.setText(getDiaSemana());
                }
                break;
        }
    }
    
    
    private boolean restarInventario(){
        boolean esValido = false;
        
        if(inventarioCalcetines == 0 && inventarioSueterH == 0 && inventarioSueterM == 0 ){
            alertaInventario("Inventario insuficiente \n Unidades restantes \nCalcetines: " + inventarioCalcetines + "\nSueter Hombre: " + inventarioSueterH + "\nSueter Mujer: " + inventarioSueterM);
        }else if(inventarioCalcetines == 0 && inventarioSueterH == 0){
            alertaInventario("Inventario insuficiente \n Unidades restantes \n Calcetines: " + inventarioCalcetines + "\nSueter Hombre: " + inventarioSueterH );
        }else if(inventarioCalcetines == 0 && inventarioSueterM == 0){
            alertaInventario("Inventario insuficiente \n Unidades restantes \n Calcetines: " + inventarioCalcetines +inventarioSueterH + "\nSueter Mujer: " + inventarioSueterM);
        }else if(inventarioSueterH == 0 && inventarioSueterM == 0){
            alertaInventario("Inventario insuficiente \n Unidades restantes \nSueter Hombre: " + inventarioSueterH + "\nSueter Mujer: " + inventarioSueterM);
        }else if(inventarioCalcetines == 0){
            alertaInventario("Inventario insuficiente \n Unidades restantes \nCalcetines: " + inventarioCalcetines);
        }else if(inventarioSueterH == 0){
            alertaInventario("Inventario insuficiente \n Unidades restantes \nSueter Hombre: " + inventarioSueterH);
        }else if(inventarioSueterM == 0){
            alertaInventario("Inventario insuficiente \n Unidades restantes \nSueter Mujer: " + inventarioSueterM);
        }
        
        if((inventarioCalcetines - totalCalcetines) < 0 && (inventarioSueterH - totalSueterH) < 0 && (inventarioSueterM - totalSueterM) < 0 ){
            alertaInventario("Imposible cubrir pedido \n Unidades restantes \nCalcetines: " + inventarioCalcetines + "\nSueter Hombre: " + inventarioSueterH + "\nSueter Mujer: " + inventarioSueterM + "\nSe ha apartado el inventanrio restante");
            this.tfCalcetines.setText(String.valueOf(inventarioCalcetines));
            this.tfSueterH.setText(String.valueOf(inventarioSueterH));
            this.tfSueterM.setText(String.valueOf(inventarioSueterM));
            this.btnPedido.fire();
        }else if((inventarioCalcetines - totalCalcetines) < 0 && (inventarioSueterH - totalSueterH) < 0){
            alertaInventario("Imposible cubrir pedido \n Unidades restantes \n Calcetines: " + inventarioCalcetines + "\nSueter Hombre: " + inventarioSueterH + "\nSe ha apartado el inventanrio restante" );
            this.tfCalcetines.setText(String.valueOf(inventarioCalcetines));
            this.tfSueterH.setText(String.valueOf(inventarioSueterH));
            this.btnPedido.fire();
        }else if((inventarioCalcetines - totalCalcetines) < 0 && (inventarioSueterM - totalSueterM) < 0){
            alertaInventario("Imposible cubrir pedido \n Unidades restantes \n Calcetines: " + inventarioCalcetines +inventarioSueterH + "\nSueter Mujer: " + inventarioSueterM + "\nSe ha apartado el inventanrio restante");
            this.tfCalcetines.setText(String.valueOf(inventarioCalcetines));
            this.tfSueterM.setText(String.valueOf(inventarioSueterM));
            this.btnPedido.fire();
        }else if((inventarioSueterH - totalSueterH) < 0 && (inventarioSueterM - totalSueterM) < 0){
            alertaInventario("Imposible cubrir pedido \n Unidades restantes \nSueter Hombre: " + inventarioSueterH + "\nSueter Mujer: " + inventarioSueterM + "\nSe ha apartado el inventanrio restante");
            this.tfSueterH.setText(String.valueOf(inventarioSueterH));
            this.tfSueterM.setText(String.valueOf(inventarioSueterM));
            this.btnPedido.fire();
        }else if((inventarioCalcetines - totalCalcetines) < 0){
            alertaInventario("Imposible cubrir pedido \n Unidades restantes \nCalcetines: " + inventarioCalcetines + "\nSe ha apartado el inventanrio restante");
            this.tfCalcetines.setText(String.valueOf(inventarioCalcetines));
            this.btnPedido.fire();
        }else if((inventarioSueterH - totalSueterH) < 0){
            alertaInventario("Imposible cubrir pedido \n Unidades restantes \nSueter Hombre: " + inventarioSueterH + "\nSe ha apartado el inventanrio restante");
            this.tfSueterH.setText(String.valueOf(inventarioSueterH));
            this.btnPedido.fire();
        }else if((inventarioSueterM - totalSueterM) < 0){
            alertaInventario("Imposible cubrir pedido \n Unidades restantes \nSueter Mujer: " + inventarioSueterM + "\nSe ha apartado el inventanrio restante");
            this.tfSueterM.setText(String.valueOf(inventarioSueterM));
            this.btnPedido.fire();
        } else {
            esValido = true;
            inventarioCalcetines = inventarioCalcetines - totalCalcetines;
            inventarioSueterH = inventarioSueterH - totalSueterH;
            inventarioSueterM = inventarioSueterM - totalSueterM;
        }
        return esValido;
    }
    
    @FXML
    private void limpiarCampos(ActionEvent event) {
        this.tfNombre.setText("");
        this.tfDireccion.setText("");
        this.tfCalcetines.setText("0");
        this.tfSueterH.setText("0");
        this.tfSueterM.setText("0");
        this.tfCodigo.setText("");
        this.tfSubTotal.setText("");
        this.tfDescuento.setText("");
        this.tfIVA.setText("");
        this.tfTotal.setText("");
        this.tfFechaE.setText("");
    }
    
    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
    }
    
    private void alertaInventario(String mensaje){
        Alert alertEmptyInfo = new Alert(Alert.AlertType.WARNING);
            alertEmptyInfo.setTitle("Advertencia");
            alertEmptyInfo.setHeaderText("");
            alertEmptyInfo.setContentText(mensaje);
            alertEmptyInfo.showAndWait();
    }
    
    private void obtenerPedido() {
        try {
            totalCalcetines = Integer.parseInt(this.tfCalcetines.getText());
            totalSueterH = Integer.parseInt(this.tfSueterH.getText());
            totalSueterM = Integer.parseInt(this.tfSueterM.getText());
        } catch (NumberFormatException ex) {
            alertaInventario("Introduzca unicamente números");
        }
    }
    
    private void obtenerCliente(){
        if(this.tfNombre.getText().equals("") && this.tfDireccion.getText().equals("")){
            alertaInventario("Por favor introduzca nombre y dirección");
        }else if(this.tfDireccion.getText().equals("")){
            alertaInventario("Por favor introduzca dirección de entrega");
        }else if(this.tfNombre.getText().equals("")){
            alertaInventario("Por favor introduzca nombre del cliente");
        }
    }
    
    public String getDiaSemana(){
        String fecha =dateActual();
        String Valor_dia = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaActual = null;
        try {
            fechaActual = df.parse(fecha);
        } catch (ParseException e) {
        System.err.println("No se ha podido parsear la fecha.");
        e.printStackTrace();
        }
        GregorianCalendar fechaCalendario = new GregorianCalendar();
        fechaCalendario.setTime(fechaActual);
        int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
        int diaMas = 0;
        if (diaSemana == 1) {
            Valor_dia = "Domingo";
            diaMas = 2;
        } else if (diaSemana == 2) {
            Valor_dia = "Lunes";
            diaMas = 5;
        } else if (diaSemana == 3) {
            Valor_dia = "Martes";
            diaMas = 4;
        } else if (diaSemana == 4) {
            Valor_dia = "Miercoles";
            diaMas = 3;
        } else if (diaSemana == 5) {
            Valor_dia = "Jueves";
            diaMas = 2;
        } else if (diaSemana == 6) {
            Valor_dia = "Viernes";
            diaMas = 4;
        } else if (diaSemana == 7) {
            Valor_dia = "Sabado";
            diaMas = 3;
        }
        if(Valor_dia=="Lunes"||Valor_dia=="Martes"||Valor_dia=="Miercoles"||Valor_dia=="Jueves"){
            Valor_dia="Sabado";
        }else{
            Valor_dia="Martes";
        }
        int diaActual =fechaCalendario.get(Calendar.DAY_OF_MONTH);
        int mes = fechaCalendario.get(Calendar.MONTH);
        diaActual=diaActual+diaMas;
        int anio = fechaCalendario.get(Calendar.YEAR);
        String fechaEntrega = Valor_dia+" "+diaActual+" mes "+mes+" de "+anio;
        return fechaEntrega;
    }
    public static String dateActual(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }    
}
