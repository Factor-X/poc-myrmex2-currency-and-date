package eu.factorx.poc.currency.deployement.boToDtoConverter;

import eu.factorx.poc.currency.business.PeriodBusiness;
import eu.factorx.poc.currency.business.impl.PeriodBusinessImpl;
import eu.factorx.poc.currency.common.bo.PeriodBO;
import eu.factorx.poc.currency.common.bo.PeriodMonthBO;
import eu.factorx.poc.currency.common.bo.PeriodQuarterBO;
import eu.factorx.poc.currency.common.bo.PeriodYearBO;
import eu.factorx.poc.currency.deployement.dto.PeriodDTO;
import eu.factorx.poc.currency.deployement.dto.PeriodMonthDTO;
import eu.factorx.poc.currency.deployement.dto.PeriodQuarterDTO;
import eu.factorx.poc.currency.deployement.dto.PeriodYearDTO;

/**
 * Created by florian on 14/01/15.
 */
public class PeriodBoToPeriodDTOConverter implements DtoConverter<PeriodBO, PeriodDTO> {

    //business
    private PeriodBusiness periodBusiness = new PeriodBusinessImpl();

    @Override
    public PeriodDTO convert(PeriodBO bo) {

        PeriodDTO dto;

        if (bo instanceof PeriodYearBO) {
            dto = new PeriodYearDTO();
            ((PeriodYearDTO) dto).setMonthIds(((PeriodYearBO) bo).getMonthIds());
            ((PeriodYearDTO) dto).setQuarterIds(((PeriodYearBO) bo).getQuarterIds());

        } else if (bo instanceof PeriodQuarterBO) {
            dto = new PeriodQuarterDTO();
            ((PeriodQuarterDTO) dto).setMonthIds(((PeriodQuarterBO) bo).getMonthIds());
            //load year
            PeriodYearBO periodYearBO = (PeriodYearBO) periodBusiness.findById(((PeriodQuarterBO) bo).getYearId());
            ((PeriodQuarterDTO) dto).setPeriodYear((PeriodYearDTO) convert(periodYearBO));

        } else {
            dto = new PeriodMonthDTO();
            ((PeriodMonthDTO) dto).setQuarterId(((PeriodMonthBO) bo).getQuarterId());
            //load year
            PeriodYearBO periodYearBO = (PeriodYearBO) periodBusiness.findById(((PeriodMonthBO) bo).getYearId());
            ((PeriodMonthDTO) dto).setPeriodYear((PeriodYearDTO) convert(periodYearBO));
        }

        dto.setId(bo.getId());
        dto.setCode(bo.getCode());
        dto.setStartDate(bo.getStartDate());
        dto.setEndDate(bo.getEndDate());
        dto.setNbDay(bo.getNbDay());
        dto.setNextPeriodId(bo.getNextPeriodId());
        dto.setPreviousPeriodId(bo.getPreviousPeriodId());

        return dto;
    }
}
