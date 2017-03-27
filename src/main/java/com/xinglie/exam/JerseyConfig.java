
package com.xinglie.exam;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.xinglie.exam.endpoint.UserApi;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(UserApi.class);
		
	}

}
