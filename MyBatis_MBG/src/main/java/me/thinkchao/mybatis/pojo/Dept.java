package me.thinkchao.mybatis.pojo;

public class Dept {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.did
     *
     * @mbggenerated Thu Oct 12 21:29:49 CST 2023
     */
    private Integer did;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.dept_name
     *
     * @mbggenerated Thu Oct 12 21:29:49 CST 2023
     */
    private String deptName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.did
     *
     * @return the value of dept.did
     *
     * @mbggenerated Thu Oct 12 21:29:49 CST 2023
     */
    public Integer getDid() {
        return did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.did
     *
     * @param did the value for dept.did
     *
     * @mbggenerated Thu Oct 12 21:29:49 CST 2023
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.dept_name
     *
     * @return the value of dept.dept_name
     *
     * @mbggenerated Thu Oct 12 21:29:49 CST 2023
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.dept_name
     *
     * @param deptName the value for dept.dept_name
     *
     * @mbggenerated Thu Oct 12 21:29:49 CST 2023
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}