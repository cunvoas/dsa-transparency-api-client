package eu.europa.ec.dsa.transparency.model.file;

/**
 * Model representing AMAR data.
 */
public record Model10Amar(
    String applicability,
    String service,
    String reportingPeriod,
    String section,
    String indicator,
    String scope,
    String value
) {}