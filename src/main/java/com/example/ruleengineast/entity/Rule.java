package com.example.ruleengineast.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rules")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_name")
    private String ruleName;

    @Lob
    @Column(name = "rule_ast", columnDefinition = "TEXT")
    private String ruleAST;  // JSON string representation of the Node (AST)

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleAST() {
        return ruleAST;
    }

    public void setRuleAST(String ruleAST) {
        this.ruleAST = ruleAST;
    }

}