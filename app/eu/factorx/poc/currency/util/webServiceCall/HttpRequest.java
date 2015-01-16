package eu.factorx.poc.currency.util.webServiceCall;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.factorx.poc.currency.deployement.dto.DTO;
import play.Logger;
import eu.factorx.poc.currency.util.exception.MyException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by florian on 30/08/14.
 */
public class HttpRequest {


	public enum RequestMethod {
		GET, POST;
	}

	public <T extends DTO> T sendRequest(HttpRequest.RequestMethod requestMethod,String url, Map<String, String> params, Class<T> returnExcepted) throws MyException {

		JsonNode actualObj = sendRequest(requestMethod,url,params);

		return DTO.getDTO(actualObj, returnExcepted);
	}

	private JsonNode sendRequest(HttpRequest.RequestMethod requestMethod,String urlString, Map<String, String> params) throws MyException {

        if(params == null){
			params = new HashMap<>();
		}

		String paramString = buildOption(params);

		try {

			if (requestMethod.equals(RequestMethod.GET)) {
				urlString = urlString+ "?" + paramString;
			}

			URL url = new URL(urlString);

			Logger.info("url : "+url);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(requestMethod.toString());
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			if (requestMethod.equals(RequestMethod.POST)) {
				connection.setRequestProperty("Content-Length", "" +
						Integer.toString(paramString.getBytes().length));
			}
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			//Send request
			if (requestMethod.equals(RequestMethod.POST)) {
				DataOutputStream wr = new DataOutputStream(
						connection.getOutputStream());
				wr.writeBytes(paramString);
				wr.flush();
				wr.close();
			}

			//Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();

			//Logger.info(response.toString());

			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = mapper.getFactory(); // since 2.1 use mapper.getFactory() instead
			JsonParser jp = factory.createParser(response.toString());
			return mapper.readTree(jp);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new MyException(e, "URL malformed");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new MyException(e, "URL malformed");
		} catch (ProtocolException e) {
			e.printStackTrace();
			throw new MyException(e, "URL malformed");
		} catch (IOException e) {
			e.printStackTrace();
			throw new MyException(e, "URL malformed");
		}


	}

	private String buildOption(Map<String, String> params) {


		Logger.warn("params:"+params);

		if(params==null){
			return "";
		}

		boolean first = true;
		String content = "";
		for (Map.Entry<String, String> entry : params.entrySet()) {

			if(entry.getKey().equals(QuandlApiRequest.AUTH_PARAM)){
				content += entry.getKey() + "=" + entry.getValue();
				first = false;
				params.remove(entry.getKey());
				break;
			}
		}

		Logger.warn("content:"+content);

		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first) {
				first = false;
			} else {
				content += "&";
			}
			content += entry.getKey() + "=" + entry.getValue();
		}
		return content;
	}
}






