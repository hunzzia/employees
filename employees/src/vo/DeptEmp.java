package vo;

public class DeptEmp {
	private int empNo;
	private String deptNo;
	private String fromNum;
	private String toNum;
	private Department Department;
	private int count;
	
	public Department getDepartment() {
		return Department;
	}
	public void setDepartment(Department Department) {
		this.Department = Department;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getFromNum() {
		return fromNum;
	}
	public void setFromNum(String fromNum) {
		this.fromNum = fromNum;
	}
	public String getToNum() {
		return toNum;
	}
	public void setToNum(String toNum) {
		this.toNum = toNum;
	}
		public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "DeptEmp [empNo=" + empNo + ", deptNo=" + deptNo + ", fromNum=" + fromNum + ", toNum=" + toNum
				+ ", Department=" + Department + ", count=" + count + "]";
	}
	
	
	
	
	
	
}
