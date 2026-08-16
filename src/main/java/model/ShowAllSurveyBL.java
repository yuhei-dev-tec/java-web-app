package model;

import java.util.ArrayList;
import java.util.List;


public class ShowAllSurveyBL {
	
	public List<SurveyDto> doSelectBL(){
		
		List<SurveyDto> dtoListBL = new ArrayList<SurveyDto>();
		
		SurveyDao dao = new SurveyDao();
		dtoListBL = dao.doSelect();
		
		return dtoListBL;
		
	}

}
