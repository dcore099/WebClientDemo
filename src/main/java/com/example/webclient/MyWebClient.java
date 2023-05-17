package com.example.webclient;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.beans.ResultadoCanceladoWs;

import reactor.core.publisher.Mono;

@Service
@EnableRetry
public class MyWebClient {

	public WebClient getWebClient() {		
		return WebClient.builder()
				.baseUrl("https://jbossdev.queretaro.gob.mx:18443")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	/**
	 * TODO revisar la clase de la excepción en caso de timeout
	 */
	@Retryable(include = {SocketTimeoutException.class, ResourceAccessException.class})
	public void doPost(){		
		//	MOCK DATA
		JSONArray folios = new JSONArray();
		JSONObject folio = new JSONObject();
		JSONObject request = new JSONObject();
		
		folio.put("motivo", "02");
		folio.put("total", "144.33");
		folio.put("folios_sustituto", "");
		folio.put("rfc_receptor", "XAXX010101000");
		folio.put("uuid", "80F230E3-B13A-F94B-AA5C-075B9E8874E9");
		
		folios.put(folio);
		request.put("folio", folios);
		//System.out.println("JSON:: " + request.toString());
		
		ResultadoCanceladoWs[] response = getWebClient().post()
				.uri("/PortalTimbrado/api/cancelacion/CancelacionMasiva")
		.body(Mono.just(request.toString()), String.class)
		.retrieve()
		.bodyToMono(ResultadoCanceladoWs[].class)
		.block();
		
		List<ResultadoCanceladoWs> resultado = Arrays.asList(response);	
		
		for(ResultadoCanceladoWs resul : resultado) {
			System.out.println("Response object:: " + resul.toString());
		}
	}
}
