package eu.factorx.poc.currency.deployement.dto;

/**
 * Created by florian on 9/01/15.
 */
public class ValueDTO extends DTO {

    private Double value;

    public ValueDTO(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
