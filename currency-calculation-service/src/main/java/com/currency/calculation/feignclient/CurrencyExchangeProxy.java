package com.currency.calculation.feignclient;

import com.currency.calculation.model.CalculatedAmount;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name ="currency-exchange-service", url ="http://localhost:8000")
//@FeignClient(name ="currency-exchange-service")
@FeignClient(name ="netflix-zuul-api-gateway-server")
@RibbonClient(name ="currency-exchange-service")
public interface CurrencyExchangeProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CalculatedAmount retrieveExchangeValue(@PathVariable("from") String from,
												  @PathVariable("to") String to);

}
