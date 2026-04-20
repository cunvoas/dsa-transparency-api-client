package eu.europa.ec.dsa.transparency.model.file;

import java.util.List;

public record ModelDsaFile(
    List<Model01ReportIdentification> sheet01,
    List<Model03MemberStatesOrders> sheet03,
    List<Model05OwnInitiativeIllegal> sheet05,
    List<Model06OwnInitiativeTC> sheet06,
    List<Model07AppealsAndRecidivism> sheet07,
    List<Model08AutomatedMeans> sheet08,
    List<Model09HumanResources> sheet09,
    List<Model10Amar> sheet10,
    List<Model11Qualitative> sheet11
) {}