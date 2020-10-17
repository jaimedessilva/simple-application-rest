package br.com.maratona.dev.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


/**
 * Project: maratonaDev
 * File: InscricaoMaratonaResource.java
 * @author jaime-Dev
 * Em 16-10-2020 *
 */

/*
 * Rest API With Jersey / JAX-WS
 */
@Path(value = "inscricao")
public class InscricaoMaratonaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String index () {
		return "Pagina Inicial";
	}
	
	List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public void init() {
		// List
		pessoas.add(new Pessoa("Clark Kent", 1));
		pessoas.add(new Pessoa("Bruce Wayne", 2));
		pessoas.add(new Pessoa("Stive Rogers", 3));
		pessoas.add(new Pessoa("Oliver Queem", 4));
		pessoas.add(new Pessoa("Barry Allen", 5));
	}
	/*
	 * Insert
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lista/add")
	public Response add(Pessoa pessoa) {
		init();
		pessoa.setMatricula(pessoas.size()+1);
		pessoas.add(pessoa);
		return Response.status(Status.CREATED).entity(pessoa).build();	
	}
	/*
	 * List
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lista")
	public List<Pessoa> matricula() {
		init();
		return pessoas;
	}

	/*
	 * Find By ID
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lista/{id}")
	public Response findId(@PathParam("id") Integer id) {
		// Init Lista
		init();
		for (Pessoa indice : pessoas) {
			if (indice.getMatricula().equals(new Integer(id))) {
				return Response.status(Status.OK).entity(indice).build();
			}
		}
		return Response.status(Status.NO_CONTENT).build();
	}

	/*
	 * Delete By ID
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("lista/del/{id}")
	public Response deleteId(@PathParam("id") String id) {
		init();
		Pessoa pessoaDel = null;
		for (Pessoa indice : pessoas) {
			if (indice.getMatricula().equals(new Integer(id))) {
				pessoaDel = indice;
				}
			}
		if (pessoas.remove(pessoaDel)) {
			return Response.status(Status.OK).entity("Removido com sucesso!!").build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	/*
	 * Update by ID
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("lista/put/{id}")
	public Response update(@PathParam("id") String id, Pessoa pessoa) {
		init();
		
		Pessoa novaPessoa = new Pessoa();
		novaPessoa.setMatricula(new Integer(id));
		novaPessoa.setNome(pessoa.getNome());
		
		Pessoa pessoaAtual = null;
		for (Pessoa indice : pessoas) {
			if (indice.getMatricula().equals( new Integer(id))) {
				pessoaAtual = indice;
			}
		}
		if (pessoas.contains(pessoaAtual)) {
			int index = pessoas.indexOf(pessoaAtual);
			pessoas.set(index, novaPessoa);
			return Response
					.status(Status.OK)
					.entity(novaPessoa)
					.build();		
			}
		
		return Response.status(Status.NO_CONTENT).build();

	}

}