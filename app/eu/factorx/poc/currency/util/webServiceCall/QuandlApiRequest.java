package eu.factorx.poc.currency.util.webServiceCall;

import eu.factorx.poc.currency.deployement.dto.DTO;
import eu.factorx.poc.currency.util.exception.MyException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by florian on 29/09/14.
 */
public class QuandlApiRequest {

    //list of params usable for quandl request
    public static enum QuandlParamsEnum{

        //date with format yyyy-MM-dd
        TRIM_START("trim_start"),
        TRIM_END("trim_end"),
        //ANNUAL, DAY, ...
        COLLAPSE("collapse");


        private final String url_name;

        private QuandlParamsEnum(String url_name){
            this.url_name=url_name;
        }

        public String getUrl_name() {
            return url_name;
        }
    }

    private final static String AUTH = "LGNofuhnMh3ydfbvdhK9";

    public final static String AUTH_PARAM = "auth_token";

    HttpRequest httpRequest = new HttpRequest();

    public <T extends DTO> T sendRequest(HttpRequest.RequestMethod requestMethod,String url, Map<String, String> params, Class<T> returnExcepted) throws  MyException {


        //add the authentication key for quandl
        if(params == null) {
            params = new HashMap<>();
        }

        params.put(AUTH_PARAM,AUTH);

        return httpRequest.sendRequest(requestMethod,url, params, returnExcepted);
    }
}
