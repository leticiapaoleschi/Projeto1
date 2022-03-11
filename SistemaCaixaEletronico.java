package ProjetoBloco1;

import java.util.Scanner;

public class SistemaCaixaEletronico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean sessao = true;
		int opcao = 0;
		String cartao = "", nome = "", senha = "",
				cpf = "", saldo ="",verificarSenha = "";
		double meuSaldo;
		double sacar;
		
		Scanner ler = new Scanner(System.in);
		
		Conta c = new Conta();
		
		CaixaEletronico caixa = new CaixaEletronico();
		
		try {
		
			while(sessao) 
			{
				System.out.println("==============================================================");
				System.out.println(" [1] --> Cadastrar                                            ");	
				System.out.println(" [2] --> Logar                                                "); 
				System.out.println(" [3] --> Sair                                                 ");
				System.out.println("==============================================================");
				
				opcao = ler.nextInt();
				
				switch (opcao) {
				case 1://CADASTRAR
					
					System.out.println("Digite o número do seu cartão");
					cartao = ler.next();
					
					System.out.println("Digite uma senha de 4 digitos: ");
					senha = ler.next();
					
					if(c.validarSenha(senha)) 
					{
						System.out.println("Digite seu cpf");
						cpf = ler.next();
						
						if(c.validarCpf(cpf)) 
						{
							System.out.println("Digite seu nome");
							nome = ler.next();
							
							System.out.println("Depositar valor de entrada");
							saldo = ler.next();
							
							c.salvando(cartao,senha,nome,cpf,saldo);
							
							
						}
					}
					
					
					break;
					
				case 2://LOGAR
					
					System.out.println("Digite o número do seu cartão");
					cartao = ler.next();
					
					System.out.println("Digite o sua senha");
					senha = ler.next();
					
					c.login(cartao, senha);
					
					//5
					while(c.isContaAutenticada()) 
					{	
						System.out.println(c.getNome());
						System.out.println("============================================================");
					    System.out.println(" Digite a opção desejada:                               	");
					    System.out.println(" [1] --> Saldo                                          	");
					    System.out.println(" [2] --> Depositar                                          ");
					    System.out.println(" [3] --> Sacar                                       		");
					    System.out.println(" [4] --> Informar crédito                             		");
					    System.out.println(" [5] --> Cheque especial                               		");
					    System.out.println(" [6] --> Deslogar                            				");
					    System.out.println("============================================================");
					    
					    opcao = ler.nextInt();
					    
					    switch (opcao) {
					    
					    case 1://VER SALDO	
							
							System.out.println("Seu saldo é de: " + c.getSaldo() + "Reais");
							
							break;
							
						case 2://DEPOSITAR
							
							meuSaldo = Double.parseDouble(c.getSaldo());
							double depositar = 0;
							
							System.out.println("Digite o valor que deseja depositar:");
							depositar = ler.nextDouble();
							
							String novoSaldo = caixa.adicionarSaldo(depositar,meuSaldo);	
							
							c.setSaldo(novoSaldo);
							
							System.out.println("Saldo depositado com sucesso!!\nSaldo atual: " + novoSaldo + "Reais");
							
							break;
							
						case 3://SACAR
							
							System.out.print("Digite sua senha: ");
							verificarSenha = ler.next();
							
							if(c.verifiSenha(verificarSenha)) 
							{
								System.out.println("Digite o valor que deseja sacar:");
								sacar = ler.nextDouble();
								
								meuSaldo = Double.parseDouble(c.getSaldo());
								
								String result = caixa.sacar(sacar, meuSaldo, c.isContaAutenticada());
								
								if(result.equals(c.getSaldo()) == false) 
								{
									c.setSaldo(result);
									
									System.out.println("Novo saldo: " + c.getSaldo());
									
									
								}
							}
							else 
							{
								System.out.println("Senha incorreta!!!");
							}
						
							break;
							
						case 4://INFORMAR CRÉDITO
							
							meuSaldo = Double.parseDouble(c.getSaldo());
							
							caixa.informarCredito(meuSaldo, c.isContaAutenticada());
						
							break;
							
						case 5://CHEQUE ESPECIAL
									
							caixa.chequeEspecial();
								
									break;
									
						case 6://DESLOGAR
							
							c.deslogar();
								
									break;
		
						default:
							System.out.println("Digite um número valido");
							break;
						}
					}
					
					break;
					
				case 3:
					System.out.println("Obrigada por fazer parte do GenBank!!");
					sessao = false;
					
					break;
		
				default:
					
					System.out.println("Digite um número valido");
					break;
				}
			}
		}
		catch (Exception erro) {
			System.out.println("Tente novamente! Erro:" + erro);
		}
		
		}
	}


