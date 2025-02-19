package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repositorio.ContaRepositorio;

public class ContaController implements ContaRepositorio{

	private ArrayList<Conta>ListaContas = new ArrayList <Conta>();
	int numero = 0; 
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta =  buscarNaCollection(numero);
		
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta numero:" +numero +" Não foi encontrada!");
	}
		// TODO Auto-generated method stub

	

	@Override
	public void listarTodas() {
		for (var conta:ListaContas) {
			conta.visualizar();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar(Conta conta) {
		ListaContas.add(conta);
		System.out.println("\nA Conta numero:"+ conta.getNumero()+ "foi criada com sucesso!");
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
		ListaContas.set(ListaContas.indexOf(buscaConta),conta);
		System.out.println("\nA Conta numero:" + conta.getNumero()+ "foi atualizada com sucesso!");
		}else 
			System.out.println("\nA Conta numero: "+ conta.getNumero()+" não foi encontrada!");
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta!=null) {
			if(ListaContas.remove(conta)==true)
				System.out.println("\nA Conta numero: "+ numero+ " foi deletada com sucesso!");
		  } else
			System.out.println("\nA Conta numero: "+ numero+ " não foi encontrada!");
				
		}
	
	@Override
	public void sacar(int numero, float valor) {
var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			
			if(conta.sacar(valor) == true)
				System.out.println("\nO Saque na Conta numero: " + numero + " foi efetuado com sucesso!");		
		
		}else
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
        
    }
	
	@Override
	public void depositar(int numero, float valor) {
		 var conta = buscarNaCollection(numero);
			
			if (conta != null) {
				conta.depositar(valor);
				System.out.println("\nO Depósito na Conta numero: " + numero + " foi efetuado com sucesso!");
			}else
				System.out.println("\nA Conta numero: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente!");
	    }
		
	
	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		 var contaOrigem = buscarNaCollection(numeroOrigem);
			var contaDestino = buscarNaCollection(numeroDestino);

			if (contaOrigem != null && contaDestino != null) {
								
					if (contaOrigem.sacar(valor) == true) {
						contaDestino.depositar(valor);
						System.out.println("\nA Transferência foi efetuado com sucesso!");
					}
			}else
				System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");
	    }
	
	
		
	
public int gerarNumero() {
	return ++ numero;
}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : ListaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
}
}
