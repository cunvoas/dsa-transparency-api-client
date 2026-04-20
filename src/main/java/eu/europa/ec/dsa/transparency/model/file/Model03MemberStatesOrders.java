package eu.europa.ec.dsa.transparency.model.file;

/**
 * Model representing member states orders data.
 */
public record Model03MemberStatesOrders(
    String applicability,
    String service,
    String reportingPeriod,
    String categoryOfIllegalContent,
    String descriptionOfSubCategoryOther,
    String scope,
    String numberOfOrdersToActAgainstIllegalContentReceived,
    String numberOfSpecificItemsOfInformationIncludedInTotalNumberOfOrdersToActAgainstIllegalContent,
    String medianTimeToInformAuthorityOfReceiptOfOrderToActAgainstIllegalContent,
    String medianTimeToGiveEffectToOrderToActAgainstIllegalContent,
    String numberOfOrdersToProvideInformation,
    String medianTimeToInformAuthorityOfReceiptOfOrderToProvideInformation,
    String medianTimeToGiveEffectToOrderToProvideInformation,
    String contextualInfoOnNumberOfOrdersToActAgainstIllegalContentReceived,
    String contextualInfoOnNumberOfSpecificItemsOfInformationIncludedInTotalNumberOfOrdersToActAgainstIllegalContent,
    String contextualInfoOnMedianTimeToInformAuthorityOfReceiptOfOrderToActAgainstIllegalContent,
    String contextualInfoOnMedianTimeToGiveEffectToOrderToActAgainstIllegalContent,
    String contextualInfoOnNumberOfOrdersToProvideInformation,
    String contextualInfoOnMedianTimeToInformAuthorityOfReceiptOfOrderToProvideInformation,
    String contextualInfoOnMedianTimeToGiveEffectToOrderToProvideInformation
) {}