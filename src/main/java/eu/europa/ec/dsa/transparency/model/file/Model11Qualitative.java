package eu.europa.ec.dsa.transparency.model.file;

/**
 * Model representing qualitative data.
 */
public record Model11Qualitative(
    String applicability,
    String service,
    String reportingPeriod,
    String indicator,
    String value
) {}