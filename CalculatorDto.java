package bvehr.megahr.pay.calculator;


import bvehr.megahr.pay.cmm.dto.Py21Dto;

@SuppressWarnings("serial")
public class CalculatorDto extends Py21Dto {
	
	private Integer[] arr_num;
	private Integer[] arr_org_id;
	private String[] arr_compycd;
	private String[] arr_allowcd;
	private String[] arr_allownm;
	private String[] arr_start_mth;
	private String[] arr_end_mth;
	private String[] arr_calc_method;
	private String[] arr_description;
	private Integer[] arr_calc_order;
	private String[] arr_normally;
	private String[] arr_allowed;
	private String[] arr_ret_apply;
	private String[] arr_retroact;
	private String[] arr_pay_class;
	private Integer[] arr_sort;
	private String[] arr_day_cal;
	private String[] arr_nontax_yn;
	private Integer[] arr_nontax_limit_amt;
	private String[] arr_base_allow_yn;
	
	private String srch_allowcd;
	private String srch_allownm;
	private String srch_pay_class;
	private String srch_compycd;
	
	//고정설정 부분
	private String as_class;
	private String srch_precede_num;
	private String query;
	
	private String ref_value_1;
	private String ref_value_2;
	private String ref_value_3;
	private String ref_value_4;
	private String ref_value_5;
	private String key_value;
	private String popup_id;
	private String seq;
	
	//대상자항목
	private String as_cd;
	private String precede_num1;
	private String key_value1;
	private String precede_num2;
	private String key_value2;
	private String precede_num3;
	private String key_value3;
	private String enabled_flag;
	private String exec_yn;
	
	private String code1;
	private String data1;
	private String code2;
	private String data2;
	private String code3;
	private String data3;
	
	private String[] arr_as_class;
	private String[] arr_as_cd;
	private String[] arr_precede_num1;
	private String[] arr_key_value1;
	private String[] arr_precede_num2;
	private String[] arr_key_value2;
	private String[] arr_precede_num3;
	private String[] arr_key_value3;
	private String[] arr_enabled_flag;
	private String[] arr_exec_yn;
	
	private String row_id;
	private String[] arr_row_id;
	private Integer srch_page_num;
	
	private String object_name;
	private String text;
	
