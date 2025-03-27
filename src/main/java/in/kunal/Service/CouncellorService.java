package in.kunal.Service;

import in.kunal.Binding.DashboardResponse;
import in.kunal.Entity.Councellor;

public interface CouncellorService {
	
	public boolean register(Councellor councellor);
	
	public Councellor login (String email, String password);
	
	public DashboardResponse dashboard(Integer councellorId);

}
