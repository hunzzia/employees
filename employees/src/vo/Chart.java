package vo;
// 차트 데이터를 저장하기위한 객체
public class Chart {
	private int departmentsRowCount;
	private int employeesRowCount;
	private int deptManagerRowCount;
	private int deptEmpRowCount;
	private int salariesRowCount;
	private int titlesRowCount;
	public int getDepartmentsRowCount() {
		return departmentsRowCount;
	}
	public void setDepartmentsRowCount(int departmentsRowCount) {
		this.departmentsRowCount = departmentsRowCount;
	}
	public int getEmployeesRowCount() {
		return employeesRowCount;
	}
	public void setEmployeesRowCount(int employeesRowCount) {
		this.employeesRowCount = employeesRowCount;
	}
	public int getDeptManagerRowCount() {
		return deptManagerRowCount;
	}
	public void setDeptManagerRowCount(int deptManagerRowCount) {
		this.deptManagerRowCount = deptManagerRowCount;
	}
	public int getDeptEmpRowCount() {
		return deptEmpRowCount;
	}
	public void setDeptEmpRowCount(int deptEmpRowCount) {
		this.deptEmpRowCount = deptEmpRowCount;
	}
	public int getSalariesRowCount() {
		return salariesRowCount;
	}
	public void setSalariesRowCount(int salariesRowCount) {
		this.salariesRowCount = salariesRowCount;
	}
	public int getTitlesRowCount() {
		return titlesRowCount;
	}
	public void setTitlesRowCount(int titlesRowCount) {
		this.titlesRowCount = titlesRowCount;
	}
	@Override
	public String toString() {
		return "Chart [departmentsRowCount=" + departmentsRowCount + ", employeesRowCount=" + employeesRowCount
				+ ", deptManagerRowCount=" + deptManagerRowCount + ", deptEmpRowCount=" + deptEmpRowCount
				+ ", salariesRowCount=" + salariesRowCount + ", titlesRowCount=" + titlesRowCount + "]";
	}
}
