package ni.edu.uca.ConexionBD.repositories;

import java.util.List;

@Repository
public class GeneroDRepositoy implements GeneroIRepository {
	@Autowired
	JdbcTemplate template;

	@Overried
	public List<Map<String, Object>> MostrarRegistro() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> lista = template.queryForList("Select * from Genero");
		return lista;
	
	}
	@Override
	public int GuardarRegistro(Genero genero) {
		// TODO Auto-generated method stub
		int b = 0;
		b = template.update("Insert into Genero(nombre, activo) values(?, ?)",
		new Object[] {genero.getNombre(), genero.isActivo()});
		return b;
	}

	@Override
	public int EditarRegistro(Genero genero) {
		// TODO Auto-generated method stub
		int b = 0;
		b = template.update("Update Genero set nombre = ?, activo = ? where idGenero = ? ",
			new Object[] {genero.getNombre(), genero.isActivo(), genero.getIdGenero()});
		return b ;
	}

	@Override
	public int EliminarRegistro(int id) {
		// TODO Auto-generated method stub
		int b = 0;
		b = template.update("Delete from Genero where idGenero = ?", id);
	}
	

}

