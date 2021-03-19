package io.learn.soapclient.client;

import io.learn.soapclient.wsdl.GetCountryRequest;
import io.learn.soapclient.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryClient.class);
    private static final String COUNTRIES_SERVICE_URL = "http://localhost:8080/ws/countries";

    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        LOGGER.info("Requesting location for " + country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
            .marshalSendAndReceive(COUNTRIES_SERVICE_URL, request,
                new SoapActionCallback(
                    "http://learn.io/soapservice/GetCountryRequest"));

        return response;
    }
}

