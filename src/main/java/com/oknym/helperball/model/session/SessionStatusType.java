package com.oknym.helperball.model.session;

public enum SessionStatusType {

	NotValidated,
	BeforeValidatingByToken,
	Enabled,
	Disbaled,
	Timedout,
	TimeExtended,
	LoggedOut;
	
}
