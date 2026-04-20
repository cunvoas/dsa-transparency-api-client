package eu.europa.ec.dsa.transparency.model.file;

/**
 * Model representing own initiative illegal content data.
 */
public record Model05OwnInitiativeIllegal(
    String applicability,
    String service,
    String reportingPeriod,
    String categoryOfIllegalContent,
    String descriptionOfSubCategoryOther,
    String numberOfNoticesReceived,
    String numberOfNoticesReceivedFromTrustedFlaggers,
    String numberOfSpecificItemsOfInformationIncludedInTotalNumberOfNotices,
    String numberOfSpecificItemsOfInformationIncludedInTotalNumberOfNoticesByTrustedFlaggers,
    String medianTimeToTakeAction,
    String medianTimeToTakeActionTrustedFlaggerNotices,
    String numberOfActionsTakenOnBasisOfLaw,
    String numberOfActionsTakenOnBasisOfLawTrustedFlaggerNotices,
    String numberOfActionsTakenOnBasisOfTermsAndConditions,
    String numberOfActionsTakenOnBasisOfTermsAndConditionsTrustedFlaggerNotices,
    String contextualInfoNumberOfNoticesReceived,
    String contextualInfoNumberOfNoticesReceivedFromTrustedFlaggers,
    String contextualInfoNumberOfSpecificItemsOfInformationIncludedInTotalNumberOfNotices,
    String contextualInfoNumberOfSpecificItemsOfInformationIncludedInTotalNumberOfNoticesByTrustedFlaggers,
    String contextualInfoMedianTimeToTakeAction,
    String contextualInfoMedianTimeToTakeActionTrustedFlaggerNotices,
    String contextualInfoNumberOfActionsTakenOnBasisOfLaw,
    String contextualInfoNumberOfActionsTakenOnBasisOfLawTrustedFlaggerNotices,
    String contextualInfoNumberOfActionsTakenOnBasisOfTermsAndConditions,
    String contextualInfoNumberOfActionsTakenOnBasisOfTermsAndConditionsTrustedFlaggerNotices
) {}