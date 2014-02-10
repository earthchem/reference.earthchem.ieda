package org.earthChem.presentation.rest;


import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.earthChem.bll.ReferenceManager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/*******************************************************************************
 * A base class for all resource request handlers
 *
 * @author bsun
 *
 */
public class BaseRRH
{
	@Context
	protected UriInfo uriInfo;
	@Context
	protected Request request;
	@Context
	protected SecurityContext sc;
    @Context
    protected ServletContext servletContext;

	/***************************************************************************
	 * To create ok response for given object and content type
	 *
	 * @param o
	 * @param contentType
	 * @return HTTP response
	 */
	protected Response createOkResponse(Object o, String contentType)
	{
		Response response = Response.ok(o, contentType).build();
		return response;
	}

	/***************************************************************************
	 * To create ok response for given object and content type
	 *
	 * @return HTTP response
	 */
	protected Response createOkResponse()
	{
		Response response = Response.ok().build();
		return response;
	}

	/***************************************************************************
	 * To create an error HTTP response for given error message
	 *
	 * @param msg
	 * @return
	 */
	protected Response createErrorResponse(String msg)
	{
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(msg).build();
		return response;

	}

	/***************************************************************************
	 * to get the Logger for current class.
	 *
	 * @return
	 */
	protected Logger getLogger()
	{
		return Logger.getLogger(this.getClass().getSimpleName() + ".class");
	}


    protected ReferenceManager getReferenceManager() {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.servletContext);
        return (ReferenceManager) context.getBean("referenceManager");

    }

}
