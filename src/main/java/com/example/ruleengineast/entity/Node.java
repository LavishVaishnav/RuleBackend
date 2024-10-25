package com.example.ruleengineast.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

public class Node {
    private String type; // 'operator' or 'operand'
    private Node left;   // Left child node (for operators)
    private Node right;  // Right child node (for operators)
    private String value;// Operand value, e.g., "age > 30"

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
