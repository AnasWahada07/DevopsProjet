package tn.esprit.rh.achat.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.rh.achat.converter.CategorieProduitConverter;
import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.List;

@Service
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CategorieProduitConverter categorieproduitConverter;
	
	
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	@Override
	public List<CategorieProduit> retrieveAllCategorieProduits() {
		
		return categorieProduitRepository.findAll();
	}

	@Override
	public CategorieProduit addCategorieProduit(CategorieProduit cp) {
		categorieProduitRepository.save(cp);
		return cp;
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}

	@Override
	public CategorieProduitDTO updateCategorieProduit(CategorieProduitDTO cp) {
		
		CategorieProduit catp = categorieproduitConverter.convertDtoToEntity(cp);
		catp = categorieProduitRepository.save(catp);
		return categorieproduitConverter.convertEntityToDto(catp);
	}

	@Override
	public CategorieProduit retrieveCategorieProduit(Long id) {
		return categorieProduitRepository.findById(id).orElse(null);
	}

}
