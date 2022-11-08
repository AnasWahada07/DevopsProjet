package tn.esprit.rh.achat.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

@Component
public class CategorieProduitConverter {
	
	public CategorieProduitDTO convertEntityToDto(CategorieProduit categorieProduit) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(categorieProduit, CategorieProduitDTO.class);
	}
	
	
    public CategorieProduit convertDtoToEntity(CategorieProduitDTO categorieProduitDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categorieProduitDTO, CategorieProduit.class);
    }

}
