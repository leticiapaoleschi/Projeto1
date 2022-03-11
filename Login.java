package ProjetoBloco1;

public class Login {
	public void Login(int cartao, int senha) //Sobrecarga
	{
		if(cartao == 1324 && senha == 123) 
		{
			System.out.println("Entrou");
		}
	}
	
	public boolean verifiSenha(String senhaDig) //Sobrescrita
	{
		if(senhaDig.equals("senha")) return true;
		
		else return false;
	}
}
