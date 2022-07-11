package io.javabrains.coronavirustracker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.coronavirustracker.model.LocationStats;
import io.javabrains.coronavirustracker.service.CoronaVirusDataService2;




@RestController
public class WebController {
	
	@Autowired
	CoronaVirusDataService2 data;
	
	@GetMapping("/rawStats")
	public List<LocationStats> getAllStats(){
		
		return  data.getAllStats();
	}
	
	@GetMapping("/rawStats/{Id}")
	public List<LocationStats> getStats(@PathVariable("Id") String id) {

		return data.getFilteredStats(id);
	}
	
	@GetMapping("/stringcheck/{Id}")
	public String urlCheck(@PathVariable("Id") String id) {
		
		return id;
	}
	


}
