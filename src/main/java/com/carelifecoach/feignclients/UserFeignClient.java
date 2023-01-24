package com.carelifecoach.feignclients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.carelifecoach.response.UserResponse;
@FeignClient(url = "${user.service.url}", value = "user-feign-client",
path = "/api/user")
public interface UserFeignClient {

	@GetMapping("users/{Id}")
		public UserResponse getUserProfile(@PathVariable long id);
		
	}

	