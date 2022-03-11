package ProjetoBloco1;

import java.util.Scanner;

public class CaixaEletronico {
Scanner ler = new Scanner(System.in);
	
	public String adicionarSaldo(double entradaDeDinheiro,double saldo) {
		saldo =  saldo+entradaDeDinheiro;
		
		return saldo + "";
	}
	
	public String sacar(double saidaDeDinheiro, double saldo, boolean contaAutenticada) {
		
		double novoSaldo;
		String mensagem = saldo + "";
		
		if(contaAutenticada) 
		{
			if(saidaDeDinheiro>0)
			{	
				if(saidaDeDinheiro <= saldo) 
				{
					System.out.println("Voc� sacou: R$"+saidaDeDinheiro+ " reais.");
					
					novoSaldo = saldo - saidaDeDinheiro;
					
					mensagem = novoSaldo + "";
					
				}
				else if(saidaDeDinheiro > saldo) 
				{
					int resposta;
					
					System.out.println("Saldo insuficiente, Deseja fazer o cheque especial?");
					resposta = ler.nextInt();
					if(resposta == 1) chequeEspecial();
					else System.out.println("N�o foi poss�vel sacar, saldo insuficiente");
					
				}
				
			}else 
			{
				System.out.println("Voc� n�o pode sacar um valor negativo ou igual a zero, "+
						"tente novamente.");
			}
		}
		else {
			System.out.println("Conta n�o altenticada.");
		}
		
		return mensagem;
	}//4
	
	public void chequeEspecial()
	{
		System.out.println("Voc� entrou no cheque especial, empr�stimo sem juros por 10 dias.");
	}
	
	public void informarCredito(double saldo, boolean contaAutenticada)
	{
		if(contaAutenticada)
		{
			if(saldo>5000) {
				System.out.println("Voc� possui cr�tido dispon�vel, "
						+"contate seu gerente para mais informa��es!");
			}
			else 
			{
				System.out.println("Voc� n�o possui cr�tido dispon�vel");
			}
		}
		else {
			System.out.println("Conta n�o altenticada, imposs�vel mostrar se h� cr�ditos dispon�veis.");
		}
	}
}
