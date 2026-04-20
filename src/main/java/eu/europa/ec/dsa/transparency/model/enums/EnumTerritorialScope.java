package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @see https://www.iban.com/country-codes
 */
public enum EnumTerritorialScope {

	ALBANIA("AL", "ALB"),
	ANDORRA("AD", "AND"),
	AUSTRIA("AT", "AUT"),
	BELARUS("BY", "BLR"),
	BELGIUM("BE", "BEL"),
	BOSNIA_AND_HERZEGOVINA("BA", "BIH"),
	BULGARIA("BG", "BGR"),
	CHINA("CN", "CHN"),
	CROATIA("HR", "HRV"),
	CYPRUS("CY", "CYP"),
	CZECHIA("CZ", "CZE"),
	DENMARK("DK", "DNK"),
	ESTONIA("EE", "EST"),
	FINLAND("FI", "FIN"),
	FRANCE("FR", "FRA"),
	GERMANY("DE", "DEU"),
	GIBRALTAR("GI", "GIB"),
	GREECE("GR", "GRC"),
	HUNGARY("HU", "HUN"),
	ICELAND("IS", "ISL"),
	IRELAND("IE", "IRL"),
	ITALY("IT", "ITA"),
	LATVIA("LV", "LVA"),
	LIECHTENSTEIN("LI", "LIE"),
	LITHUANIA("LT", "LTU"),
	LUXEMBOURG("LU", "LUX"),
	MALTA("MT", "MLT"),
	MONACO("MC", "MCO"),
	MONTENEGRO("ME", "MNE"),
	NETHERLANDS("NL", "NLD"),
	NORWAY("NO", "NOR"),
	POLAND("PL", "POL"),
	PORTUGAL("PT", "PRT"),
	ROMANIA("RO", "ROU"),
	SAN_MARINO("SM", "SMR"),
	SERBIA("RS", "SRB"),
	SLOVAKIA("SK", "SVK"),
	SLOVENIA("SI", "SVN"),
	SPAIN("ES", "ESP"),
	SWEDEN("SE", "SWE"),
	SWITZERLAND("CH", "CHE"),
	UKRAINE("UA", "UKR"),
	UNITED_KINGDOM("GB", "GBR");


	private final String iso2;
	private final String iso3;
	private EnumTerritorialScope(String iso2, String iso3) {
		this.iso2 = iso2;
		this.iso3 = iso3;
	}

	@JsonValue
	public String getIso2() {
		return this.iso2;
	}
	public String getIso3() {
		return this.iso3;
	}
	public String toString() {
		return this.iso2;
	}
}
