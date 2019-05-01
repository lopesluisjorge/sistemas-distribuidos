package br.edu.ifma.dcomp.sd.financeiro.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import br.edu.ifma.dcomp.sd.financeiro.rmi.service.ServicoFinanceiroImpl;

public class MainServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            Naming.bind("//localhost/financeiro", new ServicoFinanceiroImpl());

            System.out.println("Server is ready");
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

}
