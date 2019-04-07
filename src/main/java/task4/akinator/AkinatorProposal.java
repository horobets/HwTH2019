package task4.akinator;

import java.util.List;

public class AkinatorProposal {
    public AkinatorProposal(String proposalDescription, String proposalTitle, String proposalSubtitle, List<String> proposalAnswers) {
        this.proposalDescription = proposalDescription;
        this.proposalTitle = proposalTitle;
        this.proposalSubtitle = proposalSubtitle;
        this.proposalAnswers = proposalAnswers;
    }

    private String proposalDescription;
    private String proposalTitle;
    private String proposalSubtitle;
    private List<String> proposalAnswers;

    public String getProposalDescription() {
        return proposalDescription;
    }

    public String getProposalTitle() {
        return proposalTitle;
    }

    public String getProposalSubtitle() {
        return proposalSubtitle;
    }

    public List<String> getProposalAnswers() {
        return proposalAnswers;
    }
}
