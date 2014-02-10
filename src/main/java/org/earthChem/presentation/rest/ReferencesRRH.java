package org.earthChem.presentation.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.earthChem.domain.Reference;

/*******
 * To handle REST request
 * 
 * @author EarthChem3
 *
 */
@Path("references")
public class ReferencesRRH extends BaseRRH{
	final static public String OBJECT_NOT_FOUND = "Object not found.";

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{doi_root}/{doi}")
    public Response getReference(@PathParam("doi_root") String doiRoot,  @PathParam("doi") String doi) {
		Reference reference=null;
		String doiString=doiRoot + "/" + doi;
		reference = this.getReferenceManager().getReference(doiString);

		if (reference != null) {
            return this.createOkResponse(reference, MediaType.APPLICATION_JSON);
        } else {
            return this.createErrorResponse(OBJECT_NOT_FOUND + "Can't find reference for given doi:" + doi);
        }
	}
}
