package eu.europa.ec.dsa.transparency.model.api;

import java.util.List;

/**
 * Model representing a list of statements.
 */
public record ListStatementModel(List<StatementModel> statement) {}
