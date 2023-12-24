package com.example.demo.projection;

import java.time.Instant;
import com.example.demo.models.*;


public interface UserProjection {
	public Integer getId();
	public String getName();
	public String getEmail();
	public Instant getCreateDate();
	public Instant getUpdateDate();
	
	public Address getAddress();
	

}
