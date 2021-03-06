package org.earthChem.presentation.rest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.earthChem.domain.Reference;
import org.earthChem.exception.InvalidDoiException;

/*******
 * To handle REST request
 * 
 * @author EarthChem3
 *
 */
@Path("references")
@ManagedBean
@RequestScoped
public class ReferencesRRH extends BaseRRH{
	final static public String OBJECT_NOT_FOUND = "Object not found.";

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{doi_root}/{doi}")
    public Response getReference(@PathParam("doi_root") String doiRoot,  @PathParam("doi") String doi) {
		Reference reference=null;
		String doiString=doiRoot + "/" + doi;
		try {
			reference = this.getReferenceManager().getReference(doiString);
		} catch (InvalidDoiException e) {
            return this.createErrorResponse(OBJECT_NOT_FOUND + "Can't find reference for given doi:" + doi);
		}

		if (reference != null) {
            return this.createOkResponse(reference, MediaType.APPLICATION_JSON);
        } else {
            return this.createErrorResponse(OBJECT_NOT_FOUND + "Can't find reference for given doi:" + doi);
        }
	}
}
