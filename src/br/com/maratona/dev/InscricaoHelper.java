package br.com.maratona.dev;

import java.util.ArrayList;
import java.util.List;

import br.com.maratona.dev.resource.Pessoa;

/**Project: maratonaDev
 * File: InscricaoHelper.java
 * @author jaime-Dev
 * Em 16-10-2020 **/

public class InscricaoHelper {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	public void init() {
		//List
		pessoas.add(new Pessoa("Clark Kent",1));
		pessoas.add(new Pessoa("Bruce Wayne",2));
		pessoas.add(new Pessoa("Stive Rogers",3));
	}
	/* Getter */
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
}
