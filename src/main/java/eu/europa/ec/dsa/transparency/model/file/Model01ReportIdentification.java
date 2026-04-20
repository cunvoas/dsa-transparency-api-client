package eu.europa.ec.dsa.transparency.model.file;

/**
 * Model representing report identification data.
 *
 * <p>Model representing a row in the 1_report_identification.csv file.
 */
public record Model01ReportIdentification(
    String applicability,
    String service,
    String indicator,
    String value
) {}