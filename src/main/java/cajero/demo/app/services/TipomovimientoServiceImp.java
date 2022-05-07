package cajero.demo.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cajero.demo.app.entity.Tipomovimiento;
import cajero.demo.app.repository.TipomovimientoRepository;


@Service
public class TipomovimientoServiceImp implements TipomovimientoService {

	@Autowired
	private TipomovimientoRepository tipomovimientoRepository;
	
	@Override
	public Tipomovimiento save(Tipomovimiento tipomovimiento) {
		return tipomovimientoRepository.save(tipomovimiento);
	}

	@Override
	public Iterable<Tipomovimiento> findAll() {
		return tipomovimientoRepository.findAll();
	}

	@Override
	public Optional<Tipomovimiento> findById(Long id) {
		return tipomovimientoRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 tipomovimientoRepository.deleteById(id);
		
	}

}
