package com.fedex.breco.insurance.cte.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class CteProductDetails.
 */
@Entity
@Table(name = "CTE_PRODUCT_DETAIL")
public class CteProductDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cte participant id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CTE_PROD_SEQ")
	@SequenceGenerator(name = "CTE_PROD_SEQ", sequenceName = "CTE_PROD_SEQ", allocationSize = 1)
	@Column(name = "ISQN_CD", columnDefinition = "SEQUENCE GENERATED VALUE")
	private Long cteProductId;

	/** The cte identity master. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ISQN_MSTR_CD")
	private CteIdentityMaster cteIdentityMaster;

	/** The nota fiscal key. */
	@Column(name = "NT_FSCL_CD", columnDefinition = "NFE KEY")
	private String notaFiscalKey;

	/** The cte code. */
	@Column(name = "CT_E_CD", columnDefinition = "CONHECIMENTO DE TRANSPORTE ELETRONICO")
	private String cteCode;

	/** The amount to receive number. */
	@Column(name = "AMT_TO_RECV_NBR", columnDefinition = "VPREST_VREC")
	private Double amountToReceiveNumber;

	/** The cargo measurement type. */
	@Column(name = "CARGO_MEAS_TYPE_DESC", columnDefinition = "INFCTENORM_INFCARGA_INFQ_TPMED")
	private String cargoMeasurementType;

	/** The corporate name. */
	@Column(name = "CORP_NM", columnDefinition = "VPREST_COMP_XNOME")
	private String corporateName;

	/** The other cargo characteristic. */
	@Column(name = "CRGO_CHRST_OTHER_TXT", columnDefinition = "INFCTENORM_INFCARGA_XOUTCAT")
	private String otherCargoCharacteristic;

	/** The cargo ground national registration id. */
	@Column(name = "CRGO_GRND_NATL_REGIS_ID", columnDefinition = "INFCTENORM_INFMODAL_RODO_RNTRC")
	private String cargoGroundNationalRegistrationId;

	/** The cargo quantity number. */
	@Column(name = "CRGO_QTY_NBR", columnDefinition = "INFCTENORM_INFCARGA_INFQ_QCARGA")
	private String cargoQuantityNumber;

	/** The cargo total value number. */
	@Column(name = "CRGO_TOT_VAL_NBR", columnDefinition = "INFCTENORM_INFCARGA_VCARGA")
	private String cargoTotalValueNumber;

	/** The element value number. */
	@Column(name = "ELEM_VAL_NBR", columnDefinition = "VPREST_COMP_VCOMP")
	private String elementValueNumber;

	/** The measurement unit code. */
	@Column(name = "MEAS_UNIT_CD", columnDefinition = "INFCTENORM_INFCARGA_INFQ_CUNID")
	private Integer measurementUnitCode;

	/** The predominant item description. */
	@Column(name = "PRDMT_ITM_DESC", columnDefinition = "INFCTENORM_INFCARGA_PROPRED")
	private String predominantItemDescription;

	/** The transport modal version number. */
	@Column(name = "TRPRT_MDL_VERS_NBR", columnDefinition = "INFCTENORM_INFMODAL_VERSAOMODAL")
	private Double transportModalVersionNumber;

	/** The service total value number. */
	@Column(name = "SVC_TOT_VAL_NBR", columnDefinition = "VPREST_VTPREST")
	private String serviceTotalValueNumber;

	/** The creation date. */
	@Column(name = "CREATE_DT", columnDefinition = "CREATE_DT")
	private Date creationDate;

	/** The last modification date. */
	@Column(name = "MODFY_DT", columnDefinition = "MODFY_DT")
	private Date lastModificationDate;

	/**
	 * Gets the cte product id.
	 *
	 * @return the cte product id
	 */

	@Column(name = "PKG_QTY", columnDefinition = "PKG_QTY")
	private String packageQty;

	@Column(name = "DIM_WGT", columnDefinition = "DIM_WGT")
	private String dimWt;

	@Column(name = "GROSS_WGT", columnDefinition = "GROSS_WGT")
	private String grossWt;

	@Column(name = "CHRG_WGT", columnDefinition = "CHRG_WGT")
	private String chargedWt;

	@Column(name = "VOL_TOT_DESC_NBR", columnDefinition = "VOL_TOT_DESC")
	private String totalVolume;

	public String getPackageQty() {
		return packageQty;
	}

	public void setPackageQty(String packageQty) {
		this.packageQty = packageQty;
	}

	public String getDimWt() {
		return dimWt;
	}

	public void setDimWt(String dimWt) {
		this.dimWt = dimWt;
	}

	public String getGrossWt() {
		return grossWt;
	}

	public void setGrossWt(String grossWt) {
		this.grossWt = grossWt;
	}

	public String getChargedWt() {
		return chargedWt;
	}

	public void setChargedWt(String chargedWt) {
		this.chargedWt = chargedWt;
	}

	public String getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}

	public Long getCteProductId() {
		return cteProductId;
	}

	/**
	 * Sets the cte product id.
	 *
	 * @param cteProductId the new cte product id
	 */
	public void setCteProductId(Long cteProductId) {
		this.cteProductId = cteProductId;
	}

	/**
	 * Gets the cte identity master.
	 *
	 * @return the cte identity master
	 */
	public CteIdentityMaster getCteIdentityMaster() {
		return cteIdentityMaster;
	}

	/**
	 * Sets the cte identity master.
	 *
	 * @param cteIdentityMaster the new cte identity master
	 */
	public void setCteIdentityMaster(CteIdentityMaster cteIdentityMaster) {
		this.cteIdentityMaster = cteIdentityMaster;
	}

	/**
	 * Gets the nota fiscal key.
	 *
	 * @return the nota fiscal key
	 */
	public String getNotaFiscalKey() {
		return notaFiscalKey;
	}

	/**
	 * Sets the nota fiscal key.
	 *
	 * @param notaFiscalKey the new nota fiscal key
	 */
	public void setNotaFiscalKey(String notaFiscalKey) {
		this.notaFiscalKey = notaFiscalKey;
	}

	/**
	 * Gets the cte code.
	 *
	 * @return the cte code
	 */
	public String getCteCode() {
		return cteCode;
	}

	/**
	 * Sets the cte code.
	 *
	 * @param cteCode the new cte code
	 */
	public void setCteCode(String cteCode) {
		this.cteCode = cteCode;
	}

	/**
	 * Gets the amount to receive number.
	 *
	 * @return the amount to receive number
	 */
	public Double getAmountToReceiveNumber() {
		return amountToReceiveNumber;
	}

	/**
	 * Sets the amount to receive number.
	 *
	 * @param amountToReceiveNumber the new amount to receive number
	 */
	public void setAmountToReceiveNumber(Double amountToReceiveNumber) {
		this.amountToReceiveNumber = amountToReceiveNumber;
	}

	/**
	 * Gets the cargo measurement type.
	 *
	 * @return the cargo measurement type
	 */
	public String getCargoMeasurementType() {
		return cargoMeasurementType;
	}

	/**
	 * Sets the cargo measurement type.
	 *
	 * @param cargoMeasurementType the new cargo measurement type
	 */
	public void setCargoMeasurementType(String cargoMeasurementType) {
		this.cargoMeasurementType = cargoMeasurementType;
	}

	/**
	 * Gets the corporate name.
	 *
	 * @return the corporate name
	 */
	public String getCorporateName() {
		return corporateName;
	}

	/**
	 * Sets the corporate name.
	 *
	 * @param corporateName the new corporate name
	 */
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	/**
	 * Gets the other cargo characteristic.
	 *
	 * @return the other cargo characteristic
	 */
	public String getOtherCargoCharacteristic() {
		return otherCargoCharacteristic;
	}

	/**
	 * Sets the other cargo characteristic.
	 *
	 * @param otherCargoCharacteristic the new other cargo characteristic
	 */
	public void setOtherCargoCharacteristic(String otherCargoCharacteristic) {
		this.otherCargoCharacteristic = otherCargoCharacteristic;
	}

	/**
	 * Gets the cargo ground national registration id.
	 *
	 * @return the cargo ground national registration id
	 */
	public String getCargoGroundNationalRegistrationId() {
		return cargoGroundNationalRegistrationId;
	}

	/**
	 * Sets the cargo ground national registration id.
	 *
	 * @param cargoGroundNationalRegistrationId the new cargo ground national
	 *                                          registration id
	 */
	public void setCargoGroundNationalRegistrationId(String cargoGroundNationalRegistrationId) {
		this.cargoGroundNationalRegistrationId = cargoGroundNationalRegistrationId;
	}

	/**
	 * Gets the cargo quantity number.
	 *
	 * @return the cargo quantity number
	 */
	public String getCargoQuantityNumber() {
		return cargoQuantityNumber;
	}

	/**
	 * Sets the cargo quantity number.
	 *
	 * @param cargoQuantityNumber the new cargo quantity number
	 */
	public void setCargoQuantityNumber(String cargoQuantityNumber) {
		this.cargoQuantityNumber = cargoQuantityNumber;
	}

	/**
	 * Gets the cargo total value number.
	 *
	 * @return the cargo total value number
	 */
	public String getCargoTotalValueNumber() {
		return cargoTotalValueNumber;
	}

	/**
	 * Sets the cargo total value number.
	 *
	 * @param cargoTotalValueNumber the new cargo total value number
	 */
	public void setCargoTotalValueNumber(String cargoTotalValueNumber) {
		this.cargoTotalValueNumber = cargoTotalValueNumber;
	}

	/**
	 * Gets the element value number.
	 *
	 * @return the element value number
	 */
	public String getElementValueNumber() {
		return elementValueNumber;
	}

	/**
	 * Sets the element value number.
	 *
	 * @param elementValueNumber the new element value number
	 */
	public void setElementValueNumber(String elementValueNumber) {
		this.elementValueNumber = elementValueNumber;
	}

	/**
	 * Gets the measurement unit code.
	 *
	 * @return the measurement unit code
	 */
	public Integer getMeasurementUnitCode() {
		return measurementUnitCode;
	}

	/**
	 * Sets the measurement unit code.
	 *
	 * @param measurementUnitCode the new measurement unit code
	 */
	public void setMeasurementUnitCode(Integer measurementUnitCode) {
		this.measurementUnitCode = measurementUnitCode;
	}

	/**
	 * Gets the predominant item description.
	 *
	 * @return the predominant item description
	 */
	public String getPredominantItemDescription() {
		return predominantItemDescription;
	}

	/**
	 * Sets the predominant item description.
	 *
	 * @param predominantItemDescription the new predominant item description
	 */
	public void setPredominantItemDescription(String predominantItemDescription) {
		this.predominantItemDescription = predominantItemDescription;
	}

	/**
	 * Gets the transport modal version number.
	 *
	 * @return the transport modal version number
	 */
	public Double getTransportModalVersionNumber() {
		return transportModalVersionNumber;
	}

	/**
	 * Sets the transport modal version number.
	 *
	 * @param transportModalVersionNumber the new transport modal version number
	 */
	public void setTransportModalVersionNumber(Double transportModalVersionNumber) {
		this.transportModalVersionNumber = transportModalVersionNumber;
	}

	/**
	 * Gets the service total value number.
	 *
	 * @return the service total value number
	 */
	public String getServiceTotalValueNumber() {
		return serviceTotalValueNumber;
	}

	/**
	 * Sets the service total value number.
	 *
	 * @param serviceTotalValueNumber the new service total value number
	 */
	public void setServiceTotalValueNumber(String serviceTotalValueNumber) {
		this.serviceTotalValueNumber = serviceTotalValueNumber;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the last modification date.
	 *
	 * @return the last modification date
	 */
	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * Sets the last modification date.
	 *
	 * @param lastModificationDate the new last modification date
	 */
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CteProductDetails [cteProductId=" + cteProductId + ", notaFiscalKey=" + notaFiscalKey + ", cteCode="
				+ cteCode + ", amountToReceiveNumber=" + amountToReceiveNumber + ", cargoMeasurementType="
				+ cargoMeasurementType + ", corporateName=" + corporateName + ", otherCargoCharacteristic="
				+ otherCargoCharacteristic + ", cargoGroundNationalRegistrationId=" + cargoGroundNationalRegistrationId
				+ ", cargoQuantityNumber=" + cargoQuantityNumber + ", cargoTotalValueNumber=" + cargoTotalValueNumber
				+ ", elementValueNumber=" + elementValueNumber + ", measurementUnitCode=" + measurementUnitCode
				+ ", predominantItemDescription=" + predominantItemDescription + ", transportModalVersionNumber="
				+ transportModalVersionNumber + ", serviceTotalValueNumber=" + serviceTotalValueNumber
				+ ", creationDate=" + creationDate + ", lastModificationDate=" + lastModificationDate + "]";
	}

}
