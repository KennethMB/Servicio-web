package ni.edu.uca.ConexionBD.controllers;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/idioma")
public class IdiomaController {

	@Autowired
	IdiomaService idiS;
	
	@RequestMapping("/listar")
	public List<Map<String, Object>> listar(){
		return idiS.MostrarRegistro();
	}
	
	@PostMapping("/agregar")
	public String AgregarGen(@RequestBody Idioma idi) {
		String msg = "Error al guardar registro...";
		int b = idiS.GuardarRegistro(idi);
		if(b==1) msg = "Registro guardado satisfactoriamente";
		return "";
	}
	
	@PutMapping("/actualizar/{id}")
	public String EditarIdi(@RequestBody Idioma idi, @PathVariable int id, Model model) {
		String msg = "Error al editar registro...";
		idi.setIdIdioma(id);
		int b = idiS.EditarRegistro(idi);
		if(b == 1 ) msg ="Registro editado satisfactoriamente...";
		return msg;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String EliminarIdi(@PathVariable int id, Model model) {
		String msg = "Error al eliminar registro...";
		int b = idiS.EliminarRegistro(id);
		if (b == 1 ) msg = "Registro Eliminado satisfactoriamente...";
		return msg;
	}
	
}
