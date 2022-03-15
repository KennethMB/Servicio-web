package ni.edu.uca.ConexionBD.controllers;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/genero")
public class GeneroController {

	@Autowired
	GeneroService genS;
	
	@RequestMapping("/listar")
	public List<Map<String, Object>> listar(){
		return genS.MostrarRegistro();
	}
	
	@PostMapping("/agregar")
	public String AgregarGen(@RequestBody Genero gen) {
		String msg = "Error al guardar registro...";
		int b = genS.GuardarRegistro(gen);
		if(b==1) msg = "Registro guardado satisfactoriamente";
		return "";
	}
	
	@PutMapping("/actualizar/{id}")
	public String EditarGen(@RequestBody Genero gen, @PathVariable int id, Model model) {
		String msg = "Error al editar registro...";
		gen.setIdGenero(id);
		int b = genS.EditarRegistro(gen);
		if(b == 1 ) msg ="Registro editado satisfactoriamente...";
		return msg;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String EliminarGen(@PathVariable int id, Model model) {
		String msg = "Error al eliminar registro...";
		int b = genS.EliminarRegistro(id);
		if (b == 1 ) msg = "Registro Eliminado satisfactoriamente...";
		return msg;
	}
	
}
