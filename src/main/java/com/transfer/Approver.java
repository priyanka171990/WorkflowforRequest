package com.transfer;

/** Different Request type approver
 *  <p>like - FundManager,ResearchAnalyst process and approve the request.
 * 
 * */
public class Approver {

	/**
	 * fundManagerApproval method which process and approve the request.
	 *
	 */
	public boolean fundManagerApproval(String req){
		//		try {
		//			Thread.sleep(1000);
		//		} 
		//		catch (InterruptedException e) {
		//			e.printStackTrace();
		//		} 
		System.out.println(" FundManager Approved request - " + req  );
		return true;
	} 

	/**
	 * researchAnalystApproval method which takes some time to process and approve the request.
	 *
	 */

	public boolean researchAnalystApproval(String req){
		//		  try {
		//			Thread.sleep(1000);
		//			} 
		//		  catch (InterruptedException e) {
		//			e.printStackTrace();
		//			}
		System.out.println(" ResearchAnalyst Approved request- "+ req  );
		return true;
	} 


	/**
	 * approval method which process and approve the request.
	 *
	 */
	public boolean divisionHeadApproval(String req){
		System.out.println(" DivisionHead Approved request- " + req  );
		return true;
	} 

	/**
	 * operationsApproval method which process and approve the request.
	 *
	 */
	public boolean operationsApproval(String req){
		System.out.println(" Operations Approved "  + req );
		return true;
	} 

	/**
	 * getProcessingResult method returns different approvals results. 
	 *
	 */

	public boolean getProcessingResult(String s,String req){
		if (s.equals("Fund Manager")) 
		{ 
			System.out.println(" Ready for FundManagerApproval"  );
			return fundManagerApproval(req);
		} 
		if (s.equals("Research Analyst")) 
		{ 
			System.out.println(" Ready for ResearchAnalystApproval"  );
			return researchAnalystApproval(req);
		}
		if (s.equals("Division Head")) 
		{ 
			System.out.println(" Ready for DivisionHeadApproval"  );
			return divisionHeadApproval(req);
		} 
		if (s.equals("Operations")) 
		{ 
			System.out.println(" Ready for OperationsApproval"  );
			return operationsApproval(req);
		}
		return false;
	}
}
