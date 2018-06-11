package com.auto.env.model;

public class Package {
	
	private String pkg_cd; 
	private String pkgr_pkg_cd; 
	private String sales_channe;
	
	
	
	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Package(String pkg_cd, String pkgr_pkg_cd, String sales_channe) {
		super();
		this.pkg_cd = pkg_cd;
		this.pkgr_pkg_cd = pkgr_pkg_cd;
		this.sales_channe = sales_channe;
	}
	public String getPkg_cd() {
		return pkg_cd;
	}
	public void setPkg_cd(String pkg_cd) {
		this.pkg_cd = pkg_cd;
	}
	public String getPkgr_pkg_cd() {
		return pkgr_pkg_cd;
	}
	public void setPkgr_pkg_cd(String pkgr_pkg_cd) {
		this.pkgr_pkg_cd = pkgr_pkg_cd;
	}
	public String getSales_channe() {
		return sales_channe;
	}
	public void setSales_channe(String sales_channe) {
		this.sales_channe = sales_channe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkg_cd == null) ? 0 : pkg_cd.hashCode());
		result = prime * result + ((pkgr_pkg_cd == null) ? 0 : pkgr_pkg_cd.hashCode());
		result = prime * result + ((sales_channe == null) ? 0 : sales_channe.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Package other = (Package) obj;
		if (pkg_cd == null) {
			if (other.pkg_cd != null)
				return false;
		} else if (!pkg_cd.equals(other.pkg_cd))
			return false;
		if (pkgr_pkg_cd == null) {
			if (other.pkgr_pkg_cd != null)
				return false;
		} else if (!pkgr_pkg_cd.equals(other.pkgr_pkg_cd))
			return false;
		if (sales_channe == null) {
			if (other.sales_channe != null)
				return false;
		} else if (!sales_channe.equals(other.sales_channe))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\n[pkg_cd=" + pkg_cd + ", pkgr_pkg_cd=" + pkgr_pkg_cd + ", sales_channe=" + sales_channe + "]";
	}
	
	}
