package com.auto.env.constants;

public interface IConstants {

	public static final String CALLED_STR = "Called ";
	public static final String METHOD_START = " Method Start";
	public static final String METHOD_END = " Method End";
	public static final String FOLDER_PROPERTIES_FILE = "src/main/resources/db.properties";
	
	// DB Queries
	public static final String acceptedpackageQuery = "Select PBL_DATE, GT_CODE, ACTION, CHANNEL from SBC.PRODUCTBUILDERLOG Where to_date(PBL_DATE,'DD-MON-YYYY') = to_date(SYSDATE,'DD-MON-YYYY')Order by PBL_DATE DESC";
	public static final String rejectedPackagesQuery = "Select PBL_DATE, GT_CODE, ACTION, CHANNEL, PBL_RETMSG from SBC.PRODUCTBUILDERLOG Where to_date(PBL_DATE,'DD-MON-YYYY') = to_date(SYSDATE,'DD-MON-YYYY') And Action='REJECTED' Order by PBL_DATE DESC";
	public static final String rejectedPackageValidQuery = "Select  GT_CODE, ACTION, CHANNEL from SBC.PRODUCTBUILDERLOG Where to_date(PBL_DATE,'DD-MON-YYYY') = to_date(SYSDATE,'DD-MON-YYYY') And Action='REJECTED' And CHANNEL IN (Select CHANNEL from SBC.SALES_CHANNEL) Order by PBL_DATE DESC";
	public static final String channelsQuery = "Select CHANNEL from SBC.SALES_CHANNEL where ISINCLUDED in ('1')";
	public static final String updatePMADB="update pma_wdw.pkg set last_updt = sysdate where TRVL_END_DT > sysdate and SALES_CHANNEL not in ('AIRTOUR','ASIA','CAN','CANIA','CK MDW','Campus','DCL','DCL NBLK','DVC','DVC DINE','DVC DISCOL','DVC MBRSVC','EUR','EUR C','GDS','GDS AAA','GDS AAAMM','GLBL RECP','GLBL UK','GROUPS','GST SVCS','INTR IA','JAPAN','LATIN IA','LATIN RECP','LGDCD','LGDTA','LGRTA','LGS','MESA','RCI','RGSR','RSR','SHADES','SPORTS','THOMPSON','UK','UK IA','US','US IA','VIRGIN','WDTC-SPORTS','WDTC-UK','WEDDING','WHOLESALE')";
	
	public static final String updatePackagePMADB="update pma_wdw.pkg set last_updt = sysdate where TRVL_END_DT > sysdate and pkg_cd in ('')";
	public static final String updateContractPMADB="update pma_wdw.pkg set last_updt = sysdate where pkg_cd in (SELECT DISTINCT p.pkg_cd FROM PMA_WDW.TBX_PROD a, PMA_WDW.ACMPROD_PKG b, PMA_WDW.TBX_PROD_GNRT c,  PMA_WDW.PKG p WHERE b.TBX_PROD_GNRT_ID = c.TBX_PROD_GNRT_ID AND c.TBX_PROD_ID = a.TBX_PROD_ID AND a.TBX_TYP_NM = 'PACKAGE' AND p.pkg_cd = b.pkg_cd AND p.TRVL_END_DT > sysdate AND SALES_CHANNEL not in ('Campus') and a.TBX_PROD_CD in ('2018_WDTC_ORL_RTD_DRC_PD_UPG_OUTSIDE_GC1_V3_558', '2018_WDTC_ORL_RTD_ANNUAL_GC1_V3_558'))";
	
	public static final String updatePackageCodePMADB="update pma_wdw.pkg set last_updt = sysdate where TRVL_END_DT > sysdate and pkg_cd in (?)";
	
	public static final String getpackageDetailasQuery = "Select PBL_DATE, GT_CODE, ACTION, CHANNEL from SBC.PRODUCTBUILDERLOG Where GT_CODE=?";
	public static final String getchanelsObjQuery="Select CHANNEL, CHANNEL_ID, ISINCLUDED from SBC.SALES_CHANNEL where CHANNEL=?";
	
	public static final String NO_SPACE_STRING = "";
	public static final String DOUBLE_QUOTE_STRING = "\"";
	public static final String REPORT_FILE_EXTENSION = ".csv";
	public static final String PBL_RETMSG = "PBL_RETMSG";
	public static final String ACTION = "ACTION";
	public static final String CHANNEL = "CHANNEL";
	public static final String GT_CODE = "GT_CODE";
	public static final String PBL_DATE = "PBL_DATE";
	public static final String COMMA_STRING = ",";
	public static final String ISINCLUDED = "ISINCLUDED";
	
	public static final String ALL_PACKAGES_FNAME = "Package_Details";
	public static final String CHANNEL_FNAME = "Channels";
	public static final String REJECTED_PACKAGES_FNAME = "Rejected_Packages";
	


}
