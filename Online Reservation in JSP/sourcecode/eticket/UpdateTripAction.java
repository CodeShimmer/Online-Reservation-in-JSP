//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package eticket;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 11-29-2006
 * 
 * XDoclet definition:
 * @struts:action path="/UpdateTrip" name="tripform" scope="request" validate="true"
 * @struts:action-forward name="success" path="/updatetripconf.jsp"
 * @struts:action-forward name="fail" path="/edittripdetails.jsp"
 */
public class UpdateTripAction extends Action {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)throws Exception {
		if(isCancelled(request))
			return mapping.findForward("fail");
		DynaValidatorForm tripform1 = (DynaValidatorForm) form;
		BusTripBean bus=new BusTripBean();
		BeanUtils.copyProperties(bus,tripform1);
		System.out.println("in updatetrip action after copyproperties");
		boolean valid=Validation.updateTrip(bus,getDataSource(request));
		System.out.println("after returning from updatetrip");
		if(valid)
			return mapping.findForward("success");
		return mapping.findForward("fail");	
		
	}

}