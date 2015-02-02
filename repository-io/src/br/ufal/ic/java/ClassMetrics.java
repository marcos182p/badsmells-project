package br.ufal.ic.java;

import org.apache.commons.lang.math.NumberUtils;

public class ClassMetrics {
	

	private String className;
	
	private Double ACAIC;
	private Double ACMIC;
	private Double AID;
	private Double ANA;
	private Double CLD;
	private Double DCAEC;
	private Double DCC;
	private Double DCMEC;
	private Double DIT;
	private Double DSC;
	private Double ICHClass;
	private Double IR;
	private Double LCOM1;
	private Double LCOM2;
	private Double LCOM5;
	private Double LOC;
	private Double MLOCsum;
	private Double McCabe;
	private Double NAD;
	private Double NADExtended;
	private Double NCM;
	private Double NMA;
	private Double NMD;
	private Double NMDExtended;
	private Double NMI;
	private Double NMO;
	private Double NOA;
	private Double NOC;
	private Double NOD;
	private Double NOF;
	private Double NOH;
	private Double NOM;
	private Double NOP;
	private Double NOPM;
	private Double NOParam;
	private Double NOTC;
	private Double NOTI;
	private Double RFC_New;
	private Double SIX;
	private Double VGsum;
	private Double WMC1;
	private Double WMC_New;
	private Double cohesionAttributes;
	private Double connectivity;
	
	public ClassMetrics(String[] metrics) {
		className = metrics[44];
		
		ACAIC = toDouble(metrics[0]);
		ACMIC = toDouble(metrics[1]);
		AID = toDouble(metrics[2]);
		ANA = toDouble(metrics[3]);
		CLD = toDouble(metrics[4]);
		DCAEC = toDouble(metrics[5]);
		DCC = toDouble(metrics[6]);
		DCMEC = toDouble(metrics[7]);
		DIT = toDouble(metrics[8]);
		DSC = toDouble(metrics[9]);
		ICHClass = toDouble(metrics[10]);
		IR = toDouble(metrics[11]);
		LCOM1 = toDouble(metrics[12]);
		LCOM2 = toDouble(metrics[13]);
		LCOM5 = toDouble(metrics[14]);
		LOC = toDouble(metrics[15]);
		MLOCsum = toDouble(metrics[16]);
		McCabe = toDouble(metrics[17]);
		NAD = toDouble(metrics[18]);
		NADExtended = toDouble(metrics[19]);
		NCM = toDouble(metrics[20]);
		NMA = toDouble(metrics[21]);
		NMD = toDouble(metrics[22]);
		NMDExtended = toDouble(metrics[23]);
		NMI = toDouble(metrics[24]);
		NMO = toDouble(metrics[25]);
		NOA = toDouble(metrics[26]);
		NOC = toDouble(metrics[27]);
		NOD = toDouble(metrics[28]);
		NOF = toDouble(metrics[29]);
		NOH = toDouble(metrics[30]);
		NOM = toDouble(metrics[31]);
		NOP = toDouble(metrics[32]);
		NOPM = toDouble(metrics[33]);
		NOParam = toDouble(metrics[34]);
		NOTC = toDouble(metrics[35]);
		NOTI = toDouble(metrics[36]);
		RFC_New = toDouble(metrics[37]);
		SIX = toDouble(metrics[38]);
		VGsum = toDouble(metrics[39]);
		WMC1 = toDouble(metrics[40]);
		WMC_New = toDouble(metrics[41]);
		cohesionAttributes = toDouble(metrics[42]);
		connectivity = toDouble(metrics[43].trim());
		
	}
	
	private Double toDouble(String value) {
		value = value.trim();
		return NumberUtils.isNumber(value) ? Double.parseDouble(value): Double.MIN_VALUE;
	}

	public String getClassName() {
		return className;
	}

	public Double getACAIC() {
		return ACAIC;
	}

	public Double getACMIC() {
		return ACMIC;
	}

	public Double getAID() {
		return AID;
	}

	public Double getANA() {
		return ANA;
	}

