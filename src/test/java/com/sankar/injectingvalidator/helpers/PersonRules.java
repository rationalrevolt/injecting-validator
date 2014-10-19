package com.sankar.injectingvalidator.helpers;

import com.google.inject.Inject;
import com.sankar.injectingvalidator.Optional;
import com.sankar.injectingvalidator.Path;
import com.sankar.injectingvalidator.Result;
import com.sankar.injectingvalidator.Rule;

public class PersonRules {
	
	private SSNService ssnService;
	
	@Inject
	public PersonRules(SSNService ssnService) {
		this.ssnService = ssnService;
	}
	
	@Rule("ssn_required")
	public void validate_ssn_present(@Path("ssn") @Optional String ssn, Result result) {
		if (ssn == null)
			result.fail("SSN is required");
	}
	
	@Rule("ssn_length")
	public void validate_ssn_length(@Path("ssn") String ssn, Result result) {
		if (ssn.length() != 9)
			result.fail("SSN should be exactly {0} characters", 9);
	}
	
	@Rule("ssn_unique")
	public void validate_ssn_unique(@Path("ssn") String ssn, Result result) {
		if (ssnService.isKnown(ssn))
			result.fail("There is already an employee registered with SSN {0}", ssn);
	}
	
	@Rule("name_required")
	public void validate_name_required(@Path("name") @Optional String name, Result result) {
		if (name == null)
			result.fail("Name is required");
	}
	
	@Rule("name_length")
	public void validate_name_length(@Path("name") String name, Result result) {
		if (name.length() > 25)
			result.fail("Name is too long");
	}

}
