package io.javabrains.coronavirustracker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CoronaDataFetcher {
	
	@Autowired
	private RestTemplate template;
	
	public CoronaDataFetcher(RestTemplate template) {
		this.template = template;
	}
	
	
	public String fetchCoronaVirusData() {	
		
		return template.getForObject("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv", String.class);
	}
	
	
	

}
