package com.oknym.helperball.request;

import java.util.Date;

import com.oknym.helperball.model.Position;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoRequest {
	
	private int weight;
	private int height;
	private String age;
	private String footId;
	private String positionId;
	
}
