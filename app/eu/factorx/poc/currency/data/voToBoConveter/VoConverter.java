package eu.factorx.poc.currency.data.voToBoConveter;

import eu.factorx.poc.currency.common.bo.BO;
import eu.factorx.poc.currency.data.vo.VO;

/**
 * Created by florian on 14/01/15.
 */
public interface VoConverter<V extends VO,B extends BO> {

    public abstract B convert(V vo);

}
