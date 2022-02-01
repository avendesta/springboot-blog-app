package cs544.utils;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class Util {
	public static Integer ID_ADMIN = 0;
	public static Integer ID_POSTER = 1;
	public static Integer ID_READER = 2;
	public static Integer ID_ANONYMOUS = 3;

	@Autowired
	DiscoveryClient discoveryClient;

	public URI getInstance(String nameService) {
		List<ServiceInstance> list = discoveryClient.getInstances(nameService);
		ServiceInstance service2 = list.get(0);
		URI micro2URI = service2.getUri();
		return micro2URI;
	}
}
