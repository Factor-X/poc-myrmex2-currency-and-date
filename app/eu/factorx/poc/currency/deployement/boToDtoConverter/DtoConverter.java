package eu.factorx.poc.currency.deployement.boToDtoConverter;

import eu.factorx.poc.currency.common.bo.BO;
import eu.factorx.poc.currency.deployement.dto.DTO;

/**
 * Created by florian on 14/01/15.
 */
public interface DtoConverter<B extends BO,D extends DTO> {

    public abstract D convert(B vo);

}
