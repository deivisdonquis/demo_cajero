package cajero.demo.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cajero.demo.app.entity.Cuenta;
import cajero.demo.app.repository.CuentaRepository;

@Service
public class CuentaServiceImp implements CuentaService{

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Override
	public Cuenta save(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public Iterable<Cuenta> findAll() {
		return cuentaRepository.findAll();
	}

	@Override
	public Optional<Cuenta> findById(Long id) {
		return cuentaRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		cuentaRepository.deleteById(id);
	}

	@Override
	public void delete(Cuenta cuenta) {
		cuentaRepository.delete(cuenta);
	}

}
