package Main;
import java.io.FileNotFoundException;
import java.io.IOException;

import Cliente.*;
import Contas.*;


public class Main {
    public static boolean realTime = true; //Datas aleatorias/ficticias
    public static void main(String[] args) {

        ClientePessoaFisica ana = new ClientePessoaFisica("Ana", "Av. Antonio Carlos, 6627", "023.065.376.66", 25, 'f');
        ClientePessoaFisica vitor = new ClientePessoaFisica("Vitor", "R. Castelo Ajuda, 695", "014.957.656.23", 17, 'm');

        //ClientePessoaJuridica neuxCIA = new ClientePessoaJuridica("NeuxCIA", "Av. Contorno, 1152", "555669813", 25, "Shipping");
        ClientePessoaJuridica anaC = new ClientePessoaJuridica("AnaC", "Av. Fleming, 895", "555669813", 78, "Publishing");

        Conta conta1 = new ContaUniversitaria("0000-1", 1021, vitor, 565, 00, 500);
        Conta conta2 = new ContaCorrente("1234-5", 1234, ana, 2000, -10, 4000); //
        conta1.setDono(anaC);

        try{
            conta2.salvar();
        }catch (Exception v){
            System.out.println(v);
        }

        String ag = "1234-5";
        int c = 1234;
        try{
            Conta loadedConta = Conta.carregar(ag, c);
            System.out.println(loadedConta);
        }catch(FileNotFoundException e){
            System.out.println("Conta não encontrada no Banco de Dados! (Agência: "+ag+", Conta:"+c+")");
        }catch(ClassNotFoundException e){
            System.out.println("Conflito na versão das classes!");
        }catch(IOException e){
            System.out.println(e);
        }

        /*conta1.imprimirExtratoConta(1); //Depositos seguido de Saques
        conta2.imprimirExtratoConta(0); //Ordem de Data
        System.out.println(conta2);
        //conta2.imprimirExtratoTaxas();

        //System.out.println(conta2);

        System.out.println(ana);
        System.out.println(neuxCIA);

        int media = Operacao.getTotalOperacoes() / Conta.getTotalContas();
        System.out.println("\nMédia de operações por conta aberta: " + media);

        System.out.println("conta1 == conta2 ? " + conta1.equals(conta2));
        System.out.println("ana == vitor ? " + ana.equals(vitor));
        System.out.println("anaC == neuxCIA ? " + neuxCIA.equals(anaC));

        System.out.println("authenticator: " + neuxCIA.autenticar("555669813"));
        */
        //System.err.println(new ValorNegativoException());
    }
    
}

/* public static void delay(long millis){
    if (timeout){
        try{Thread.sleep(millis);}
        catch (InterruptedException e){Thread.currentThread().interrupt();}
    }
} */
