package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Quote implements Serializable {

	@Id
	private int quoteNumber;

	private double balio;
	private String forecast;

	public Quote() {
	}

	public Quote(int quoteNumber, double balio, String forecast) {
		this.quoteNumber = quoteNumber;
		this.balio = balio;
		this.forecast = forecast;
	}

	public int getQuoteNumber() {
		return quoteNumber;
	}

	public void setQuoteNumber(int quoteNumber) {
		this.quoteNumber = quoteNumber;
	}

	public double getBalio() {
		return balio;
	}

	public void setBalio(double balio) {
		this.balio = balio;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
}
