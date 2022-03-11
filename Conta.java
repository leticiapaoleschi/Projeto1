package ProjetoBloco1;

import java.util.ArrayList;

public class Conta {
	private int indice;
	private String cartao;
	private String nome;
	private String senha;
	private String cpf;
	private String saldo;
	private boolean contaAutenticada;
	
	//ArrayList para armazenar os dados
	private ArrayList<String> pessoa = new ArrayList<>();
	
	//2
	
	//Salvar as informações no array
	public void salvando(String cartao, String senha, String nome, String cpf, String saldo) 
	{
		try
		{
			pessoa.add(cartao);
			pessoa.add(senha);
			pessoa.add(nome);
			pessoa.add(cpf);
			pessoa.add(saldo);
			
			System.out.println("Cadastro feito com sucesso!!!");
		}
		catch (Exception erro) {
			System.out.println("Não foi possível efetuar o cadastro, " + erro);
		}	
		
	}// 0[12345] 1[1234] 2[mat] 3[12345678910] 4[50.0]   indice[elemento]
	
	public void login(String cartao, String senha) 
	{
		indice = pessoa.indexOf(cartao);
		
		if(indice != -1) 
		{
			this.cartao = cartao;
			this.nome = pessoa.get(indice + 2);
			this.senha = senha;
			this.cpf = pessoa.get(indice + 3);
			this.saldo = pessoa.get(indice + 4);
			this.contaAutenticada = true;
	
		}
		else 
		{
			System.out.println("Você não tem cadastro!!!");
		}

	}
	
	//Zera todas as variaveis 
	public void deslogar() 
	{
		this.cartao = "";
		this.nome = "";
		this.senha = "";
		this.cpf = "";
		this.saldo = "";
		this.contaAutenticada = false;
	}
	//3
	
	public boolean verifiSenha(String senhaDig) 
	{
		if(senhaDig.equals(this.senha)) return true;
		
		else return false;
	}

	public boolean validarSenha(String senha)
	{
		if(senha.length() != 4) 
		{
			System.out.println("Senha inválida, digite uma senha de 4 dígitos!");
			return false;
		}else 
		{
			return true;
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public boolean validarCpf(String cpf) {
		if(cpf.length() == 11) {
			return true;
		}else {
			System.out.println("CPF inválido, digite um CPF de 11 dígitos!");
			return false;
		}
		
	}
	
	
	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
		
		pessoa.set(indice + 4, this.saldo);
	}

	public ArrayList<String> getPessoa() {
		return pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isContaAutenticada() {
		return contaAutenticada;
	}

	public void setContaAutenticada(boolean contaAutenticada) {
		this.contaAutenticada = contaAutenticada;
	}

	public int getIndice() {
		return indice;
	}

	public String getCartao() {
		return cartao;
	}

	public void setPessoa(ArrayList<String> pessoa) {
		this.pessoa = pessoa;
	}

	
	

}
