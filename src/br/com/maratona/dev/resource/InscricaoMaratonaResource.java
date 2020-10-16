package br.com.maratona.dev.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Project: maratonaDev
 * File: InscricaoMaratonaResource.java
 * @author jaime-Dev
 * Em 16-10-2020 *
 */

@Path(value = "/inscricao")
public class InscricaoMaratonaResource {
	
	@GET
	public String matricula() {
		return "matricula realizada com sucesso!!!";
	}
}
