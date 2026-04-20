package eu.europa.ec.dsa.transparency.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import eu.europa.ec.dsa.transparency.model.api.ListStatementModel;
import eu.europa.ec.dsa.transparency.model.api.StatementModel;


@Component
public class TransparecyApiClient {
	
	@Autowired
	private RestClient restClient;
	
	public StatementModel statement(StatementModel req) {
		StatementModel statement = restClient.post()
			    .uri("/statements")
			    .body(req)
			    .retrieve()
			    .body(StatementModel.class);
		return statement;
	}
	
	public ListStatementModel statements(ListStatementModel req) {
		ListStatementModel statements = restClient.post()
			    .uri("/statements")
			    .body(req)
			    .retrieve()
			    .body(ListStatementModel.class);
		return statements;
	}
}
