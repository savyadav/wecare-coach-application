package com.carelifecoach.feignclients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.carelifecoach.response.CoachResponse;
import com.carelifecoach.response.UserResponse;
@FeignClient(url = "${coach.service.url}", value = "coach-feign-client",
path = "/api/coach")
public interface CoachFeignCleint {
	
	

		@GetMapping("coach/{Id}")
		public CoachResponse getCoachProfile(@PathVariable long id);
		
	}


