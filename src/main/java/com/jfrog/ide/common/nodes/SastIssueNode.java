package com.jfrog.ide.common.nodes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jfrog.ide.common.nodes.subentities.FindingInfo;
import com.jfrog.ide.common.nodes.subentities.Severity;
import com.jfrog.ide.common.nodes.subentities.SourceCodeScanType;
import lombok.Getter;

@Getter
public class SastIssueNode extends FileIssueNode {
    @JsonProperty()
    private FindingInfo[][] codeFlows;

    // Empty constructor for deserialization
    @SuppressWarnings("unused")
    private SastIssueNode() {
    }

    public SastIssueNode(String name, String filePath, int rowStart, int colStart, int rowEnd, int colEnd, String reason, String lineSnippet, FindingInfo[][] codeFlows, Severity severity, String ruleID) {
        super(name, filePath, rowStart, colStart, rowEnd, colEnd, reason, lineSnippet, SourceCodeScanType.SAST, severity, ruleID);
        this.codeFlows = codeFlows;
    }
}
