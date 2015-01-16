package eu.factorx.poc.currency.deployement.dto;

public class ExceptionsDTO extends DTO {

	private final String message;

	// add default constructor for Json Parser
	public ExceptionsDTO() { this.message = null; }

	public ExceptionsDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
