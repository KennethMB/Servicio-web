package ni.edu.uca.ConexionBD.services;

import java.util.List;
import java.util.Map;

@Service
public class GeneroService implements GeneroIRepository{

	@Autowired
	GeneroDRepository dRGenero;

	@Override
	public List<Map<String, Object>> MostrarRegistro() {
		// TODO Auto-generated method stub
		return dRGenero.MostrarRegistro();
	}

	@Override
	public int GuardarRegistro(Genero genero) {
		// TODO Auto-generated method stub
		return dRGenero.GuardarRegistro(genero);
	}

	@Override
	public int EditarRegistro(Genero genero) {
		// TODO Auto-generated method stub
		return dRGenero.EditarRegistro(genero);
	}

	@Override
	public int EliminarRegistro(int id) {
		// TODO Auto-generated method stub
		return dRGenero.EliminarRegistro(id);
	}

	
}
