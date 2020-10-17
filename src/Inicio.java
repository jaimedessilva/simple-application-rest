import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import br.com.maratona.dev.resource.Pessoa;

public class Inicio {

	public static void main(String[] args) throws JsonIOException, IOException {
		
		String path = "/home/jaime/";
		
		Pessoa p = new Pessoa("Morais Moreira",1);
		//Gson gson1 = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		
		gson.toJson(p, new FileWriter(path));
		

	}

}
