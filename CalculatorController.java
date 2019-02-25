package bvehr.megahr.pay.calculator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import bvehr.megahr.cmm.CmmController;
import bvehr.megahr.cmm.CmmDto;



/**
 *  급여 시뮬레이션
 * @author	김혜선
 * @since	2019.02.19
 */


public class CalculatorController extends CmmController {
	private String func_name = "calGridCode.hrm";
	
	@Autowired
	private CalculatorService service;

	public void setService(CalculatorService service) {
		this.service = service;
	}
	
	/* 해당 컨트롤러에 대한 모든 기능(methodName)에 대해 적용 할 경우 */
	protected void bind(HttpServletRequest request, Object command) throws Exception {
		super.bind(request, command);
		service.procAuthorize(request, func_name, (CmmDto) command);
		
		// 해당 화면에 권한 적용시키지 2012.11.23 Add
		service.getAuthoEmpList(request, (CmmDto) command );
	}
	
	public ModelAndView performTask(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		return selectList(request, response, dto);
	}

	/**
	 * 수당항목 List 조회
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectList(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> modelMap = service.selectList(dto);
		
		mav.addObject("dto", dto);
		mav.addAllObjects(modelMap);
		mav.setViewName("megahr/calculator/calGridCode");
		
		
		return mav;
	}

	/**
	 * 저장[List]
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveList(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		service.saveList(dto);
		
		mav.addObject("dto", dto);
		return mav;
	}

	/**
	 * 삭제[List]
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteList(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		service.deleteList(dto);
		
		mav.addObject("dto", dto);
		return mav;
	}
	
	/**
	 * 수당대상자 및 계산설정 추출
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectListDetail(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> modelMap = service.selectListDetail(dto);
		
		mav.addObject("dto", dto);
		mav.addAllObjects(modelMap);
		mav.setViewName("megahr/calculator/calculatorDetail");
		return mav;
	}
	
	/**
	 * 수당대상자 고정수당 설정에 의한 Dynamic 조회조건 Popup
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectWhereList(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		dto.setPage_size(10);
		
		ModelAndView mav = new ModelAndView();
		Map<String,Object> modelMap = service.selectWhereList(dto);
		
		mav.addObject("dto", dto);
		mav.addAllObjects(modelMap);
		mav.setViewName("megahr/calculator/calculatorDetail_search");
		return mav;
	}
	
	/**
	 * 수당대상자 저장[List]
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveListDetail(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		service.saveListDetail(dto);
		
		mav.addObject("dto", dto);
		return mav;
	}
	
	/**
	 * 수당대상자삭제[List]
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ModelAndView deleteListDetail(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		service.deleteListDetail(dto);
		
		mav.addObject("dto", dto);
		return mav;
	}

	/**
	 * 계산수식 검증
	 * @param request
	 * @param response
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ModelAndView formulaValid(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		service.formulaValid(dto);
		
		mav.addObject("dto", dto);
		return mav;
	}
	
    /**
     * 로직 내용 조회
     * @param request
     * @param response
     * @param dto
     * @return
     * @throws Exception
     */
    public ModelAndView selectLogicList(HttpServletRequest request, HttpServletResponse response, CalculatorDto dto) throws Exception {
        ModelAndView mav = new ModelAndView();
        
        Map<String, Object> modelMap = service.selectLogicList(dto);
        
        mav.addObject("dto", dto);
        mav.addAllObjects(modelMap);
        mav.setViewName("megahr/calculator/calGridCodeDetail_logic");
        return mav;
    }
}
