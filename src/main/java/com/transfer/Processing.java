package com.transfer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



/**
 * <p>Processing stores stage and request to be processed.<p>maintains status of request till which stage request has been approved.
 * <p>It also maintains request to be processed at different stages of processing engine.
 * 
 */
public class Processing {

	int status;
	final String request;
	final Approver approver;
	
	public Processing(int status, String request, Approver approver) {
		this.status = status;
		this.request = request;
		this.approver = approver;
	}
    /**
     * getStatus method is use to get the stage of request
     *  @return stage of request processing.
      */
	public int getStatus() {
		return status;
	}

	/** 
	 * 
	 * setStatus method is use to set the stage of request
	 * @param stage of request processing.*/
	public void setStatus(int status) {
		this.status = status;
	}
	 
/**
 * Method is to to run request in parallel which are at same stage.
 * @param meth List the list of approvers to be run in parallel.
 * @return List of status with each approver.
 * <p>Can be configured for different request types.Like "Bank Cheque Request". 
 */
	public List<Future<Boolean>> runParallel(ArrayList<String> meth)
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<Boolean>> al =new ArrayList<Future<Boolean>>();
		for(final String s:meth)
		{
			al.add (executorService.submit(
					new Callable<Boolean>(){
						public Boolean call() throws Exception {
							return approver.getProcessingResult(s, request);
							
						}
					}));

		}
		executorService.shutdown();
		return al;

	}

	/**
	 * <p> Method is to to run request in which is at this stage.
	 * @param s contains which approver to be executed at this stage.
	 * @return List of status with each approver.
	 *<p> Can be configured for different request types.Like "Bank Cheque Request". 
	 *
	 */
	public Boolean runLinear(String s)
	{
		return approver.getProcessingResult(s, request);
	}

}
