package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.repository.KindergartenRepository;

@Service
public class KindergartenServiceImpl implements IKindergartenService {

	@Autowired
	KindergartenRepository kindergartenRepository;

	@Override
	public void addKindergarten(Kindergarten kindergarten) {
		kindergartenRepository.save(kindergarten);
	}

	@Override
	public void deleteKindergarten(int id) {
		kindergartenRepository.deleteById(id);
	}

	@Override
	public Kindergarten updateKindergarten(int id, Kindergarten kindergarten) {
		Kindergarten kindergartens = kindergartenRepository.findById(id).orElse(null);

		if (kindergarten.getName() !=  null) {
			kindergartens.setName(kindergarten.getName());
		}
		if (kindergarten.getAddress() != null) {
			kindergartens.setAddress(kindergarten.getAddress());
		}
		if (kindergarten.getDescription() != null) {
			kindergartens.setDescription(kindergarten.getDescription());
		}
		if (kindergarten.getPrice_month() != 0) {
			kindergartens.setPrice_month(kindergartens.getPrice_month());
		}
		if (kindergarten.getDiscount() != 0) {
			kindergartens.setDiscount(kindergarten.getDiscount());
		}
		if (kindergarten.getImage() != null) {
			kindergartens.setImage(kindergarten.getImage());
		}
		kindergartenRepository.save(kindergartens);
		return kindergartens;
	}

	@Override
	public Kindergarten retrieveKindergarten(int id) {
		Kindergarten kindergarten = kindergartenRepository.findById(id).orElse(null);
		return kindergarten;
	}

	@Override
	public List<Kindergarten> retrieveAllKindergartens() {
		List<Kindergarten> kindergarten = (List<Kindergarten>) kindergartenRepository.findAll();
		return kindergarten;
	}

}
