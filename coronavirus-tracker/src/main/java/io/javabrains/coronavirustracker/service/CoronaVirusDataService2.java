package io.javabrains.coronavirustracker.service;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.javabrains.coronavirustracker.model.LocationStats;


@Service
public class CoronaVirusDataService2 {
	
	
	private List<LocationStats> allStats = new ArrayList<>();
	
	@Autowired
	private CoronaDataFetcher data;
	
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchVirusData() throws IOException, InterruptedException{
		
		List<LocationStats> newStats = new ArrayList<>();
		StringReader in = new StringReader(data.fetchCoronaVirusData());
		
		
		@SuppressWarnings("deprecation")
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		
		
		for (CSVRecord record : records) {
			
			LocationStats locationStat = new LocationStats();
			
		    int latestCases = Integer.parseInt(record.get(record.size()-1));
			int prevDayCases = Integer.parseInt(record.get(record.size()-2));
			
		    locationStat.setState(record.get("Province/State"));
		    locationStat.setCountry(record.get("Country/Region"));
		    locationStat.setLatestTotalCases(latestCases);
		    locationStat.setDiffFromPrevDay(latestCases-prevDayCases);
		   
		   
		    newStats.add(locationStat);

		}
		
		
		
		this.allStats = newStats; //.stream().sorted().toList();
		
	}

	
	
	
	public List<LocationStats> getAllStats() {
		return allStats;
	}
	
	public List<LocationStats> getFilteredStats(String input) {
		
		
		return allStats.stream()
				.filter(stat -> stat.getCountry().toLowerCase().equals(input.toLowerCase()) 
				|| (stat.getState().toLowerCase().equals(input.toLowerCase()) && !input.isBlank() ))
				.collect(Collectors.toList());
	}

	
	
		

	

}
