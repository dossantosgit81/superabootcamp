package io.github.mendesrafael.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutenticacaoResponseDTO {

	private Long id;
	
	private String token;
	
	public static String loginQuebrado(String login) {
		return login.substring(0, 3) + "********";
	}
}
