package eu.factorx.poc.currency.data.boToVoConverter;

import eu.factorx.poc.currency.common.bo.BO;
import eu.factorx.poc.currency.data.vo.VO;

/**
 * Created by florian on 14/01/15.
 */
public interface BoConverter<B extends BO,V extends VO> {

    public abstract V convert(B vo);

}
