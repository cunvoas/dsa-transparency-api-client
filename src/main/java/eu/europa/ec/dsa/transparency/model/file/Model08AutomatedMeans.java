package eu.europa.ec.dsa.transparency.model.file;

/**
 * Model representing automated means data.
 */
public record Model08AutomatedMeans(
    String applicability,
    String service,
    String reportingPeriod,
    String section,
    String indicator,
    String scope,
    String value,
    String contextualInformation
) {}