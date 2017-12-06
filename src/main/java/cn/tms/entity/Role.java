package cn.tms.entity;

public class Role {
    private Integer rid;//角色编号
    private String rolename;//角色名称

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public Role(){
    }
    public Role(Integer rid,String rolename){
	    this.rid = rid;
	    this.rolename = rolename;
    }
}
