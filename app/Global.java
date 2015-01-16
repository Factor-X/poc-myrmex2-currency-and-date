
import eu.factorx.poc.currency.deployement.dto.ExceptionsDTO;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.Results;
import play.mvc.SimpleResult;
import eu.factorx.poc.currency.data.service.boInterface.PeriodService;
import eu.factorx.poc.currency.data.service.impl.PeriodServiceImpl;
import eu.factorx.poc.currency.generator.GeneratePeriod;

// Spring imports

public class Global extends GlobalSettings {

	//service
	private PeriodService periodService = new PeriodServiceImpl();

	@Override
	public void onStart(Application application) {

		if(!periodService.wasGenerated()) {

			//generate period
			GeneratePeriod generatePeriod = new GeneratePeriod();

			generatePeriod.generatePeriod(2000, 2014);
		}
	}


	@Override
	public Promise<SimpleResult> onError(RequestHeader request, Throwable t) {
		ExceptionsDTO exceptionsDTO = new ExceptionsDTO(t.getCause().getMessage());

		Logger.error("ERROR into global : " + exceptionsDTO.getMessage());

		return Promise.<SimpleResult>pure(Results.internalServerError(exceptionsDTO
		));
	}

}

