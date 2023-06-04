package main;

import views.InterfacePrincipalView;
import java.text.ParseException;


public class Principal {
    public static void main(String[] args) throws ParseException, InterruptedException {
        InterfacePrincipalView view = new InterfacePrincipalView();
        view.executar();
    }
}