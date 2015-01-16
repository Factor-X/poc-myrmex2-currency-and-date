package eu.factorx.poc.currency.util.webServiceCall;

/**
 * Created by florian on 30/08/14.
 */
public enum HttpRequestEnum {

	QUANDL_CURRENCY_PAIR("https://www.quandl.com/api/v1/datasets/BNP/{currency1}{currency2}.json",HttpRequest.RequestMethod.GET);

	private final String url;
	private final HttpRequest.RequestMethod methodType;

	HttpRequestEnum(String url, HttpRequest.RequestMethod methodType) {
		this.url = url;
		this.methodType = methodType;
	}

	public String getUrl() {
		return url;
	}

	public HttpRequest.RequestMethod getMethodType() {
		return methodType;
	}
}
