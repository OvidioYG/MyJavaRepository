package io.javabrains.coronavirustracker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import io.javabrains.coronavirustracker.model.LocationStats;
import io.javabrains.coronavirustracker.service.CoronaVirusDataService2;

@Controller
public class HomeController {
	
	@Autowired
	CoronaVirusDataService2 coronaVirusDataService;
	
	@GetMapping("/list")
	public String home(Model model) {
		List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		
		Integer totalReportedCasesSum = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		Integer totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		
		
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCasesSum);
		model.addAttribute("totalNewCases", totalNewCases);
		
		return "fullList";
	}
	
	@GetMapping("/home")
	public String homePage(Model model) {
		
       LocationStats locStats = new LocationStats();
		
		
		model.addAttribute("locations",locStats);
		
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		
		Integer totalReportedCasesSum = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		Integer totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		
		model.addAttribute("totalReportedCases", totalReportedCasesSum);
		model.addAttribute("totalNewCases", totalNewCases);
		
		
		return "home";
	}
	
	@PostMapping(value ="/filtering")
	public String filteredSearch(@ModelAttribute ("location") LocationStats stats, Model model) {
		
		List<LocationStats> filteredStats = null;
		
		if(!stats.getState().isBlank()) {
			filteredStats = coronaVirusDataService.getFilteredStats(stats.getState());
		}
		else {
			filteredStats = coronaVirusDataService.getFilteredStats(stats.getCountry());
		}
			

		Integer totalReportedCasesSum = filteredStats.stream().mapToInt(s -> s.getLatestTotalCases()).sum();
		Integer totalNewCases = filteredStats.stream().mapToInt(s -> s.getDiffFromPrevDay()).sum();
		
		model.addAttribute("locationStats", filteredStats);
		model.addAttribute("totalReportedCases", totalReportedCasesSum);
		model.addAttribute("totalNewCases", totalNewCases);
	
		
		return "fullList";
	}
	
	
	
	
}