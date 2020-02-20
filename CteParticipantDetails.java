package com.fedex.breco.insurance.cte.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class CteParticipantDetails.
 */
@Entity
@Table(name = "CTE_PARTICIPANT_DETAIL")
public class CteParticipantDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cte participant id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CTE_PTCP_SEQ")
	@SequenceGenerator(name = "CTE_PTCP_SEQ", sequenceName = "CTE_PTCP_SEQ", allocationSize = 1)
	@Column(name = "ISQN_CD", columnDefinition = "SEQUENCE GENERATED VALUE")
	private Long cteParticipantId;

	/** The cte identity master. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ISQN_MSTR_CD", nullable = false)
	private CteIdentityMaster cteIdentityMaster;

	/** The cte code. */
	@Column(name = "CT_E_CD", columnDefinition = "CONHECIMENTO DE TRANSPORTE ELETRONICO")
	private String cteCode;

	/** The recipient address country code. */
	@Column(name = "RECP_ADDR_CNTRY_CD", columnDefinition = "DEST_ENDERDEST_CPAIS")
	private String recipientAddressCountryCode;

	/** The recipient address city code. */
	@Column(name = "RECP_ADDR_CTY_CD", columnDefinition = "DEST_ENDERDEST_CMUN")
	private String recipientAddressCityCode;

	/** The recipient address number. */
	@Column(name = "RECP_ADDR_NBR", columnDefinition = "DEST_ENDERDEST_NRO")
	private String recipientAddressNumber;

	/** The recipient address state abbreviation. */
	@Column(name = "RECP_ADDR_ST_ABBR_TXT", columnDefinition = "DEST_ENDERDEST_UF")
	private String recipientAddressStateAbbreviation;

	/** The recipient street address. */
	@Column(name = "RECP_ADDR_STR_TXT", columnDefinition = "DEST_ENDERDEST_XLGR")
	private String recipientStreetAddress;

	/** The recipient address zip code. */
	@Column(name = "RECP_ADDR_ZIP_CD", columnDefinition = "DEST_ENDERDEST_CEP")
	private String recipientAddressZipCode;

	/** The recipient country name. */
	@Column(name = "RECP_CNTRY_NM_TXT", columnDefinition = "DEST_ENDERDEST_XPAIS")
	private String recipientCountryName;

	/** The recipientcorporate name. */
	@Column(name = "RECP_CORP_NM", columnDefinition = "DEST_XNOME")
	private String recipientCorporateName;

	/** The recipient city name. */
	@Column(name = "RECP_CTY_NM_TXT", columnDefinition = "DEST_ENDERDEST_XMUN")
	private String recipientCityName;

	/** The recipient fedex tax identity social number. */
	@Column(name = "RECP_FED_TAX_IDNTY_SO_NBR", columnDefinition = "DEST_CPF")
	private String recipientFedexTaxIdentitySocialNumber;

	/** The recipient neighbourhood address. */
	@Column(name = "RECP_NBRHD_ADDR_TXT", columnDefinition = "DEST_ENDERDEST_XBAIRRO")
	private String recipientNeighbourhoodAddress;

	/** The recipient state tax number. */
	@Column(name = "RECP_ST_TAX_NBR", columnDefinition = "DEST_IE")
	private String recipientStateTaxNumber;

	/** The shipper address country code. */
	@Column(name = "SHPR_ADDR_CNTRY_CD", columnDefinition = "REM_ENDERREME_CPAIS")
	private String shipperAddressCountryCode;

	/** The shipper address city code. */
	@Column(name = "SHPR_ADDR_CTY_CD", columnDefinition = "REM_ENDERREME_CMUN")
	private String shipperAddressCityCode;

	/** The shipper address number. */
	@Column(name = "SHPR_ADDR_NBR", columnDefinition = "REM_ENDERREME_NRO")
	private String shipperAddressNumber;

	/** The shipper street address. */
	@Column(name = "SHPR_ADDR_STR_TXT", columnDefinition = "REM_ENDERREME_XLGR")
	private String shipperStreetAddress;

	/** The shipper address zip code. */
	@Column(name = "SHPR_ADDR_ZIP_CD", columnDefinition = "REM_ENDERREME_CEP")
	private String shipperAddressZipCode;

	/** The shopper country name. */
	@Column(name = "SHPR_CNTRY_NM_TXT", columnDefinition = "REM_ENDERREME_XPAIS")
	private String shopperCountryName;

	/** The shipper corporate name. */
	@Column(name = "SHPR_CORP_NM", columnDefinition = "REM_XNOME")
	private String shipperCorporateName;

	/** The shipper city name. */
	@Column(name = "SHPR_CTY_NM_TXT", columnDefinition = "REM_ENDERREME_XMUN")
	private String shipperCityName;

	/** The shipper email. */
	@Column(name = "SHPR_EMAL_ADDR_TXT", columnDefinition = "REM_EMAIL")
	private String shipperEmail;

	/** The shipper neighbourhood address. */
	@Column(name = "SHPR_NBRHD_ADDR_TXT", columnDefinition = "REM_ENDERREME_XBAIRRO")
	private String shipperNeighbourhoodAddress;

	/** The shipper state abbreviation. */
	@Column(name = "SHPR_ST_ABBRN_TXT", columnDefinition = "REM_ENDERREME_UF")
	private String shipperStateAbbreviation;

	/** The shipper state tax number. */
	@Column(name = "SHPR_ST_TAX_NBR", columnDefinition = "REM_IE")
	private String shipperStateTaxNumber;

	/** The sender address number. */
	@Column(name = "SNDR_ADDR_NBR", columnDefinition = "EMIT_ENDEREMIT_NRO")
	private String senderAddressNumber;

	/** The sender street address. */
	@Column(name = "SNDR_ADDR_STR_TXT", columnDefinition = "EMIT_ENDEREMIT_XLGR")
	private String senderStreetAddress;

	/** The sender address zip code. */
	@Column(name = "SNDR_ADDR_ZIP_CD", columnDefinition = "EMIT_ENDEREMIT_CEP")
	private String senderAddressZipCode;

	/** The sender corporate name. */
	@Column(name = "SNDR_CORP_NM", columnDefinition = "EMIT_XNOME")
	private String senderCorporateName;

	/** The sender city code. */
	@Column(name = "SNDR_CTY_CD", columnDefinition = "EMIT_ENDEREMIT_CMUN")
	private String senderCityCode;

	/** The sender city name. */
	@Column(name = "SNDR_CTY_NM_TXT", columnDefinition = "EMIT_ENDEREMIT_XMUN")
	private String senderCityName;

	/** The sender neibourhood address. */
	@Column(name = "SNDR_NBRHD_ADDR_TXT", columnDefinition = "EMIT_ENDEREMIT_XBAIRRO")
	private String senderNeibourhoodAddress;

	/** The sender state abbreviation. */
	@Column(name = "SNDR_ST_ABBRN_TXT", columnDefinition = "EMIT_ENDEREMIT_UF")
	private String senderStateAbbreviation;

	/** The sender state tax number. */
	@Column(name = "SNDR_ST_TAX_NBR", columnDefinition = "EMIT_IE")
	private String senderStateTaxNumber;

	/** The sender tax id. */
	@Column(name = "SNDR_TAX_ID", columnDefinition = "EMIT_CNPJ")
	private String senderTaxId;

	/** The sender phone number. */
	@Column(name = "SNDR_TELE_NBR", columnDefinition = "EMIT_ENDEREMIT_FONE")
	private String senderPhoneNumber;

	/** The tax id number. */
	@Column(name = "SHPR_TAX_ID_NBR", columnDefinition = "REM_CNPJ")
	private String taxIdNumber;

	/** The creation date. */
	@Column(name = "CREATE_DT", columnDefinition = "CREATE_DT")
	private Date creationDate;

	/** The last modification date. */
	@Column(name = "MODFY_DT", columnDefinition = "MODFY_DT")
	private Date lastModificationDate;

	@Column(name = "RECP_TAX_ID", columnDefinition = "RECP_TAX_ID") // ADDED for TMS
	private String recpTaxIdNum;

	/**
	 * Gets the cte participant id.
	 *
	 * @return the cte participant id
	 */
	public Long getCteParticipantId() {
		return cteParticipantId;
	}

	/**
	 * Sets the cte participant id.
	 *
	 * @param cteParticipantId the new cte participant id
	 */
	public void setCteParticipantId(Long cteParticipantId) {
		this.cteParticipantId = cteParticipantId;
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
	 * Gets the recipient address country code.
	 *
	 * @return the recipient address country code
	 */
	public String getRecipientAddressCountryCode() {
		return recipientAddressCountryCode;
	}

	/**
	 * Sets the recipient address country code.
	 *
	 * @param recipientAddressCountryCode the new recipient address country code
	 */
	public void setRecipientAddressCountryCode(String recipientAddressCountryCode) {
		this.recipientAddressCountryCode = recipientAddressCountryCode;
	}

	/**
	 * Gets the recipient address city code.
	 *
	 * @return the recipient address city code
	 */
	public String getRecipientAddressCityCode() {
		return recipientAddressCityCode;
	}

	/**
	 * Sets the recipient address city code.
	 *
	 * @param recipientAddressCityCode the new recipient address city code
	 */
	public void setRecipientAddressCityCode(String recipientAddressCityCode) {
		this.recipientAddressCityCode = recipientAddressCityCode;
	}

	/**
	 * Gets the recipient address number.
	 *
	 * @return the recipient address number
	 */
	public String getRecipientAddressNumber() {
		return recipientAddressNumber;
	}

	/**
	 * Sets the recipient address number.
	 *
	 * @param recipientAddressNumber the new recipient address number
	 */
	public void setRecipientAddressNumber(String recipientAddressNumber) {
		this.recipientAddressNumber = recipientAddressNumber;
	}

	/**
	 * Gets the recipient address state abbreviation.
	 *
	 * @return the recipient address state abbreviation
	 */
	public String getRecipientAddressStateAbbreviation() {
		return recipientAddressStateAbbreviation;
	}

	/**
	 * Sets the recipient address state abbreviation.
	 *
	 * @param recipientAddressStateAbbreviation the new recipient address state
	 *                                          abbreviation
	 */
	public void setRecipientAddressStateAbbreviation(String recipientAddressStateAbbreviation) {
		this.recipientAddressStateAbbreviation = recipientAddressStateAbbreviation;
	}

	/**
	 * Gets the recipient street address.
	 *
	 * @return the recipient street address
	 */
	public String getRecipientStreetAddress() {
		return recipientStreetAddress;
	}

	/**
	 * Sets the recipient street address.
	 *
	 * @param recipientStreetAddress the new recipient street address
	 */
	public void setRecipientStreetAddress(String recipientStreetAddress) {
		this.recipientStreetAddress = recipientStreetAddress;
	}

	/**
	 * Gets the recipient address zip code.
	 *
	 * @return the recipient address zip code
	 */
	public String getRecipientAddressZipCode() {
		return recipientAddressZipCode;
	}

	/**
	 * Sets the recipient address zip code.
	 *
	 * @param recipientAddressZipCode the new recipient address zip code
	 */
	public void setRecipientAddressZipCode(String recipientAddressZipCode) {
		this.recipientAddressZipCode = recipientAddressZipCode;
	}

	/**
	 * Gets the recipient country name.
	 *
	 * @return the recipient country name
	 */
	public String getRecipientCountryName() {
		return recipientCountryName;
	}

	/**
	 * Sets the recipient country name.
	 *
	 * @param recipientCountryName the new recipient country name
	 */
	public void setRecipientCountryName(String recipientCountryName) {
		this.recipientCountryName = recipientCountryName;
	}

	/**
	 * Gets the recipient corporate name.
	 *
	 * @return the recipient corporate name
	 */
	public String getRecipientCorporateName() {
		return recipientCorporateName;
	}

	/**
	 * Sets the recipient corporate name.
	 *
	 * @param recipientCorporateName the new recipient corporate name
	 */
	public void setRecipientCorporateName(String recipientCorporateName) {
		this.recipientCorporateName = recipientCorporateName;
	}

	/**
	 * Gets the recipient city name.
	 *
	 * @return the recipient city name
	 */
	public String getRecipientCityName() {
		return recipientCityName;
	}

	/**
	 * Sets the recipient city name.
	 *
	 * @param recipientCityName the new recipient city name
	 */
	public void setRecipientCityName(String recipientCityName) {
		this.recipientCityName = recipientCityName;
	}

	/**
	 * Gets the recipient fedex tax identity social number.
	 *
	 * @return the recipient fedex tax identity social number
	 */
	public String getRecipientFedexTaxIdentitySocialNumber() {
		return recipientFedexTaxIdentitySocialNumber;
	}

	/**
	 * Sets the recipient fedex tax identity social number.
	 *
	 * @param recipientFedexTaxIdentitySocialNumber the new recipient fedex tax
	 *                                              identity social number
	 */
	public void setRecipientFedexTaxIdentitySocialNumber(String recipientFedexTaxIdentitySocialNumber) {
		this.recipientFedexTaxIdentitySocialNumber = recipientFedexTaxIdentitySocialNumber;
	}

	/**
	 * Gets the recipient neighbourhood address.
	 *
	 * @return the recipient neighbourhood address
	 */
	public String getRecipientNeighbourhoodAddress() {
		return recipientNeighbourhoodAddress;
	}

	/**
	 * Sets the recipient neighbourhood address.
	 *
	 * @param recipientNeighbourhoodAddress the new recipient neighbourhood address
	 */
	public void setRecipientNeighbourhoodAddress(String recipientNeighbourhoodAddress) {
		this.recipientNeighbourhoodAddress = recipientNeighbourhoodAddress;
	}

	/**
	 * Gets the recipient state tax number.
	 *
	 * @return the recipient state tax number
	 */
	public String getRecipientStateTaxNumber() {
		return recipientStateTaxNumber;
	}

	/**
	 * Sets the recipient state tax number.
	 *
	 * @param recipientStateTaxNumber the new recipient state tax number
	 */
	public void setRecipientStateTaxNumber(String recipientStateTaxNumber) {
		this.recipientStateTaxNumber = recipientStateTaxNumber;
	}

	/**
	 * Gets the shipper address country code.
	 *
	 * @return the shipper address country code
	 */
	public String getShipperAddressCountryCode() {
		return shipperAddressCountryCode;
	}

	/**
	 * Sets the shipper address country code.
	 *
	 * @param shipperAddressCountryCode the new shipper address country code
	 */
	public void setShipperAddressCountryCode(String shipperAddressCountryCode) {
		this.shipperAddressCountryCode = shipperAddressCountryCode;
	}

	/**
	 * Gets the shipper address city code.
	 *
	 * @return the shipper address city code
	 */
	public String getShipperAddressCityCode() {
		return shipperAddressCityCode;
	}

	/**
	 * Sets the shipper address city code.
	 *
	 * @param shipperAddressCityCode the new shipper address city code
	 */
	public void setShipperAddressCityCode(String shipperAddressCityCode) {
		this.shipperAddressCityCode = shipperAddressCityCode;
	}

	/**
	 * Gets the shipper address number.
	 *
	 * @return the shipper address number
	 */
	public String getShipperAddressNumber() {
		return shipperAddressNumber;
	}

	/**
	 * Sets the shipper address number.
	 *
	 * @param shipperAddressNumber the new shipper address number
	 */
	public void setShipperAddressNumber(String shipperAddressNumber) {
		this.shipperAddressNumber = shipperAddressNumber;
	}

	/**
	 * Gets the shipper street address.
	 *
	 * @return the shipper street address
	 */
	public String getShipperStreetAddress() {
		return shipperStreetAddress;
	}

	/**
	 * Sets the shipper street address.
	 *
	 * @param shipperStreetAddress the new shipper street address
	 */
	public void setShipperStreetAddress(String shipperStreetAddress) {
		this.shipperStreetAddress = shipperStreetAddress;
	}

	/**
	 * Gets the shipper address zip code.
	 *
	 * @return the shipper address zip code
	 */
	public String getShipperAddressZipCode() {
		return shipperAddressZipCode;
	}

	/**
	 * Sets the shipper address zip code.
	 *
	 * @param shipperAddressZipCode the new shipper address zip code
	 */
	public void setShipperAddressZipCode(String shipperAddressZipCode) {
		this.shipperAddressZipCode = shipperAddressZipCode;
	}

	/**
	 * Gets the shopper country name.
	 *
	 * @return the shopper country name
	 */
	public String getShopperCountryName() {
		return shopperCountryName;
	}

	/**
	 * Sets the shopper country name.
	 *
	 * @param shopperCountryName the new shopper country name
	 */
	public void setShopperCountryName(String shopperCountryName) {
		this.shopperCountryName = shopperCountryName;
	}

	/**
	 * Gets the shipper corporate name.
	 *
	 * @return the shipper corporate name
	 */
	public String getShipperCorporateName() {
		return shipperCorporateName;
	}

	/**
	 * Sets the shipper corporate name.
	 *
	 * @param shipperCorporateName the new shipper corporate name
	 */
	public void setShipperCorporateName(String shipperCorporateName) {
		this.shipperCorporateName = shipperCorporateName;
	}

	/**
	 * Gets the shipper city name.
	 *
	 * @return the shipper city name
	 */
	public String getShipperCityName() {
		return shipperCityName;
	}

	/**
	 * Sets the shipper city name.
	 *
	 * @param shipperCityName the new shipper city name
	 */
	public void setShipperCityName(String shipperCityName) {
		this.shipperCityName = shipperCityName;
	}

	/**
	 * Gets the shipper email.
	 *
	 * @return the shipper email
	 */
	public String getShipperEmail() {
		return shipperEmail;
	}

	/**
	 * Sets the shipper email.
	 *
	 * @param shipperEmail the new shipper email
	 */
	public void setShipperEmail(String shipperEmail) {
		this.shipperEmail = shipperEmail;
	}

	/**
	 * Gets the shipper neighbourhood address.
	 *
	 * @return the shipper neighbourhood address
	 */
	public String getShipperNeighbourhoodAddress() {
		return shipperNeighbourhoodAddress;
	}

	/**
	 * Sets the shipper neighbourhood address.
	 *
	 * @param shipperNeighbourhoodAddress the new shipper neighbourhood address
	 */
	public void setShipperNeighbourhoodAddress(String shipperNeighbourhoodAddress) {
		this.shipperNeighbourhoodAddress = shipperNeighbourhoodAddress;
	}

	/**
	 * Gets the shipper state abbreviation.
	 *
	 * @return the shipper state abbreviation
	 */
	public String getShipperStateAbbreviation() {
		return shipperStateAbbreviation;
	}

	/**
	 * Sets the shipper state abbreviation.
	 *
	 * @param shipperStateAbbreviation the new shipper state abbreviation
	 */
	public void setShipperStateAbbreviation(String shipperStateAbbreviation) {
		this.shipperStateAbbreviation = shipperStateAbbreviation;
	}

	/**
	 * Gets the shipper state tax number.
	 *
	 * @return the shipper state tax number
	 */
	public String getShipperStateTaxNumber() {
		return shipperStateTaxNumber;
	}

	/**
	 * Sets the shipper state tax number.
	 *
	 * @param shipperStateTaxNumber the new shipper state tax number
	 */
	public void setShipperStateTaxNumber(String shipperStateTaxNumber) {
		this.shipperStateTaxNumber = shipperStateTaxNumber;
	}

	/**
	 * Gets the sender address number.
	 *
	 * @return the sender address number
	 */
	public String getSenderAddressNumber() {
		return senderAddressNumber;
	}

	/**
	 * Sets the sender address number.
	 *
	 * @param senderAddressNumber the new sender address number
	 */
	public void setSenderAddressNumber(String senderAddressNumber) {
		this.senderAddressNumber = senderAddressNumber;
	}

	/**
	 * Gets the sender street address.
	 *
	 * @return the sender street address
	 */
	public String getSenderStreetAddress() {
		return senderStreetAddress;
	}

	/**
	 * Sets the sender street address.
	 *
	 * @param senderStreetAddress the new sender street address
	 */
	public void setSenderStreetAddress(String senderStreetAddress) {
		this.senderStreetAddress = senderStreetAddress;
	}

	/**
	 * Gets the sender address zip code.
	 *
	 * @return the sender address zip code
	 */
	public String getSenderAddressZipCode() {
		return senderAddressZipCode;
	}

	/**
	 * Sets the sender address zip code.
	 *
	 * @param senderAddressZipCode the new sender address zip code
	 */
	public void setSenderAddressZipCode(String senderAddressZipCode) {
		this.senderAddressZipCode = senderAddressZipCode;
	}

	/**
	 * Gets the sender corporate name.
	 *
	 * @return the sender corporate name
	 */
	public String getSenderCorporateName() {
		return senderCorporateName;
	}

	/**
	 * Sets the sender corporate name.
	 *
	 * @param senderCorporateName the new sender corporate name
	 */
	public void setSenderCorporateName(String senderCorporateName) {
		this.senderCorporateName = senderCorporateName;
	}

	/**
	 * Gets the sender city code.
	 *
	 * @return the sender city code
	 */
	public String getSenderCityCode() {
		return senderCityCode;
	}

	/**
	 * Sets the sender city code.
	 *
	 * @param senderCityCode the new sender city code
	 */
	public void setSenderCityCode(String senderCityCode) {
		this.senderCityCode = senderCityCode;
	}

	/**
	 * Gets the sender city name.
	 *
	 * @return the sender city name
	 */
	public String getSenderCityName() {
		return senderCityName;
	}

	/**
	 * Sets the sender city name.
	 *
	 * @param senderCityName the new sender city name
	 */
	public void setSenderCityName(String senderCityName) {
		this.senderCityName = senderCityName;
	}

	/**
	 * Gets the sender neibourhood address.
	 *
	 * @return the sender neibourhood address
	 */
	public String getSenderNeibourhoodAddress() {
		return senderNeibourhoodAddress;
	}

	/**
	 * Sets the sender neibourhood address.
	 *
	 * @param senderNeibourhoodAddress the new sender neibourhood address
	 */
	public void setSenderNeibourhoodAddress(String senderNeibourhoodAddress) {
		this.senderNeibourhoodAddress = senderNeibourhoodAddress;
	}

	/**
	 * Gets the sender state abbreviation.
	 *
	 * @return the sender state abbreviation
	 */
	public String getSenderStateAbbreviation() {
		return senderStateAbbreviation;
	}

	/**
	 * Sets the sender state abbreviation.
	 *
	 * @param senderStateAbbreviation the new sender state abbreviation
	 */
	public void setSenderStateAbbreviation(String senderStateAbbreviation) {
		this.senderStateAbbreviation = senderStateAbbreviation;
	}

	/**
	 * Gets the sender state tax number.
	 *
	 * @return the sender state tax number
	 */
	public String getSenderStateTaxNumber() {
		return senderStateTaxNumber;
	}

	/**
	 * Sets the sender state tax number.
	 *
	 * @param senderStateTaxNumber the new sender state tax number
	 */
	public void setSenderStateTaxNumber(String senderStateTaxNumber) {
		this.senderStateTaxNumber = senderStateTaxNumber;
	}

	/**
	 * Gets the sender tax id.
	 *
	 * @return the sender tax id
	 */
	public String getSenderTaxId() {
		return senderTaxId;
	}

	/**
	 * Sets the sender tax id.
	 *
	 * @param senderTaxId the new sender tax id
	 */
	public void setSenderTaxId(String senderTaxId) {
		this.senderTaxId = senderTaxId;
	}

	/**
	 * Gets the sender phone number.
	 *
	 * @return the sender phone number
	 */
	public String getSenderPhoneNumber() {
		return senderPhoneNumber;
	}

	/**
	 * Sets the sender phone number.
	 *
	 * @param senderPhoneNumber the new sender phone number
	 */
	public void setSenderPhoneNumber(String senderPhoneNumber) {
		this.senderPhoneNumber = senderPhoneNumber;
	}

	/**
	 * Gets the tax id number.
	 *
	 * @return the tax id number
	 */
	public String getTaxIdNumber() {
		return taxIdNumber;
	}

	/**
	 * Sets the tax id number.
	 *
	 * @param taxIdNumber the new tax id number
	 */
	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
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
		return "CteParticipantDetails [cteParticipantId=" + cteParticipantId + ", cteCode=" + cteCode
				+ ", recipientAddressCountryCode=" + recipientAddressCountryCode + ", recipientAddressCityCode="
				+ recipientAddressCityCode + ", recipientAddressNumber=" + recipientAddressNumber
				+ ", recipientAddressStateAbbreviation=" + recipientAddressStateAbbreviation
				+ ", recipientStreetAddress=" + recipientStreetAddress + ", recipientAddressZipCode="
				+ recipientAddressZipCode + ", recipientCountryName=" + recipientCountryName
				+ ", recipientCorporateName=" + recipientCorporateName + ", recipientCityName=" + recipientCityName
				+ ", recipientFedexTaxIdentitySocialNumber=" + recipientFedexTaxIdentitySocialNumber
				+ ", recipientNeighbourhoodAddress=" + recipientNeighbourhoodAddress + ", recipientStateTaxNumber="
				+ recipientStateTaxNumber + ", shipperAddressCountryCode=" + shipperAddressCountryCode
				+ ", shipperAddressCityCode=" + shipperAddressCityCode + ", shipperAddressNumber="
				+ shipperAddressNumber + ", shipperStreetAddress=" + shipperStreetAddress + ", shipperAddressZipCode="
				+ shipperAddressZipCode + ", shopperCountryName=" + shopperCountryName + ", shipperCorporateName="
				+ shipperCorporateName + ", shipperCityName=" + shipperCityName + ", shipperEmail=" + shipperEmail
				+ ", shipperNeighbourhoodAddress=" + shipperNeighbourhoodAddress + ", shipperStateAbbreviation="
				+ shipperStateAbbreviation + ", shipperStateTaxNumber=" + shipperStateTaxNumber
				+ ", senderAddressNumber=" + senderAddressNumber + ", senderStreetAddress=" + senderStreetAddress
				+ ", senderAddressZipCode=" + senderAddressZipCode + ", senderCorporateName=" + senderCorporateName
				+ ", senderCityCode=" + senderCityCode + ", senderCityName=" + senderCityName
				+ ", senderNeibourhoodAddress=" + senderNeibourhoodAddress + ", senderStateAbbreviation="
				+ senderStateAbbreviation + ", senderStateTaxNumber=" + senderStateTaxNumber + ", senderTaxId="
				+ senderTaxId + ", senderPhoneNumber=" + senderPhoneNumber + ", taxIdNumber=" + taxIdNumber
				+ ", creationDate=" + creationDate + ", lastModificationDate=" + lastModificationDate + "]";
	}

	public String getRecpTaxIdNum() {
		return recpTaxIdNum;
	}

	public void setRecpTaxIdNum(String recpTaxIdNum) {
		this.recpTaxIdNum = recpTaxIdNum;
	}

}
