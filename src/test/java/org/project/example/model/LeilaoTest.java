package org.project.example.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.project.example.model.Bid;
import org.project.example.model.Auction;
import org.project.example.model.Bidder;

public class LeilaoTest {
	@Test
	public void deveReceberUmLance() {
		Auction leilao = new Auction("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Bid(new Bidder("Steve Jobs"), 2000.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValue(), 0.00001);
	}

	@Test
	public void deveReceberVariosLances() {
		Auction leilao = new Auction("Macbook Pro 15");
		leilao.propoe(new Bid(new Bidder("Steve Jobs"), 2000.0));
		leilao.propoe(new Bid(new Bidder("Steve Wozniak"), 3000.0));

		assertEquals(2, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValue(), 0.00001);
		assertEquals(3000.0, leilao.getLances().get(1).getValue(), 0.00001);
	}
	

	
	 
}