	public void setArr_num(Integer[] arr_num) {
		this.arr_num = arr_num;
	}
	public Integer[] getArr_num() {
		return arr_num;
	}
	public Integer[] getArr_org_id() {
		return arr_org_id;
	}
	public void setArr_org_id(Integer[] arrOrgId) {
		arr_org_id = arrOrgId;
	}
	public String[] getArr_allowcd() {
		return arr_allowcd;
	}
	public void setArr_allowcd(String[] arrAllowcd) {
		arr_allowcd = arrAllowcd;
	}
	public String[] getArr_allownm() {
		return arr_allownm;
	}
	public void setArr_allownm(String[] arrAllownm) {
		arr_allownm = arrAllownm;
	}
	public String[] getArr_start_mth() {
		return arr_start_mth;
	}
	public void setArr_start_mth(String[] arrStartMth) {
		arr_start_mth = arrStartMth;
	}
	public String[] getArr_end_mth() {
		return arr_end_mth;
	}
	public void setArr_end_mth(String[] arrEndMth) {
		arr_end_mth = arrEndMth;
	}
	public String[] getArr_calc_method() {
		return arr_calc_method;
	}
	public void setArr_calc_method(String[] arrCalcMethod) {
		arr_calc_method = arrCalcMethod;
	}
	public String[] getArr_description() {
		return arr_description;
	}
	public void setArr_description(String[] arrDescription) {
		arr_description = arrDescription;
	}
	public Integer[] getArr_calc_order() {
		return arr_calc_order;
	}
	public void setArr_calc_order(Integer[] arrCalcOrder) {
		arr_calc_order = arrCalcOrder;
	}
	public String[] getArr_normally() {
		return arr_normally;
	}
	public void setArr_normally(String[] arrNormally) {
		arr_normally = arrNormally;
	}
	public String[] getArr_allowed() {
		return arr_allowed;
	}
	public void setArr_allowed(String[] arrAllowed) {
		arr_allowed = arrAllowed;
	}
	public String[] getArr_ret_apply() {
		return arr_ret_apply;
	}
	public void setArr_ret_apply(String[] arrRetApply) {
		arr_ret_apply = arrRetApply;
	}
	public String[] getArr_retroact() {
		return arr_retroact;
	}
	public void setArr_retroact(String[] arrRetroact) {
		arr_retroact = arrRetroact;
	}
	public String[] getArr_pay_class() {
		return arr_pay_class;
	}
	public void setArr_pay_class(String[] arrPayClass) {
		arr_pay_class = arrPayClass;
	}
	public Integer[] getArr_sort() {
		return arr_sort;
	}
	public void setArr_sort(Integer[] arrSort) {
		arr_sort = arrSort;
	}
	public String[] getArr_day_cal() {
		return arr_day_cal;
	}
	public void setArr_day_cal(String[] arrDayCal) {
		arr_day_cal = arrDayCal;
	}
	public String[] getArr_nontax_yn() {
		return arr_nontax_yn;
	}
	public void setArr_nontax_yn(String[] arr_nontax_yn) {
		this.arr_nontax_yn = arr_nontax_yn;
	}
	public Integer[] getArr_nontax_limit_amt() {
		return arr_nontax_limit_amt;
	}
	public void setArr_nontax_limit_amt(Integer[] arr_nontax_limit_amt) {
		this.arr_nontax_limit_amt = arr_nontax_limit_amt;
	}
	public String getSrch_allowcd() {
		return srch_allowcd;
	}
	public void setSrch_allowcd(String srch_allowcd) {
		this.srch_allowcd = srch_allowcd;
	}
	public String getSrch_allownm() {
		return srch_allownm;
	}
	public void setSrch_allownm(String srch_allownm) {
		this.srch_allownm = srch_allownm;
	}
	public String getSrch_pay_class() {
		return srch_pay_class;
	}
	public void setSrch_pay_class(String srch_pay_class) {
		this.srch_pay_class = srch_pay_class;
	}
	public final String getAs_class() {
		return as_class;
	}
	public final void setAs_class(String as_class) {
		this.as_class = as_class;
	}
	public final String getSrch_precede_num() {
		return srch_precede_num;
	}
	public final void setSrch_precede_num(String srch_precede_num) {
		this.srch_precede_num = srch_precede_num;
	}
	public final String getQuery() {
		return query;
	}
	public final void setQuery(String query) {
		this.query = query;
	}
	public final String getRef_value_1() {
		return ref_value_1;
	}
	public final void setRef_value_1(String ref_value_1) {
		this.ref_value_1 = ref_value_1;
	}
	public final String getRef_value_2() {
		return ref_value_2;
	}
	public final void setRef_value_2(String ref_value_2) {
		this.ref_value_2 = ref_value_2;
	}
	public final String getRef_value_3() {
		return ref_value_3;
	}
	public final void setRef_value_3(String ref_value_3) {
		this.ref_value_3 = ref_value_3;
	}
	public final String getRef_value_4() {
		return ref_value_4;
	}
	public final void setRef_value_4(String ref_value_4) {
		this.ref_value_4 = ref_value_4;
	}
	public final String getRef_value_5() {
		return ref_value_5;
	}
	public final void setRef_value_5(String ref_value_5) {
		this.ref_value_5 = ref_value_5;
	}
	public final String getKey_value() {
		return key_value;
	}
	public final void setKey_value(String key_value) {
		this.key_value = key_value;
	}
	public final String getPopup_id() {
		return popup_id;
	}
	public final void setPopup_id(String popup_id) {
		this.popup_id = popup_id;
	}
	public final String getSeq() {
		return seq;
	}
	public final void setSeq(String seq) {
		this.seq = seq;
	}
	public final String getAs_cd() {
		return as_cd;
	}
	public final void setAs_cd(String as_cd) {
		this.as_cd = as_cd;
	}
	public final String getPrecede_num1() {
		return precede_num1;
	}
	public final void setPrecede_num1(String precede_num1) {
		this.precede_num1 = precede_num1;
	}
	public final String getKey_value1() {
		return key_value1;
	}
	public final void setKey_value1(String key_value1) {
		this.key_value1 = key_value1;
	}
	public final String getPrecede_num2() {
		return precede_num2;
	}
	public final void setPrecede_num2(String precede_num2) {
		this.precede_num2 = precede_num2;
	}
	public final String getKey_value2() {
		return key_value2;
	}
	public final void setKey_value2(String key_value2) {
		this.key_value2 = key_value2;
	}
	public final String getPrecede_num3() {
		return precede_num3;
	}
	public final void setPrecede_num3(String precede_num3) {
		this.precede_num3 = precede_num3;
	}
	public final String getKey_value3() {
		return key_value3;
	}
	public final void setKey_value3(String key_value3) {
		this.key_value3 = key_value3;
	}
	public final String getEnabled_flag() {
		return enabled_flag;
	}
	public final void setEnabled_flag(String enabled_flag) {
		this.enabled_flag = enabled_flag;
	}
	public final String getCode1() {
		return code1;
	}
	public final void setCode1(String code1) {
		this.code1 = code1;
	}
	public final String getData1() {
		return data1;
	}
	public final void setData1(String data1) {
		this.data1 = data1;
	}
	public final String getCode2() {
		return code2;
	}
	public final void setCode2(String code2) {
		this.code2 = code2;
	}
	public final String getData2() {
		return data2;
	}
	public final void setData2(String data2) {
		this.data2 = data2;
	}
	public final String getCode3() {
		return code3;
	}
	public final void setCode3(String code3) {
		this.code3 = code3;
	}
	public final String getData3() {
		return data3;
	}
	public final void setData3(String data3) {
		this.data3 = data3;
	}
	public final String[] getArr_as_class() {
		return arr_as_class;
	}
	public final void setArr_as_class(String[] arr_as_class) {
		this.arr_as_class = arr_as_class;
	}
	public final String[] getArr_as_cd() {
		return arr_as_cd;
	}
	public final void setArr_as_cd(String[] arr_as_cd) {
		this.arr_as_cd = arr_as_cd;
	}
	public final String[] getArr_precede_num1() {
		return arr_precede_num1;
	}
	public final void setArr_precede_num1(String[] arr_precede_num1) {
		this.arr_precede_num1 = arr_precede_num1;
	}
	public final String[] getArr_key_value1() {
		return arr_key_value1;
	}
	public final void setArr_key_value1(String[] arr_key_value1) {
		this.arr_key_value1 = arr_key_value1;
	}
	public final String[] getArr_precede_num2() {
		return arr_precede_num2;
	}
	public final void setArr_precede_num2(String[] arr_precede_num2) {
		this.arr_precede_num2 = arr_precede_num2;
	}
	public final String[] getArr_key_value2() {
		return arr_key_value2;
	}
	public final void setArr_key_value2(String[] arr_key_value2) {
		this.arr_key_value2 = arr_key_value2;
	}
	public final String[] getArr_precede_num3() {
		return arr_precede_num3;
	}
	public final void setArr_precede_num3(String[] arr_precede_num3) {
		this.arr_precede_num3 = arr_precede_num3;
	}
	public final String[] getArr_key_value3() {
		return arr_key_value3;
	}
	public final void setArr_key_value3(String[] arr_key_value3) {
		this.arr_key_value3 = arr_key_value3;
	}
	public final String[] getArr_enabled_flag() {
		return arr_enabled_flag;
	}
	public final void setArr_enabled_flag(String[] arr_enabled_flag) {
		this.arr_enabled_flag = arr_enabled_flag;
	}
	public final String getRow_id() {
		return row_id;
	}
	public final void setRow_id(String row_id) {
		this.row_id = row_id;
	}
	public final String[] getArr_row_id() {
		return arr_row_id;
	}
	public final void setArr_row_id(String[] arr_row_id) {
		this.arr_row_id = arr_row_id;
	}
	public final String getSrch_compycd() {
		return srch_compycd;
	}
	public final void setSrch_compycd(String srch_compycd) {
		this.srch_compycd = srch_compycd;
	}
	public final String[] getArr_compycd() {
		return arr_compycd;
	}
	public final void setArr_compycd(String[] arr_compycd) {
		this.arr_compycd = arr_compycd;
	}
	public final String[] getArr_base_allow_yn() {
		return arr_base_allow_yn;
	}
	public final void setArr_base_allow_yn(String[] arr_base_allow_yn) {
		this.arr_base_allow_yn = arr_base_allow_yn;
	}
	public final String getExec_yn() {
		return exec_yn;
	}
	public final void setExec_yn(String exec_yn) {
		this.exec_yn = exec_yn;
	}
	public final String[] getArr_exec_yn() {
		return arr_exec_yn;
	}
	public final void setArr_exec_yn(String[] arr_exec_yn) {
		this.arr_exec_yn = arr_exec_yn;
	}
	public final Integer getSrch_page_num() {
		return srch_page_num;
	}
	public final void setSrch_page_num(Integer srch_page_num) {
		this.srch_page_num = srch_page_num;
	}
	public final String getObject_name() {
		return object_name;
	}
	public final void setObject_name(String object_name) {
		this.object_name = object_name;
	}
	public final String getText() {
		return text;
	}
	public final void setText(String text) {
		this.text = text;
	}
	
}
