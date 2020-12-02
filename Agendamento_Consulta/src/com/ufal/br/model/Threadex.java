package com.ufal.br.model;

public class Threadex implements Runnable{
	Consulta consulta;
	
	public Threadex(Consulta consulta) {
		this.consulta = consulta;
	}
	
	@Override
	public void run() {
		System.out.println("O Paciente "+ consulta.getNomePaciente()+ " está no consultório.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
