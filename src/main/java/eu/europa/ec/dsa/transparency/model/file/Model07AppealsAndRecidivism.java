package eu.europa.ec.dsa.transparency.model.file;

/**
 * Model representing appeals and recidivism data.
 */
public record Model07AppealsAndRecidivism(
    String applicability,
    String service,
    String reportingPeriod,
    String section,
    String indicator,
    String scope,
    String value,
    String contextualInformation
) {}