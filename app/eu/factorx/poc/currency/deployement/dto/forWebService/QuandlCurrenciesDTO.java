package eu.factorx.poc.currency.deployement.dto.forWebService;

import java.util.List;

/**
 * Created by florian on 4/09/14.
 */
public class QuandlCurrenciesDTO extends QuandLDTO {

	private List<List<String>> data;

	public QuandlCurrenciesDTO() {
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "QuandlCurrenciesDTO{" +
				super.toString()+
				"data=" + data +
				'}';
	}
}
