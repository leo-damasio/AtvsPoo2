package br.edu.ifsc.fln.atv1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ImcController implements Initializable
{

    @FXML
    private ChoiceBox<String> cbSexo;

    @FXML
    private TextField tfAltura;

    @FXML
    private Spinner<Integer> tfIdade;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfPeso;

    SpinnerValueFactory.IntegerSpinnerValueFactory idadeValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 120, 1);

    public void initialize(URL url, ResourceBundle rb)
    {

        cbSexo.getItems().addAll("Masculino", "Feminino", "Outro");
        cbSexo.setValue("Selecione um Sexo");
        tfIdade.setValueFactory(idadeValue);

    }

    @FXML
    void btCalcularImc(ActionEvent event)
    {

        Alert resultado = new Alert(Alert.AlertType.INFORMATION);
        resultado.setTitle("IMC");
        resultado.setHeaderText("Resultado do IMC");
        resultado.setContentText(getDados());
        resultado.showAndWait();

    }

    @FXML
    void novoOnAction(ActionEvent event)
    {

        tfNome.setText("");
        tfPeso.setText("");
        tfAltura.setText("");
        cbSexo.setValue("Selecione um Sexo");
        tfIdade.getValueFactory().setValue(1);

    }

    private String getDados()
    {
        double altura = Double.parseDouble(tfAltura.getText());
        double peso = Double.parseDouble(tfPeso.getText());
        double imc = calcularImc(altura, peso);
        String classificacao = classificarImc(imc);
        return "Nome: " + tfNome.getText() + "\nSexo: " + cbSexo.getValue() + "\nIdade: " + tfIdade.getValue() + "\nAltura: " + altura + "\nPeso: " + peso + "\nIMC: " + String.format("%.2f", imc) + "\nClassificação: " + classificacao;
    }

    private double calcularImc(double altura, double peso)
    {

        return peso / (altura * altura);

    }

    private String classificarImc(double imc)
    {
        if(imc < 18.5)
        {
            return "Abaixo do peso";
        }
        else if(imc < 25)
        {
            return "Peso normal";
        }else if(imc< 30)
        {
            return"Sobrepeso";
        }else if (imc < 35)
        {
            return "Grau de Obesidade I";
        }
        else
            return "Grau de Obesidade II";
    }
}
