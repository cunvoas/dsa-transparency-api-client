package eu.europa.ec.dsa.transparency.model.file;

/**
 * Model representing human resources data.
 */
public record Model09HumanResources(
    String applicability,
    String service,
    String reportingPeriod,
    String section,
    String indicator,
    String scope,
    String value,
    String contextualInformation
) {}