	public Double getCLD() {
		return CLD;
	}

	public Double getDCAEC() {
		return DCAEC;
	}

	public Double getDCC() {
		return DCC;
	}

	public Double getDCMEC() {
		return DCMEC;
	}

	public Double getDIT() {
		return DIT;
	}

	public Double getDSC() {
		return DSC;
	}

	public Double getICHClass() {
		return ICHClass;
	}

	public Double getIR() {
		return IR;
	}

	public Double getLCOM1() {
		return LCOM1;
	}

	public Double getLCOM2() {
		return LCOM2;
	}

	public Double getLCOM5() {
		return LCOM5;
	}

	public Double getLOC() {
		return LOC;
	}

	public Double getMLOCsum() {
		return MLOCsum;
	}

	public Double getMcCabe() {
		return McCabe;
	}

	public Double getNAD() {
		return NAD;
	}

	public Double getNADExtended() {
		return NADExtended;
	}

	public Double getNCM() {
		return NCM;
	}

	public Double getNMA() {
		return NMA;
	}

	public Double getNMD() {
		return NMD;
	}

	public Double getNMDExtended() {
		return NMDExtended;
	}

	public Double getNMI() {
		return NMI;
	}

	public Double getNMO() {
		return NMO;
	}

	public Double getNOA() {
		return NOA;
	}

	public Double getNOC() {
		return NOC;
	}

	public Double getNOD() {
		return NOD;
	}

	public Double getNOF() {
		return NOF;
	}

	public Double getNOH() {
		return NOH;
	}

	public Double getNOM() {
		return NOM;
	}

	public Double getNOP() {
		return NOP;
	}

	public Double getNOPM() {
		return NOPM;
	}

	public Double getNOParam() {
		return NOParam;
	}

	public Double getNOTC() {
		return NOTC;
	}

	public Double getNOTI() {
		return NOTI;
	}

	public Double getRFC_New() {
		return RFC_New;
	}

	public Double getSIX() {
		return SIX;
	}

	public Double getVGsum() {
		return VGsum;
	}

	public Double getWMC1() {
		return WMC1;
	}

	public Double getWMC_New() {
		return WMC_New;
	}

	public Double getCohesionAttributes() {
		return cohesionAttributes;
	}

	public Double getConnectivity() {
		return connectivity;
	}

	@Override
	public String toString() {
		return "ClassMetrics [className=" + className + ", ACAIC=" + ACAIC
				+ ", ACMIC=" + ACMIC + ", AID=" + AID + ", ANA=" + ANA
				+ ", CLD=" + CLD + ", DCAEC=" + DCAEC + ", DCC=" + DCC
				+ ", DCMEC=" + DCMEC + ", DIT=" + DIT + ", DSC=" + DSC
				+ ", ICHClass=" + ICHClass + ", IR=" + IR + ", LCOM1=" + LCOM1
				+ ", LCOM2=" + LCOM2 + ", LCOM5=" + LCOM5 + ", LOC=" + LOC
				+ ", MLOCsum=" + MLOCsum + ", McCabe=" + McCabe + ", NAD="
				+ NAD + ", NADExtended=" + NADExtended + ", NCM=" + NCM
				+ ", NMA=" + NMA + ", NMD=" + NMD + ", NMDExtended="
				+ NMDExtended + ", NMI=" + NMI + ", NMO=" + NMO + ", NOA="
				+ NOA + ", NOC=" + NOC + ", NOD=" + NOD + ", NOF=" + NOF
				+ ", NOH=" + NOH + ", NOM=" + NOM + ", NOP=" + NOP + ", NOPM="
				+ NOPM + ", NOParam=" + NOParam + ", NOTC=" + NOTC + ", NOTI="
				+ NOTI + ", RFC_New=" + RFC_New + ", SIX=" + SIX + ", VGsum="
				+ VGsum + ", WMC1=" + WMC1 + ", WMC_New=" + WMC_New
				+ ", cohesionAttributes=" + cohesionAttributes
				+ ", connectivity=" + connectivity + "]";
	}
	
	

}
