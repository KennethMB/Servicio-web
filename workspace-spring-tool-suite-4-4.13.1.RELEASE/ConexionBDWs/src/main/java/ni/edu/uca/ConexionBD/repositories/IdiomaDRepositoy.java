package ni.edu.uca.ConexionBD.repositories;

import java.util.List;

@Repository
public class GeneroDRepositoy implements IdiomaIRepository {
	@Autowired
	JdbcTemplate template;

	@Overried
	public List<Map<String, Object>> MostrarRegistro() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> lista = template.queryForList("Select * from Idioma");
		return lista;
	
	}
	@Override
	public int GuardarRegistro(Idioma idioma) {
		// TODO Auto-generated method stub
		int b = 0;
		b = template.update("Insert into Idioma(nombre, activo) values(?, ?)",
		new Object[] {idioma.getNombre(), idioma.isActivo()});
		return b;
	}

	@Override
	public int EditarRegistro(Idioma idioma) {
		// TODO Auto-generated method stub
		int b = 0;
		b = template.update("Update Idioma set nombre = ?, activo = ? where idIdioma = ? ",
			new Object[] {idioma.getNombre(), idioma.isActivo(), idioma.getIdIdioma()});
		return b ;
	}

	@Override
	public int EliminarRegistro(int id) {
		// TODO Auto-generated method stub
		int b = 0;
		b = template.update("Delete from Idioma where idIdioma = ?", id);
	}
	

}

