package org.project.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.project.example.model.Bid;
import org.project.example.model.Auction;

public class Auctioneer {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private List<Bid> maiores;

	public void evaluate(Auction leilao) {
		if (leilao.getBids().isEmpty())
			throw new IllegalArgumentException("Não é possível avaliar um leilão sem lances");

		for (Bid lance : leilao.getBids()) {
			if (lance.getValue() > maiorDeTodos)
				maiorDeTodos = lance.getValue();
			if (lance.getValue() < menorDeTodos)
				menorDeTodos = lance.getValue();
		}

		pegaOsMaioresNo(leilao);
	}

	private void pegaOsMaioresNo(Auction leilao) {
		maiores = new ArrayList<>(leilao.getBids());
		
		Collections.sort(maiores, (Bid o1, Bid o2) -> ((Double)o2.getValue()).compareTo(o1.getValue()));
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}

	public List<Bid> getTresMaiores() {
		return this.maiores;
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}
}
