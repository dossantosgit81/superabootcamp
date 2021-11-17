package io.github.mendesrafael.domain.model.dto;

import lombok.Data;

@Data
public class EnviarSMSDTO {
	
	private String Receivers;
	
	private String Content;

}
