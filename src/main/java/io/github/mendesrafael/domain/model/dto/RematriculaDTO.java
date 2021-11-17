package io.github.mendesrafael.domain.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import io.github.mendesrafael.domain.model.Rematricula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RematriculaDTO {
	
	public Long id;
	
	public String nomeCurso;
	
	public String status;
	
	public static List<RematriculaDTO> transformTypeList(List<Rematricula> list){
		ModelMapper modelMapper = new ModelMapper();
		return list
				.stream()
				.map(entity ->  modelMapper.map(entity, RematriculaDTO.class))
				.collect(Collectors.toList());
	}

}
